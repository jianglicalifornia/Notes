##database
===============


#### Common SQL commands

```
// bash terminal
mysql -u USERNAME -h HOSTNAME -p
mysql -u root -p		# login a local database server
mysqldump ghost | mysql ghost-main	# clone database; may need to add the root access and password setting
```

```
show databases;
```

- [MySQL: How to clone a database](https://makandracards.com/makandra/1605-mysql-how-to-clone-a-database) *working version*

### Postgresql

[move the data directory](https://stackoverflow.com/questions/37901481/postgresql-change-the-data-directory)

0. service postgresql stop
1. mkdir  mkdir /ssddata/postgresql_data_dir
2. sudo chown -R postgres:postgres  /ssddata/postgresql_data_dir
3. sudo -i -u postgres
4. /usr/lib/postgresql/9.5/bin/initdb  -D /ssddata/postgresql_data_dir
5. sudo vim /etc/postgresql/9.5/main/postgresql.conf 

