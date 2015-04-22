Mobile ios misc 
==============

## Network
- NSOutputStream 
	- (NSInteger)write:(const uint8_t *)buffer maxLength:(NSUInteger)len;
		- Doesn't guarantee all the data would be written. The number of data bytes are depending on the buffer space availability.
		- If the message could be long, using the following code.
		```
		        NSData *data = [[NSData alloc] initWithData:[message dataUsingEncoding:NSASCIIStringEncoding]];
		        unsigned long length = [data length];
		        uint8_t* bytes = (uint8_t*) [data bytes];
		        unsigned long position = 0;
		        while (position < length) {
		            unsigned long writtern = [_outputStream write:(bytes+position)
		                                               maxLength: length-position];
		            position += writtern;
		        }
		        if (position == length){
		            NSLog(@"upload successfully. %lu => %ld", (unsigned long)[data length], (long)position);
		        }else{
		            NSLog(@"upload failure. %lu => %ld", (unsigned long)[data length], (long)position);
		        }
		```

- [Network library](https://github.com/6david9/ImageTransfer)


##Sensors
- Two methods of writing sensor data reading.
	- Method 1: Start the sensor update in a queue directly. [Example](http://stackoverflow.com/questions/8737889/core-motion-gyroscope-360-degree-values)
		```Code example:
		[self.motionManager startGyroUpdatesToQueue:[NSOperationQueue mainQueue] withHandler:^(CMGyroData *gyroData, NSError *error) {
		}
		```
	- Method 2: Using the timer to read the sensor reading periodically. [Example](https://github.com/foundry/MagnetoMeter/blob/master/Magnetometer/MotionViewController.m)
	- Difference: Method 1 uses asynchronous call which get a more accurate reading while method 2 uses synchronous call. Method 2 makes the code more elegant and easy to maintain, while method 2 has problem in reading accumulative results, eg. CMRotationRate (gyro reading). So for accumulative results, it's better to use method 1. And for one time reading, method 2 seems a better choice.
	- [asynchronous example](https://github.com/pmanna/Gyroscope) runs a comparison between these two methods.

##Camera
- [AVFoundation to get the camera raw data](http://weblog.invasivecode.com/post/18445861158/a-very-cool-custom-video-camera-with)
	- Discussed the two methods for camera apps 
- [A (quasi-) real-time video processing on iOS](http://weblog.invasivecode.com/post/23153661857/a-quasi-real-time-video-processing-on-ios-in)
	- Customize the camera layer. Some points are wrong.
	- possible more suitable for live filtering
- [How to achieve a higher frame rate in the camera data set](http://stackoverflow.com/questions/20330174/avcapture-capturing-and-getting-framebuffer-at-60-fps-in-ios-7) 
- [GPU Image on iOS](http://stackoverflow.com/questions/6625888/are-the-core-image-filters-in-ios-5-0-fast-enough-for-realtime-video-processing/6628208#6628208)
	- Mentioned that [gpu frame work](http://stackoverflow.com/questions/8778117/video-filtering-in-iphone-is-slow) can do live filtering. 
	- [Git repo](https://github.com/BradLarson/GPUImage) Available in POD, worth a try.
- [QR Reader](http://www.appcoda.com/qr-code-ios-programming-tutorial/)
	
	
##Common knowledge (I am dumb.)
- [Load text file with NSBundle mainBundle](http://blog.csdn.net/duxinfeng2010/article/details/7698135)

##Interface
- [solo components](https://github.com/andreyvit/SoloComponents-iOS/tree/11b2d4a0b6187f231aef2499e46ad5e97571263b#readme)

##Developer License problem.
Create a certificate => Generate a CSR file and upload => Create a profile and download it.

## Distribute app for internal dogfood
- [iphone app: how to renew an expired distribution certificate through the iOS provisioning portal](http://stackoverflow.com/questions/7096254/iphone-app-how-to-renew-an-expired-distribution-certificate-through-the-ios-pro)
- [5 Options for Distributing Your iOS App to a Limited Audience](http://mobiledan.net/2012/03/02/5-options-for-distributing-ios-apps-to-a-limited-audience-legally/)
- [KockeyKit - open source tools](https://github.com/bitstadium/HockeyKit)
- [How to Distribute your iOS Apps Over the Air](http://aaronparecki.com/articles/2011/01/21/1/how-to-distribute-your-ios-apps-over-the-air)
- [Chinese version with pictures](http://www.minwt.com/ios/4457.html)
	- [cannot find the code signing entitlements in the options](http://stackoverflow.com/questions/1116963/dont-see-code-signing-entitlements-in-xcode-target-properties)
	- [How can I add an entitlements file to an XCode 4.5 project? ](http://stackoverflow.com/questions/12698506/how-can-i-add-an-entitlements-file-to-an-xcode-4-5-project)
	
- The Enterprise developer program can install the app through ad-hoc without UUID setting [link](http://stackoverflow.com/questions/16400347/distributing-beta-iphone-app-without-uuids)
	- for personal develop account, 
	
- Since iOS7, these uuid apps cannot get the true uuid through the public api call.
	- one good method to get the uuid is through: http://get.udid.io
	
	
## Tools
- for icons
	- [online tools](http://ticons.fokkezb.nl/)
	- [prepo](https://itunes.apple.com/us/app/prepo/id476533227?mt=12)
- for font
	- ObjC wrapper for the iconic fonts. [FontasticIcons](https://github.com/AlexDenisov/FontasticIcons)
- for logging
	- [CocoaLumberjack](https://github.com/CocoaLumberjack/CocoaLumberjack) a logging framework can log to  a file, console, or even a database.
- for app submitting
	- [privacy policy generator](https://www.iubenda.com/blog/2013/06/14/privacy-policy-for-ios-apps/)
	
	
	
# high performance semantic zooming

- [Semantic Zoom in iOS](http://monodeveloper.org/uncategorized/semantic-zoom-in-ios/)
	- used dynamic controller. good 
- [Thumbnail solution](http://stackoverflow.com/questions/14659650/uiscrollview-lazy-loading)
- [Basic knowledge about scroll viewer](http://www.raywenderlich.com/10518/how-to-use-uiscrollview-to-scroll-and-zoom-content)
- [Move the UITableView in its superview](http://stackoverflow.com/questions/21677268/uitableview-inside-uiscrollview-not-receiving-first-tap-after-scrollling)
- [Give pull-to-refresh & infinite scrolling to any UIScrollView with 1 line of code.](https://github.com/samvermette/SVPullToRefresh)
- [TLIndexPathTools](http://tlindexpathtools.com/)
- [Asynchronous image downloader with cache support with an UIImageView category](https://github.com/rs/SDWebImage)
- [SDWebImage vs FastImageCache)](https://bpoplauschi.wordpress.com/2014/03/21/ios-image-caching-sdwebimage-vs-fastimage/)