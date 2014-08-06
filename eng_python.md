python
===========

## Notebook
- Enter the notebook directory and run the service. `ipython notebook --pylab inline`


## IDE & Environment

- [Install python without sudo access](http://stackoverflow.com/questions/622744/unable-to-install-python-without-sudo-access)

- [summary methods of install third party library or package of python](http://www.crifan.com/summary_methods_of_install_third_party_library_or_package_of_python/)

- [IPython Notebook](http://mindonmind.github.io/2013/02/08/ipython-notebook-interactive-computing-new-era/)

- [Enthought - Scientific Computing Solutions](https://www.enthought.com/)


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