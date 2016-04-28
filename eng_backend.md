backend
====================


**Database**

- [Trouble shotting PostgreSQL](http://stackoverflow.com/questions/29937378/django-db-utils-operationalerror-could-not-connect-to-server)
	```
	It can be some issues:

	PostgreSQL is not running. Check it with sudo service postgresql status
	Your PostgresSQl is not running on port 5432. You can check it typing sudo netstat -nl | grep postgres
	You have something wrong trying to connect to your db like the username, the password or the databasename. Check that they are what postgres ask for you to connect it and that is the db_name that you want to access to.
	Problems with postmaster.pid in postgres. It can happen because of a shutdown unproperly done. It makes to remind a pid alive that doesn't allow your server start. To fix it you have to:

	 * rm /usr/local/var/postgres/postmaster.pid 
	 * pg_resetxlog -f /usr/local/var/postgres
	After this it should run properly if you make the runserver of postgres
	Help in Mac OSX: how to start postgresql server on mac os x
	```

**PostgreSQL**

- intallation on mac
	```
	For MAC:

	Install Homebrew
	brew install postgres
	initdb /usr/local/var/postgres
	/usr/local/Cellar/postgresql/<version>/bin/createuser -s postgres
	To start server at startup

	mkdir -p ~/Library/LaunchAgents
	ln -sfv /usr/local/opt/postgresql/*.plist ~/Library/LaunchAgents
	launchctl load ~/Library/LaunchAgents/homebrew.mxcl.postgresql.plist
	Now, it is set up, login using psql -U postgres -h localhost or use PgAdmin for GUI.

	By default user postgres will not have any login password.

	Check this site for more articles like this: https://sites.google.com/site/nitinpasumarthy/blog/installingpostgresonmac
	```

** Multiple machine deployment **

- [Pythonic remote execution](http://www.fabfile.org/)


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