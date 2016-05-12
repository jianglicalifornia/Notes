Java
===========

## Maven
##### Maven with Android

Project build error: Unknown packaging: apk,
- [FAQ in Chinese](http://my.oschina.net/huami/blog/175570)

if auto-install failed, install it manually. [Git](https://github.com/mosabua/maven-android-sdk-deployer)


create a maven android library project

##### Maven Dependancy
```mvn dependency:tree```


##### Maven JNI
- [Project template](https://github.com/gkubisa/jni-maven)

####Code coverage
- Maven, Surefire: `mvn surefire-report:report  `. Don't use that.
	
- Maven, Clover: `mvn clover2:instrument clover2:clover` [reference](https://confluence.atlassian.com/display/CLOVER/Clover-for-Maven+2+and+3+Quick+Start+Guide)

- Use JMockit: [tutorial in chinese](http://blog.csdn.net/chjttony/article/details/17838693)


###Server hosting

**Jetty**

- IDE configurations:
	- [如何使用Intellij + Maven + Jetty进行Java Web开发及部署](http://blog.csdn.net/lianyi0721/article/details/42521109)
- run mvn package to get the war file
- [Deploy websocket app to Jetty](http://zetcode.com/java/jetty/websocket/)
- [neat stand alone demo](https://github.com/reta/jetty-web-sockets-jsr356)
	- problem: invalid target release: 1.7 [link](http://stackoverflow.com/questions/19891423/invalid-target-release-1-7)

- [Jetty](https://git.corp.yahoo.com/JavaPlatform/yjava_jetty)
- [Developer source](http://developer.corp.yahoo.com/product/Jetty)
- [Jetty/Starting/Downloads](http://wiki.eclipse.org/Jetty/Howto/Install_Jetty)
- [Jetty document](http://eclipse.org/jetty/documentation/current/index.html)
- [用Eclipse+Maven+Jetty构建Java Web开发环境(综合几篇教程整合2014年版)](http://blog.csdn.net/u012510614/article/details/38059319)



**Encryption**

- [Secure WebSockets with Jetty](http://amilamanoj.blogspot.com/2013/06/secure-websockets-with-jetty.html)
- [Adding SSL Support to an Embedded Jetty Server](http://java.dzone.com/articles/adding-ssl-support-embedded)

- [用keytool创建Keystore和Trustsotre文件 ](http://zjumty.iteye.com/blog/1885356)



**Shell**

- Give other people access to my virtual machine: `yinst install admin/sudo-kasturit`
- Benchmark run from maven: `mvn exec:java -D exec.mainClass=com.yahoo.labs.es.client.BenchMark`