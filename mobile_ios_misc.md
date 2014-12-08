Mobile ios misc 
==============

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