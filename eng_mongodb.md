mongodb
====================

## Common commands to start mongodb:

1. check if mongodb is running: `ps aux |grep mongod`
2. start mongodb: `sudo /etc/init.d/mongod restart`
3. starting mongodb service to start at book and activate it:
	`sudo update-rc.d mongod on`
	`sudo /etc/init.d/mongod start`


## Problem diagnostic

1. Failed global initialization: FileNotOpen Failed to open "/data/mongod.log":  
    - `add sudo`
2. Remove the sudo permission requirement for /data/db: 
    - `sudo chown -R mongodb:mongodb /data/db`
3. [initandlisten] exception in initAndListen: 98 Unable to create/open lock file: /data/db/mongod.lock errno:13 Permission denied Is a mongod instance already running?, terminating 
    - `sudo chown -R mongodb:mongodb /data/db`

## Typical configration

1. dbpath:     `dbpath=/var/lib/mongodb`
2. where to log: `logpath=/var/log/mongodb/mongod.log`
3. [Mongodb cluster configuration](http://www.cnblogs.com/huangxincheng/archive/2012/03/04/2379755.html)
4. [MongoDB configuration](https://ruby-china.org/topics/454)

## MongoDB data query

```
show dbs
use one_db
db
db.collection
db.collection.count()
db.collection.find()
```