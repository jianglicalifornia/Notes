Android NDK 
==============

@[dev | android | c/c++]

Environment Set-up

- Don't use the Eclipse plugin - “Add native support”. Follow this [instuction](http://www.ntu.edu.sg/home/ehchua/programming/android/Android_NDK.html) instead. :-D 
    - Reason: With the new ADT 20, if the project has a jni folder or/and an Android.mk file the c++ nature is added by the plugin by default. [reference](http://stackoverflow.com/questions/11504258/how-to-remove-native-support-from-an-android-project-in-eclipse-because-eclipse)

- Use ~/.profile to store the environment setting.

References: [Android NDK 构建开发环境并运行第一个NDK示例](http://blog.csdn.net/ljxfblog/article/details/15808377)




======

## Performance profiling:


[Android ndk profiler](https://code.google.com/p/android-ndk-profiler/wiki/Usage)

Command: 
``` ~/Development/adt-bundle-mac-x86_64-20130717/android-ndk-r9b/toolchains/arm-linux-androideabi-4.8/prebuilt/darwin-x86/bin/arm-linux-androideabi-gprof obj/local/armeabi-v7a/libTrackoAudio.so ```


======

## Deployment:

[Install ARM translation for Genymotion](http://forum.xda-developers.com/showthread.php?t=2528952)

======

## Debugging:

Set the -g compiler flag in jnk/Android.mk to build the gdb-server

`LOCAL_CFLAGS := -g`

Build the native lib for debugging NDK_DEBUG=1

`ndk-build NDK_DEBUG=1`

Set the application debuggable in the manifest.

`android:debuggable=true`

Set a break point inside eclipse (before the NDK invoking)

Run ndk-gdb

`ndk-gdb --start`

Set breakpoint.

`b filename:linenumber`

continue GDB machine

`continue`

continue eclipse and then it would enter gdb break point


======

## Problem diagnostic:

```
03-03 13:46:10.459: E/AndroidRuntime(20255): java.lang.UnsatisfiedLinkError: Couldn't load tracko from loader dalvik.system.PathClassLoader[DexPathList[[zip file "/data/app/com.yahoo.labs.tracko-2.apk"],nativeLibraryDirectories=[/data/app-lib/com.yahoo.labs.tracko-2, /vendor/lib, /system/lib]]]: findLibrary returned null  
```
** Solution **: `delete the "armeabi-v7a" under libs, then do a clean rebuild`


## References

-[How to use ceres-solver library for Android-NDK](http://tech.sandyeggi.com/2013/10/using-ceres-solver-in-android-ndk.html)

- - -


