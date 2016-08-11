python
===========

## naming rules
- 文件名，包名，模块名，全小写字母，单词间用下划线连接。
- 类名 CapWords 约定。
- 函数名, 函数名应该是小写的，有必要的话用下划线来分隔单词提高可读性。
- self作为实例方法的第一个参数。cls作为类方法的第一个参数。
- 常量通常是模块级的定义，全部大写，单词之间以下划线分隔。例如MAX_OVERFLOW和TOTAL。

## python project design
- [Structuring Your Project](http://docs.python-guide.org/en/latest/writing/structure/)
- Reference to a sibiling directory: 
	- method 1: relative import through the relative path. this method doesn't work if you run the file separately rather than as a package.
	- method 2: the IDE doesn't support well for the intelligent typing. 
			```
			import os
			parentdir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
			os.sys.path.insert(0,parentdir)
			```
	- Better design: [import through package](http://blog.csdn.net/luo123n/article/details/49849649)


## default parameter with list


```
def generate_new_list_with(my_list=None, element=None):
    if my_list is None:
        my_list = []
    my_list.append(element)
    return my_list
```


## Enum in python

In a quick prototype project, using enum in the project is not really the best choice. As it will introduce issues in json encoding and decoding.
One easy hack is just define these enums in constant string. The string values maintain the readlibity and makes it easy to do json en/decoding.

## Python Setup.py

```
python setup.py build
python setup.py install
```

- [JSON Editor](http://cloudwall.me/etc/json-editor.html)

## Python virtual environment

- python virtual environment
	```
	mkdir myproject
	cd myproject
	virtualenv venv
	. venv/bin/activate   
	deactivate
	```
- common library dependancy : http://gestaltrevision.be/pdfs/workshops/python_summer_school_Mac.pdf

- `pip install -U numpy scipy scikit-learn` [scikit-learn](http://scikit-learn.org/stable/install.html)

- `pip install -U -r requirements.txt `

## Coding style
- [Code Like a Pythonista: Idiomatic Python](http://python.net/~goodger/projects/pycon/2007/idiomatic/handout.html)
- [PEP 8 - Style Guide for Python Code](https://www.python.org/dev/peps/pep-0008/)
- [Open Sourcing a Python Project the Right Way - project structure](https://jeffknupp.com/blog/2013/08/16/open-sourcing-a-python-project-the-right-way/)

- [python project template](https://github.com/audreyr/cookiecutter)
	- [A minimal template](https://github.com/wdm0006/cookiecutter-pipproject)

## Django
- [Install Django]()
- debug test: `python manage.py runserver 0.0.0.0:8000`
- Start a server at backend: 
	- start command: `nohup python manage.py runserver 0.0.0.0:8000`
	- stop command: check the process id of python related to to django and kill it

	```ps -ef|grep python
	kill -9 Process_id_no.```

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

## Pyplot

- [Class introduction](http://www.cnblogs.com/wei-li/archive/2012/05/23/2506940.html)


## Notebook
- Enter the notebook directory and run the service. `ipython notebook --pylab inline`
- run a public notebook server. `ipython notebook --ip=* --no-browser`
- authentication. [more details](http://mindonmind.github.io/2013/02/08/ipython-notebook-interactive-computing-new-era/)

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