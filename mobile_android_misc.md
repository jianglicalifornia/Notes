Misc - Android 
==============

## MultiDex application compiling

- [guidance in chinese. describe the way to get multidex.jar](http://blog.csdn.net/t12x3456/article/details/40837287)

- [good guidance in english](https://medium.com/@mustafa01ali/dexs-64k-limit-is-not-a-problem-anymore-well-almost-2b1faac3508)

## Gradle 
- [Gradle version 1.10 is required. Current version is 2.2.1. If using the gradle wrapper]
	- instead of down-grade the gradle version, updating the requirement is a better solution.

- [Gradle DSL method not found: 'android()'](http://stackoverflow.com/questions/26759755/error1-0-gradle-dsl-method-not-found-android)
- [error for runproguard()](http://tools.android.com/tech-docs/new-build-system/migrating-to-1-0-0) 


##  Speech recognition - Android

[How to Change Google Now Hotword on Android](http://phonetipz.com/how-to-change-google-now-hotword-on-android/)

testing speech recognition in android emulator.

- Install the virtual machine software: http://www.genymotion.com/   (You can maintain multiple virtual machine on one machine and this one is much faster than the Google’s one.)

- Download and install the following zips (just drag these files to the virtual machine and it would do the install automatically): 
	- ARM Translation Installer v1.1: http://goo.gl/JBQmPa
	- Google Voice Search 2.1.4.apk (contain the speech recognition libraries)  https://docs.google.com/file/d/0B5rZBNIQG5NWZHV0dWdGVmkzRG8/edit?pli=1 
	
	[reference](http://forum.xda-developers.com/showthread.php?t=2528952)

## ADB command

- Extract a file: `adb pull sdcard/log.file`
- Delete a file: `adb shell rm -r sdcard/log.file`
- Cat a file: `adb -d shell cat /sdcard/chirpproc.txt`


## Basic Logging code

```
	public static void appendlog(String text){
		File logFile = new File("sdcard/log.file");
		if (!logFile.exists())
		{
			try
			{
				logFile.createNewFile();
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try
		{
			//BufferedWriter for performance, true to set append to file flag
			BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true)); 
			buf.append(text);
			buf.newLine();
			buf.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
```

## Debugging for multithread app

Put the following code fragment in the beginning of doInBackground:

```android.os.Debug.waitForDebugger();```

Then when you set a breakpoint in that thread; eclipse will find it.

- - -


