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