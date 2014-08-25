OpenCV
===================

opencv with python support [reference](http://stackoverflow.com/questions/18729495/installing-opencv-with-python-module-on-centos-goes-wrong)

```
cmake -D CMAKE_BUILD_TYPE=RELEASE  -D MAKE_INSTALL_PREFIX=/usr/local -D BUILD_NEW_PYTHON_SUPPORT=ON  ..
```