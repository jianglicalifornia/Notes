AWS
============================

## New AWS init
- add public ssh key to remote server
	`cat ~/.ssh/id_rsa.pub | ssh user@hostname 'cat >> .ssh/authorized_keys'`
- copy all the ssh keys to remote server
	`scp -i XXXXXX.pem -r  ~/.ssh/  user@hostname:~/` (brute force method seems the best and simplest method)

## AWS toolkit

- [S3 sync tool](http://s3tools.org/s3cmd-sync)
	- download the library, configure the keys and pem file, use the command ```./s3cmd sync local  s3://bucketname``` to sync.

## Common commands

- check available disk space on aws: `df -h`
- check current directory available disk space: `df -k .`
- make an application start since boot
	<pre>
		sudo update-rc.d redis-server on
		sudo service redis-server restart
	</pre>
- remove an application from the auto-start list. [reference](http://positon.org/disable-a-service-with-update-rcd-under-debian-update-resistant)
	<pre>
		sudo update-rc.d -f redis-server remove
	</pre>
- mount a new volumn
	<pre>
		df -h
		sudo file -s /dev/xvdf
		sudo mkfs -t ext4 /dev/xvdf
		sudo file -s /dev/xvdf
		sudo mkdir /boot2
		sudo mount /dev/xvdf /boot2
		lsblk
		sudo mkdir /data
		sudo vim /etc/fstab  => insert: /dev/xvdf /data ext4 defaults,auto,noatime,noexec 0 0
		sudo mount -a
		df -k  => check if the ebs volumn was attached.
	</pre>
- common dependancy: 
	<pre>
		sudo apt-get install build-essential autoconf libtool pkg-config python-opengl python-imaging python-pyrex python-pyside.qtopengl idle-python2.7 qt4-dev-tools qt4-designer libqtgui4 libqtcore4 libqt4-xml libqt4-test libqt4-script libqt4-network libqt4-dbus python-qt4 python-qt4-gl libgle3 python-dev
	</pre>

- check the running process:
	<pre>
	    ps aux | grep remongo
	</pre>

- download files: `	scp -i ***.pem ubuntu@54.165.124.0:/var/lib/redis/dump.rdb /var/lib/redis/`

- start a service: `sudo service redis-server stop`

## Tips
- Don't start redis at startup. 
	- Sometimes redis need to load a large dump file, this will take a long time. As a result, the machine would be unreachable at that moment. 
	- Highly recommend to put the redis server on Amazon Elastic Cache

## Configuration
- [Getting started with Amazon EC2 API Tools](http://blog.kenyang.net/2014/05/getting-started-with-amazon-ec2-api.html)
- [Add EBS volumn](http://www.cnblogs.com/huang0925/p/3879542.html)
	- For error: `mount: mount point /data does not exist`, run `sudo mkdir /data`
	- Boot volumn path: /dev/sda1 
- [Mongodb on AWS EC2](http://docs.mongodb.org/ecosystem/platforms/amazon-ec2/)
- [Common commands in MongoDB](http://sling2007.blog.163.com/blog/static/847327132012911113042620/)

## Money money me
- [free aws credit](http://mooc.guokr.com/post/611730/)