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
3. Install mongodb on aws:
    - need to configure the dbpath to EBS
4. Install mongodb locally: [MongoDB configuration](https://ruby-china.org/topics/454)
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
    db.[collection]
    db.[collection].count()
    db.[collection].find()
    db.dropDatabase() // delete the database
    db.[collection].drop() // delete the collection
    db.getCollectionNames() //list collection names
    db.[collection].find( { city: "London" } ).skip( 20 ).limit( 20 ) // show the results from document 21 to 40.
    db.player_info.find({"pid":NumberLong("4294967295")}).count()
    ```

- data check and backup. [chinese guidance](http://www.jb51.net/article/40285.htm)

- check replicate set configurations. 
    - rs.status()
   
   
- Backup data.
    - [import and export](http://docs.mongodb.org/manual/core/import-export/) one handy way is do it through json. (it's actually bson rather than json)
    - use the bson package inside pymongo. pip install pymongo
    

- create text search index
    - > db.ttlsa_com.ensureIndex({"song":"text", "lyrics":"text"})
    - > db.ttlsa_com.ensureIndex({"$**": "text"})   
        - $**表示在所有的字符串字段上创建一个全文索引。
    - > db.ttlsa_com.ensureIndex({"song":"text"},{"weights":{"song": 2, "$**": 3}}) 也可以指定权重

- text search
    - db.command('text', 'collection', search='lamps')


## Pymongo interface

- [example](https://pypi.python.org/pypi/pymongo/)
- [full text search](https://www.youtube.com/watch?v=Wk6sucAgC8k)
- db.command('text', 'pin_details', search='lamps')
