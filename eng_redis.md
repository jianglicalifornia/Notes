redis
====================


## Common commands

- print all the keys: `keys **`
- check type of the key: `TYPE keyname`
- read the basic data type: `get keyname`
- read the set data value: `SMEMBERS keyname`
- read the list data value: `LRANGE keyname 0 -1`
- print the length of list: `LLEN keyname`
- print the element of the list: `LINDEX keyname 0`
- show all dbs: `info keyspace`

## Install Redis

- for ubuntu
	```
	sudo apt-get install -y redis-server
	sudo update-rc.d redis-server on
	sudo service redis-server restart
	redis-cli ping => verify if it works
	```
	
- the permission of dump.rdb:  `sudo chmod 640  dump.rdb`