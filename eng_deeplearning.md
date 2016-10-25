### Deep learning

- [Configure TensorFlow on Mac](https://github.com/stujo/tensorflow-what-is-it)
- FAQ docker command: 
	- `docker run -t -i gcr.io/tensorflow/tensorflow /bin/bash`
	- `docker run -p 8080:8080 -t -v   /Users/haojian/projects/bugbash_ml:/bugbash_ml -i   gcr.io/tensorflow/tensorflow  /bin/bash`
	-  ```-p 8080:8080``` maps the docker port to the local machine port.
	- `docker run -p 8080:8080 -t -v  /Users/haojian/projects/bugbash_ml:/bugbash_ml -i   bugbash_space  /bin/bash`
- Location of TensorFlow:
	- ```
		import site; site.getsitepackages()
			['/usr/local/lib/python2.7/dist-packages', '/usr/lib/python2.7/dist-packages']
	  ````