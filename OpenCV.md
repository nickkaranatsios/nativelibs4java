&lt;wiki:gadget url="http://jnaerator.googlecode.com/svn/wiki/adsense468x60.xml" border="0" width="468" height="60" /&gt;

# Introduction #

Quote from the [OpenCV Wiki](http://opencv.willowgarage.com/wiki/) : "_OpenCV (Open Source Computer Vision) is a library of programming functions mainly aimed at real time computer vision._"

# License #

BSD-style : [OpenCV License](http://opencvlibrary.svn.sourceforge.net/viewvc/opencvlibrary/trunk/opencv/doc/license.txt?view=markup)

# Downloads #

Sources available from [OpenCV's SourceForge Project](http://sourceforge.net/projects/opencvlibrary/).

Java wrappers with self-extracting binaries for MacOSX and Windows 32bits : [OpenCV.jar](https://github.com/ochafik/nativelibs4java/tree/master/libraries/OpenCV/OpenCV.jar)

# Building #

  * Download [OpenCV sources](http://sourceforge.net/projects/opencvlibrary/) and unzip / untar them
  * Put the following files in the top OpenCV directory :
    * [makeMacOSXFatBinaries.sh](https://github.com/ochafik/nativelibs4java/tree/master/libraries/OpenCV/makeMacOSXFatBinaries.sh) (MacOSX only)
    * [config.jnaerator](https://github.com/ochafik/nativelibs4java/tree/master/libraries/OpenCV/config.jnaerator)
  * Open a command-line shell and go to the top OpenCV directory
  * On MacOSX : ` sh makeMacOSXFatBinaries.sh ` to create fat binaries of OpenCV
  * ` java -jar jnaerator.jar `

# Quickstart #

Have a look at [JNA's frontpage](https://jna.dev.java.net/)

```
import cv.*; 
import cxcore.*; 
import highgui.*; 
import ml.*; 
import static cv.CvLibrary.*; 
import static  cxcore.CxcoreLibrary.*; 
import static  highgui.HighguiLibrary.*; 
import static  ml.MlLibrary*; 
import static opencv.OpenCV.*;

public class Test {
	public static void main(String[] args) {
		try {
			IplImage img = highgui.cvLoadImage(args[0], CV_LOAD_IMAGE_UNCHANGED);
			highgui.cvNamedWindow("Example1", CV_WINDOW_AUTOSIZE);
			highgui.cvShowImage("Example1", new CvArr(img));
			System.in.read();
			//HighguiLibrary.INSTANCE.cvWaitKey(0);
			cxcore.cvReleaseImage(new PointerByReference(img.getPointer(0)));
			highgui.cvDestroyWindow("Example1");
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
}
```