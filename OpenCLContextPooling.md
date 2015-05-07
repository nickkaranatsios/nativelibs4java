# Preface #
This technique was developed to take as much advantage as possible of an unknown, primarily retail, computer's capabilities.  99.9% of these machines have only 1 GPU, so pooling would seem not to be worth doing, but they do have a multi-core CPU (more later).  In the future, multi-GPU configurations might be far more common, so when I said 'as much advantage as possible', I am also including a machine population that does not even look like today's.

In fact, most of today's computers will never run OpenCL.  For those, I have written a version of my process as a completely native Java concurrent task.  The Java version is also used to verify that the OpenCL version, using the GPU's implementation, produces the same result.  A Java version also makes OpenCL completely optional, which probably the
only way a commercial application could use it for the next few years.

Finally before getting started, the other way of using multiple GPU's, namely, with OpenCL synchronization within a single context, is better when:
  * Response time is required, like video or other streams that require an N per second.
  * The GPU's are known to either always be the same or very similar in capability.
  * There are few, if any constraints that would complicate splitting up the work, like barriers, use of local memory, or techniques like reductions.
  * A requirement that the output must be generated in the order it was submitted.

# Features #
Running a pool of contexts is all about throughput, massive throughput. You might need about 500 iterations of large work dimension kernel(s), before it makes sense.  I am running about 7600 iterations, of a kernel set of 3.

Heterogeneous GPU's are not an issue with this approach. The output order cannot be guaranteed, however.  Take certain models of the Macbook Pro, for instance.  They have a
1250 MHz, 32 processor GPU & a 1100 MHz, 16 processor GPU.  With each working at it's own pace, the slower one is going to get lapped, causing data not to be FIFO.  On the
other hand, the fast one is not dragged down to the slower ones level.  This was developed on such a system.

Putting all the OpenCL kernel set iterations into a single Java queue puts the synchronization at a higher level than OpenCL, and makes it possible to develop the kernel set while being blissfully unaware that it could be executing simultaneously.  Not only that, but well tested Java libraries handle it.  When using OpenCL's synchronization, kernels can be more difficult to develop & change.  The Java queuing part, which I acknowledge is not trivial, can be made fairly generic.  I am not going to publish my API though.

# Parts List #
  * The first part needed is an array of contexts, where each has a single device in it's command queue.  The # of contexts equals the # of GPU's.
  * A simple class which maintains a pool of FloatBuffer objects, all of a size specified in its constructor.  Each hold the output of an iteration of a kernel set.  There are methods: getMemory(), returnMemory(FloatBuffer) & releasePool(), which sets the internal members to null.  These methods all need to be declared synchronized.

# Assembly #
You need a class which implements the ExecutorService interface.  The easiest way is to sub-class java.util.concurrent.ThreadPoolExecutor.  You can use the same arguments as
Executors.newFixedThreadPool(nThreads) does for super(), where the number of threads == the number on contexts. Let's call this class ContextPool. The context array & output
pool are members, and should probably be assigned in the constructor, so they can be final.

FYI, newFixedThreadPool() is a single statement convenience method, which you can look up, but I am not doing to show Sun source marked proprietary.

There needs to be methods to manage the members during initialization/destruction & during execution:
## Initialization ##
  * The contexts need a method to create & compile kernels, passing source & options.  This method performs this on each context, in a loop.
  * The contexts also need methods to create/load globals & images, plus device only buffers, done again by calling each context's method in a loop.

## Destruction ##
  * override shutdown() & shutdownNow() methods.  Call the super version of each, and also call the releaseContext() method of each context in a loop.  The releasePool() method of the output pool needs called as well.

## Execution ##
  * There needs to be methods to retrieve/assign a context to a member of the thread pool, and also one to return it.  These methods both need to be synchronized. A simple
boolean array member, busy, member works to keep track.  You could use the exotic ThreadLocal thing somehow instead, but I never tried it.
  * You need wrapper methods for getMemory(), returnMemory(FloatBuffer), so output buffer pool can be private.

# Application Level #
You need a class which actually executes your kernel sets.  Sub-class ContextPool, and call it MyContextPool.  You could have a static method instance(), which does whatever it
does to get the context array, determine the max size of the output buffers, then call the constructor.  After that, instance() can call all the methods for creating all the kernels & loading all the buffers/images, with the value it is going to return.

There needs to be a method in MyContextPool something like:
```
public FloatBuffer runKernels(Object input){
   Context assignedContext = null;
   try{
      assignedContext = assignContext();
      // set the arguments for kernel 1 on assignedContext, based on input
      // run kernel 1 on assignedContext 

      // set the arguments for kernel 2 on assignedContext, based on input
      // run kernel 2 on assignedContext 

      ...

      // wait till the last minute to request a Memory object from the pool
      FloatBuffer outputBuf = getMemory();
      // read (blocking) from device buffer to host on assignedContext, putting in outputBuf 
      return outputBuf;
   }finally{
       returnContext(assignedContext);
   }
}
```

Now you need a class, call it MyApp.  MyApp needs a member that is an instance of MyContextPool, call it gpuPool.  MyApp also needs another thread pool dedicated to reading each output buffer back into the VM, and any post processing.  This way when the gpuPool thread finishes runKernels() it's work is done. The thread is immediately available to work the next Task on the queue, keepin those GPU's running hot. See, even if you only have 1 GPU, you get a benefit.  The mult-core CPU helps keep from bottle necking on the post processing. Let's call the second thread pool, resultsPool.

resultsPool should be created using something similar to newFixedThreadPool() with Runtime.getRuntime().availableProcessors() as the # of threads, but with an important change, acting as a governor.  A LinkedBlockingQueue object is instanced in newFixedThreadPool(), but no arg for max queue size is specified, meaning unlimited queue size.  If the combined power of the GPU's is too great for the CPU's to keep up with the post processing, it could be curtains because each task in the resultsPool queue needs a FloatBuffer. You probably need to play with this setting, maybe 10 **num of CPU processors.  Setting to 1 early in dev, might not be a bad idea.**

# Finally #
MyApp should have a Runnable class inside of it that can be used the first time by gpuPool & the second time by resultsPool.  Something like:
```
class Task implements Runnable{
   private final Object input;
   private volatile FloatBuffer outputBuf;

   public Task(Object input){
      this.input = input;
   }

   public void run(){
      try{
         if (outputBuf == null){
             // first pass, already running on one of the ContextPool Threads
             outputBuf = gpuPool.runKernels(input);
             resultsPool.submit(this);
         }
         else{
            postProcess();
            returnMemory(outputBuf);
         }
      }catch(Exception ex){
         ex.printStackTrace();
      }
   }

   private void postProcess(){
      ...
   }
}
```
Somewhere in MyApp you need a loop to instance each Task and put it in the gpuPool queue:
```
   for (){
      gpuPool.submit( new Task(obj) );
   }
```
This should execute very fast, even for like a 10 level nested for, sub-second.

# Epilogue #
It should be noted that the Runnable can be replaced with a Callable, and Objects could be returned by postProcess(), as well as making it easy for bubbling up Exceptions.  I
do this, but I thought it made it more difficult to understand.

For more info
http://www.javaconcurrencyinpractice.com/

(page kindly contributed by  Jeffrey C Palmer)