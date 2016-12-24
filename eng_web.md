Web
===========

## web deployment.

- [使用Tornado+Nginx部署Django的一种尝试](http://fendou.org/post/2012/06/01/tornad-nginx-django/)


## Lightweight webserver.
- `python -m SimpleHTTPServer` The local directory would be the web directory.
	- super simple and fast. but doesn't support audio/video streaming.
- nodejs solution: `npm install http-server -g`; `http-server -p 8000`
- `twistd -no web --path=.`


## programmable CSS

- tool: Koala
- [SASS用法指南](http://www.ruanyifeng.com/blog/2012/06/sass.html)

##Security

##Jetty

##Apache

- [How to install apache and php on Mac](http://machiine.com/2013/how-to-install-apache-and-php-on-a-mac-with-osx-10-8-mamp-part-1/)
- [在OS X 10.8 Mountain Lion上配置Web服务器（Apache+PHP）](http://blog.shengbin.me/posts/os-x-10.8-mountain-lion-setup-web-server-apache-php/)
- [Nice note regarding config](http://note.rpsh.net/posts/2013/11/27/osx-10-9-apache-server-php-mysql)
- [apache on mac](http://osxdaily.com/2012/09/02/start-apache-web-server-mac-os-x/)



##PHP
-[Write Post data to file with PHP](http://stackoverflow.com/questions/4742898/write-post-data-to-file-with-php)
- [Upgrade the default php in mac](https://www.computersnyou.com/68/how-to-upgrade-php-in-mac-osx-compiling-from-source/)
- [Multiple PHP version](http://getgrav.org/blog/mac-os-x-apache-setup-multiple-php-versions)
- manually install the php:
```./configure  --with-apxs2=/usr/sbin/apxs   --with-mysql   --with-gd   --with-jpeg-dir  --enable-gd-native-ttf    --with-freetype-dir
```
- [ssh in localhost](https://plus.google.com/+FrancoisBeaufort/posts/5rWjum26uVY)


##Chrome extension
- [Sending Messages Between the Background and the Content Script of a Chrome Extension](http://willvk.blogspot.com/2013/05/sending-messages-between-background-and.html)

**AWS**


for amazon normal linux machine
```
yum install lapack lapack-devel blas blas-devel
pip install numpy
pip install scipy
```

for ubuntu
```
sudo apt-get install python-numpy python-scipy python-matplotlib ipython ipython-notebook python-pandas python-sympy python-nose
```




