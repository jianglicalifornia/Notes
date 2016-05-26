video editing
=================


- [How Content-Aware Fill can help with Video](http://tv.adobe.com/watch/short-and-suite/how-contentaware-fill-can-help-with-video/)



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
	```