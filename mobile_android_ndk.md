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


- - -


