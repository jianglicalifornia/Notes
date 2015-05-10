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


## ADB command

- Extract a file: `adb pull sdcard/log.file`
- Delete a file: `adb shell rm -r sdcard/log.file`
- Cat a file: `adb -d shell cat /sdcard/chirpproc.txt`




## Debugging for multithread app

<pre>
Put the following code fragment in the beginning of doInBackground:

```android.os.Debug.waitForDebugger();```

Then when you set a breakpoint in that thread; eclipse will find it.
</pre>



## Maven/eclipse compatibility


>Source directory difference error.
Project Property -> Java Build Path -> Source -> Add Foler /src/main/java -> remove the conflicting one.

- [Can't import library project into android studio project](http://stackoverflow.com/questions/24279294/cant-import-library-project-into-android-studio-project)

- [Maven Gradle Tricks](http://www.alonsoruibal.com/my-gradle-tips-and-tricks/)



## Examples
- [multi-touch](https://github.com/thuytrinh/android-collage-views)
- [Tabbed application](http://blog.csdn.net/shulianghan/article/details/18233209)


## Basic Logging code

<pre>
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
</pre>

- - -


