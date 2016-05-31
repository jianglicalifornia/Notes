###Docker

- for projects with dockerfile already:
	- `docker build -t  pyannote-video .`  #pyannote-video is the docker image name
	- `sudo docker run -d -p 8090:8080 pyannote-video`
	- After few seconds, open http://<host>:8090 to see the welcome page.
		
		
		
- install docker on aws ubuntu 
	- [Docker install on EC2 Ubuntu 14.04](http://www.bogotobogo.com/DevOps/Docker/Docker_Install_On_EC2_Ubuntu.php)
	- [Official guidance](https://docs.docker.com/linux/step_one/)