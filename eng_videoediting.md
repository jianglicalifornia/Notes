video editing
=================


### FFMPEG

- Get the first 100 seconds from a video: ```ffmpeg -i  /Users/haojian/projects/testvideo/S01E01.mkv  -t 100   S01E01_scaled.mp4```


- [How Content-Aware Fill can help with Video](http://tv.adobe.com/watch/short-and-suite/how-contentaware-fill-can-help-with-video/)

- FFMPEG additional libraries in Ubuntu: 
	- 
	```
	sudo sudo apt-get install -y     libavformat-dev libavcodec-dev libavdevice-dev     libavutil-dev libswscale-dev libavresample-dev
	```

- Count the number of output frames: 
	- `ffmpeg  -ss 182.25 -t 9.699   -i /Users/haojian/projects/testvideo/raw/S01E01_scaled.mp4  -r 5 %3d.jpg`
		- the number of output images would be around `round(duration * r + 2)`
		- However, the exact number depends on the starting point and if the last frame falls inside the range. 
		- Still no good way to resolve that yet.

- [ImageCompression format](http://www.imagemagick.org/script/command-line-options.php#compress)

- [HTML5 video converting](https://www.imarc.com/blog/ffmpeg)
	- `ffmpeg -i original.mp4 -c:v libx264  homepage.mp4`
	
	
### Paper demo video generation

1. premiere export. set the bps to around 1.
2. run a ffmpeg to convert the video into lib264 so it's web friendly. `ffmpeg -i  tutorial_internetbps.mp4  -c:v libx264   tutorial_internetbps_html5.mp4`

### Build animated gifs from video

- [pymovie](http://zulko.github.io/blog/2014/01/23/making-animated-gifs-from-video-files-with-python/)


### Shot detection configuration

- when the environment doesn't met, try aptitude instead of "apt-get"
	- don't accept the initial solution and then choose downgrade. 

### Performance in video decoding

There are multiple ways to extract frames from a video. However the speed varies significantly.
For the same video (1 hour length, around 460 MB, mp4 format), 


```
    success, frame = videoCapture.read()
    while success:
         success, frame = videoCapture.read()
```

FPS at around 5.


the fps of using ffmpeg would be at around 160~250 fps.

Use the video in mkv or similar format will also reduce the fps. (say 30fps with ffmpeg for mkv format.)



- [Fastest way to extract frames using ffmpeg?](http://stackoverflow.com/questions/10957412/fastest-way-to-extract-frames-using-ffmpeg)
	- ```
	time for i in {0..39} ; do ffmpeg -accurate_seek -ss `echo $i*60.0 | bc` -i input.mp4   -frames:v 1 period_down_$i.bmp ; done
	time for i in 1 5 6 7 9 90; do ffmpeg -accurate_seek -ss `echo $i*60.0 | bc` -i S01E01_scaled.mp4   -frames:v 1 period_down_$i.jpg ; done
	
	```
	
	
### Extract video meta information

- through opencv
	```
    videoCapture = cv2.VideoCapture(scaledvideo)
    fps1 = videoCapture.get(cv2.cv.CV_CAP_PROP_FPS)
    framecount2 = videoCapture.get(cv2.cv.CV_CAP_PROP_FRAME_COUNT)
    print duration1 * fps1, framecount2, fps1

    size = (int(videoCapture.get(cv2.cv.CV_CAP_PROP_FRAME_WIDTH)),
            int(videoCapture.get(cv2.cv.CV_CAP_PROP_FRAME_HEIGHT)))
	```