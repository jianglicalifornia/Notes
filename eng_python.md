python
===========

## Django

##Coding tricks

**MultiDimension Dictionary**

2D + 1D lookup table

```
d3_dict[ (fileinfos[0], fileinfos[1], fileinfos[4] )] = np.array([])
if (fileinfos[0], fileinfos[1], fileinfos[4]) in d3_dict:
 	print "exist"
```

3D lookup

```
d3_dict[fileinfos[0]][fileinfos[1]][fileinfos[4]] = np.array([])
if fileinfos[0] in d3_dict and fileinfos[1] in d3_dict[fileinfos[0]] and fileinfos[4] in d3_dict[fileinfos[0]][fileinfos[1]]:
	print "exist"
```


**Close pyplot figure using the keyboard on Mac OS X**

```
plt.show()

=>

plt.show(block=False)
input("Hit Enter To Close")
plt.close()

```


## Notebook
- Enter the notebook directory and run the service. `ipython notebook --pylab inline`


## PackageManagement
```
sudo pip install nose
sudo pip install hg+http://bitbucket.org/pygame/pygame
```


## IDE & Environment

- [Install python without sudo access](http://stackoverflow.com/questions/622744/unable-to-install-python-without-sudo-access)

- [summary methods of install third party library or package of python](http://www.crifan.com/summary_methods_of_install_third_party_library_or_package_of_python/)

- [IPython Notebook](http://mindonmind.github.io/2013/02/08/ipython-notebook-interactive-computing-new-era/)

- [Enthought - Scientific Computing Solutions](https://www.enthought.com/)


## Upgrade python version

[Install / update to Python 2.7 and latest Pip on EC2 Amazon Linux](http://www.lecloud.net/post/61401763496/install-update-to-python-2-7-and-latest-pip-on-ec2)

```
sudo rm /usr/bin/python
sudo ln -s /usr/bin/python2.7 /usr/bin/python 
sudo ln -s /usr/local/bin/python2.7  /usr/bin/python  //depends on the system.

```

## Share python 
```
/usr/local/lib/python2.7/config/libpython2.7.a:  could not read symbols: Bad value

Solutions: need ./configure  --enable-shared to install python


python: error while loading shared  libraries: libpython2.7.so.1.0: 
  cannot open shared object file: No such file or
  
Solutions: 
	vim /etc/ld.so.conf.d/python2.7.conf
	加入内容：
	/usr/local/lib
	保存退出后运行：
	ldconfig 
	
	

```

## Install python on Grid or Gateway.

Work around the no root access problem by installing python in a user directory.

Install python:

```
wget http://www.python.org/ftp/python/2.7.6/Python-2.7.6.tgz
tar -xzf Python-2.7.6.tgz  
cd Python-2.7.6
 
mkdir /home/haojian/.local

make clean
./configure --prefix=/home/haojian/.local
make
make install
/homes/haojian/.local/bin/python
```

Python would be at ``home/haojian/.local/bin/python``

Similarly if you have scripts (eg. CGI) that require your own user version of Python you have to tell them explicitly:

``#!/home/haojian/.local/bin/python``

Then install pip:

``` /homes/haojian/.local/bin/python get-pip.py  ```

Pip would be at ``` /homes/haojian/.local/bin ``` 

Install numpy: ``` ./pip install numpy ```