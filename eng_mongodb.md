mongodb
====================

1. check if mongodb is running: `ps aux |grep mongod`
2. to start mongodb: `sudo /etc/init.d/mongod restart`
3. Failed global initialization: FileNotOpen Failed to open "/data/mongod.log":  "add sudo"

4. starting mongodb service to start at book and activate it:
	`sudo update-rc.d mongod on`
	`sudo /etc/init.d/mongod start`

5. Remove the sudo permission requirement for /data/db: `sudo chown -R mongodb:mongodb /data/db`


# e.g., if the parent directory isn't mutable by the mongodb user.
dbpath=/var/lib/mongodb
#dbpath=/data/db

#where to log
logpath=/var/log/mongodb/mongod.log
#logpath=/data/mongod.log



 [initandlisten] exception in initAndListen: 98 Unable to create/open lock file: /data/db/mongod.lock errno:13 Permission denied Is a mongod instance already running?, terminating

sudo chown -R mongodb:mongodb /data/db

- [Mongodb cluster configuration](http://www.cnblogs.com/huangxincheng/archive/2012/03/04/2379755.html)
- [MongoDB configuration](https://ruby-china.org/topics/454)

## Commands in Mongo

```
show dbs
use one_db
db
db.collection
db.collection.count()
db.collection.find()
```