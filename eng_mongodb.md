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
5. Re-init mondogb replicate set. 
    - [更换复制集节点](http://docs.mongoing.com/manual-zh/tutorial/replace-replica-set-member.html)
    - [移除复制集的节点](http://docs.mongoing.com/manual-zh/tutorial/remove-replica-set-member.html)
    - [Change Hostnames in a Replica Set](http://docs.mongodb.org/manual/tutorial/change-hostnames-in-a-replica-set/)

6. Default configuration file: 
    - `/etc/mongod.conf`

## MongoDB data query

- enter "mongo" to enter interactive terminal.

    ```
    rs.slaveOk()
    show dbs
    use one_db
    db
    db.collection
    db.collection.count()
    db.collection.find()
    ```

- data check and backup. [chinese guidance](http://www.jb51.net/article/40285.htm)

- check replicate set configurations. 
    - rs.status()
   
   
- Backup data.
    - [import and export](http://docs.mongodb.org/manual/core/import-export/)
    - export data:
        - f
    - import data: