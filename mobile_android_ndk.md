Android NDK 
==============

@[dev | android | c/c++]

====
**System.currentTimeMillis() in C**

```
#include <stdio.h>
#include <sys/timeb.h>
 
int main()
{
  struct timeb tmb;
 
  ftime(&tmb);
  printf("tmb.time     = %ld (seconds)\n", tmb.time);
  printf("tmb.millitm  = %d (mlliseconds)\n", tmb.millitm);
 
  return 0;
}
```

========






======

## Performance profiling


[Android ndk profiler](https://code.google.com/p/android-ndk-profiler/wiki/Usage)

Command: 
``` ~/Development/adt-bundle-mac-x86_64-20130717/android-ndk-r9b/toolchains/arm-linux-androideabi-4.8/prebuilt/darwin-x86/bin/arm-linux-androideabi-gprof obj/local/armeabi-v7a/libTrackoAudio.so ```


======

## Deployment

Environment Set-up

- Don't use the Eclipse plugin - “Add native support”. Follow this [instuction](http://www.ntu.edu.sg/home/ehchua/programming/android/Android_NDK.html) instead. :-D 
    - Reason: With the new ADT 20, if the project has a jni folder or/and an Android.mk file the c++ nature is added by the plugin by default. [reference](http://stackoverflow.com/questions/11504258/how-to-remove-native-support-from-an-android-project-in-eclipse-because-eclipse)

- Use ~/.profile to store the environment setting.

References: [Android NDK 构建开发环境并运行第一个NDK示例](http://blog.csdn.net/ljxfblog/article/details/15808377)

[Install ARM translation for Genymotion](http://forum.xda-developers.com/showthread.php?t=2528952)

======

## Debugging

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

## Problem diagnostic

```
03-03 13:46:10.459: E/AndroidRuntime(20255): java.lang.UnsatisfiedLinkError: Couldn't load tracko from loader dalvik.system.PathClassLoader[DexPathList[[zip file "/data/app/com.yahoo.labs.tracko-2.apk"],nativeLibraryDirectories=[/data/app-lib/com.yahoo.labs.tracko-2, /vendor/lib, /system/lib]]]: findLibrary returned null  
```
** Solution **: `delete the "armeabi-v7a" under libs, then do a clean rebuild`

```
Couldn't resolved OpenSL ES types and methods```

** Solutions **: `project -> property->C/C++ General->Code Analysis-> use project settings -> uncheck following boxes: method cannot be resolved, symbol is not resolved.`

## Ceres 

** Overview to setup in NDK environment **

```
1. Create Android project and add native support.
2. Copy the Android.mk & Application.mk to JNI directory.

Android.mk
`LOCAL_PATH := $(call my-dir)
LOCAL_ALLOW_UNDEFINED_SYMBOLS := true

include $(CLEAR_VARS)

LOCAL_MODULE := ceres
LOCAL_SRC_FILES := libceres.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)

LOCAL_C_INCLUDES += /Users/haojian/Downloads/eigen-eigen-6b38706d90a9
LOCAL_C_INCLUDES += /Users/haojian/Downloads/ceres-solver-1.7.0/include
LOCAL_C_INCLUDES += /Users/haojian/Downloads/ceres-solver-1.7.0/include/internal/ceres
LOCAL_C_INCLUDES += /Users/haojian/Downloads/ceres-solver-1.7.0/internal/ceres/miniglog

LOCAL_MODULE := CeresTest
LOCAL_SRC_FILES := CeresTest.cpp


LOCAL_STATIC_LIBRARIES = ceres
LOCAL_LDLIBS += -llog -ldl
include $(BUILD_SHARED_LIBRARY)`

Application.mk
`# Build both ARMv5TE and ARMv7-A machine code.
#APP_ABI := all


APP_CPPFLAGS += -fno-exceptions
APP_CPPFLAGS += -fno-rtti

# Don't use GNU libstdc++; instead use STLPort, which is free of GPL3 issues.
APP_STL := stlport_shared
APP_ABI := armeabi-v7a`

3. Reconfigure the path in Android.mk to ceres source code, eigen source code and libceres.a library.
(The latest ceres version 1.8.0 doesn’t work yet. I used the 1.7.0.)
```

** Problem in building Ceres on Android **

`Eigen/Core couldn't found.` 

```
Download Source from Eigen official website, and compile it with the following command.
EIGEN_PATH=/home/keir/src/eigen-3.0.5 ndk-build -j
```


## error in compiling Ceres

```
type { %"class.Eigen::PlainObjectBase.44" }Broken module found, compilation aborted!
Stack dump:

```


## Code 
- [File Opertion in NDK](http://stackoverflow.com/questions/1992953/file-operations-in-android-ndk)

## References

- [How to use ceres-solver library for Android-NDK](http://tech.sandyeggi.com/2013/10/using-ceres-solver-in-android-ndk.html)

- [Using Eclipse for Android C/C++ Development](http://mhandroid.wordpress.com/2011/01/23/using-eclipse-for-android-cc-development/
(This method works for C++ but doesn't works for C development)

- - -


