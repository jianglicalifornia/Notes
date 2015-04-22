backend
====================


**Links**

- [The WhatsApp Architecture Facebook Bought For $19 Billion](http://highscalability.com/blog/2014/2/26/the-whatsapp-architecture-facebook-bought-for-19-billion.html)
- [AWS setup](http://www.cnblogs.com/deltacat/p/3294865.html)

**crawl**

- [Pyspider](https://github.com/binux/pyspider)
	- pycurl problems in compiling: 
		- if  has some problem, run ``curl --version`` to see the version first
		
			```
			240  curl --version
  			241  sudo -E pip uninstall pycurl
  			242  export PYCURL_SSL_LIBRARY=nss
  			243  sudo -E pip install pycurl
			```
		- "Could not run curl-config": 
			``` sudo yum install curl curl-devel ``` 
			
		- "fatal error: libxml/xmlversion.h: No such file or directory ":
			`` sudo yum install libxml2-devel libxslt-devel python-devel
 ``
		
**EC2**

- [Django + Python2.7 + Apache setup for AWS EC2 - LINUX](https://gist.github.com/havencruise/8307140)
- [Apache MySQL + PYTHON ON ec2](http://fstoke.me/blog/?p=3708)
- [在Amazon的EC2上部署nginx+web.py](http://pinkyjie.com/2011/04/09/build-nginx_webpy_on_amazon_ec2/)

- AWS common products
	- S3: File storage, FTP
	- EC2: Serve website, run different code.
	- CloudFront: SSN
	
	
##Websocket
- [libwebsockets (c)](https://github.com/warmcat/libwebsockets)
	- lightweight websocket
- [pywebsocket](https://code.google.com/p/pywebsocket/)