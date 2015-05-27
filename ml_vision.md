Vision
===================

##FFmpeg

- convert videos to images and convert back:
```
ffmpeg -r 23.98 -start_number 1 -f image2 -i "img_series_%06d.png" -vcodec mpeg4  ../back_video.avi
ffmpeg -i video.avi "img_series_%06d.png"
```


- separate the audio and video
	<pre>
		1. Extract video stream
		ffmpeg -i input.flv -c:v copy -an output.m4v

		2. Extract audio stream
		ffmpeg -i input.flv -c:a copy -vn -absf aac_adtstoasc output.m4a
		if "format error": 
		ffmpeg -i myvideo.ts -c:a copy -vn -absf aac_adtstoasc output.m4a

		3. Edit audio track in eg. Audacity

		4. Build new FLV file by combining original video stream + edited
		audio stream:
		ffmpeg -i output.h264 -i output.aac new.flv

	</pre>	
－ [split video into specific length](http://superuser.com/questions/525210/splitting-an-audio-file-into-chunks-of-a-specified-length)
	
- [FFMPEG extract intra-frames I,P,B frames](http://superuser.com/questions/604858/ffmpeg-extract-intra-frames-i-p-b-frames)
	- export the image of the change in motion
	- [Understanding H.264 Encoding Parameters - I, P and B-frames](http://www.streaminglearningcenter.com/articles/producing-h264-video-for-flash-an-overview.html?page=4)
	- [I,P，B帧和PTS，DTS的关系](http://www.cnblogs.com/qingquan/archive/2011/07/27/2118967.html)
	- [Macroblocs](http://zh.wikipedia.org/wiki/%E8%A6%96%E8%A8%8A%E5%A3%93%E7%B8%AE%E5%9C%96%E5%83%8F%E9%A1%9E%E5%9E%8B)
	- [Semantic and Generative Models for Lossy Text
	Compression](http://compression.ru/download/articles/text/witten_1994cj_lossy_text_compression.pdf)
	- Display frame by frame details: `ffmpeg -debug vis_mb_type -i output.m4v output.mp4`
		- [Explanation of debugging script](http://trac.ffmpeg.org/wiki/Debug/MacroblocksAndMotionVectors)

- [audio format conversion](http://linuxconfig.org/ffmpeg-audio-format-conversions)
	- convert m4a to mp3: `ffmpeg -i input.m4a -acodec libmp3lame -ab 128k output.mp3`
	- convert mp3 to wav: `ffmpeg -i song.mp3 -acodec pcm_u8 -ar 22050 song.wav`
- [How to speed up / slow down a video](https://trac.ffmpeg.org/wiki/How%20to%20speed%20up%20/%20slow%20down%20a%20video)
- [19 ffmpeg commands for all needs](http://www.catswhocode.com/blog/19-ffmpeg-commands-for-all-needs)
- [How can I remove multiple segments from a video using FFmpeg?](http://superuser.com/questions/681885/how-can-i-remove-multiple-segments-from-a-video-using-ffmpeg)
- [FFmpeg filtering](http://trac.ffmpeg.org/wiki/FilteringGuide)
- [Audio editing - sentence by sentence](http://www-ie.meijo-u.ac.jp/~banno/spLibs/spwave/index.html)
- [How to install ffmpeg](http://www.renevolution.com/how-to-install-ffmpeg-on-mac-os-x/)

- [Create a video slideshow from images](https://trac.ffmpeg.org/wiki/Create%20a%20video%20slideshow%20from%20images)

- install ffmpeg through brew:
	- `brew install ffmpeg --with-fdk-aac --with-ffplay --with-freetype --with-frei0r --with-libass --with-libvo-aacenc --with-libvorbis --with-libvpx --with-opencore-amr --with-openjpeg --with-opus --with-rtmpdump --with-schroedinger --with-speex --with-theora --with-tools --with-openssl  --with-libx264 `

- default frame rate
	```
	ffmpeg -f image2 -framerate 25 -i nfl_commercials_%d.jpg video.mpg
	```

- lower frame rate
	``` 
	ffmpeg -framerate 10 -i nfl_commercials_%*.jpg  -c:v libx264 -r 30 -pix_fmt yuv420p out.mp4
	```
- ffmpeg -framerate 6 -i nfl_commercials_%*.jpg  -c:v libx264 -r 30 -pix_fmt yuv420p out.mp4


- download video from a common url:
	<pre>
		ffmpeg -i "https://ci-49b6510e88-42e4a238.http.atlas.cdn.yimg.com/sincitysaints/4/6/dbc16b22-d5f4-4bc6-9ab8-447484a5e2a3_QuQjX_8hXJJ62g-FESrr3tAvEjPvqX3d_gz4XmJ09dt1IfaoUQgDa_62LV2ztADQUG9OfSpb7do-_3_0.m3u8?a=sincitysaints&b=4950&ib=sapi&m=application%2fvnd.apple.mpegurl&mr=0&ns=ps&ps=31ncrahal4ltq&x=1432064571&s=3160060f9c94a8d0de8b3263d915bca5"  -c copy "myvideo.ts"
	</pre>

- [Write text on images](https://gist.github.com/haojian/4f5183db8739de5eadf0)

## OpenCV

- install opencv step by step
	- [install opencv on mac](http://mac-opencv-projects.blogspot.com/2014/01/installing-opencv-on-mac-os-x-1091.html)
	- [install opencv through brew](https://jjyap.wordpress.com/2014/05/24/installing-opencv-2-4-9-on-mac-osx-with-python-support/)
	- [opencv with python support](http://www.daveperrett.com/articles/2010/12/14/face-detection-with-osx-and-python/)
		- [reference](http://stackoverflow.com/questions/18729495/installing-opencv-with-python-module-on-centos-goes-wrong)
	- install through brew is highly recommended
		- for problem "CMake Error: CMAKE_C_COMPILER not set, after EnableLanguage", Run ``brew install opencv --env=std `` instead


	- if brew link failed because of some files are not writable:
		- ``sudo chown -R haojian  /usr/local``


	```
	cmake -D CMAKE_BUILD_TYPE=RELEASE  -D MAKE_INSTALL_PREFIX=/usr/local -D BUILD_NEW_PYTHON_SUPPORT=ON  ..
	```

## Transform

- Image Filters
	- [Creating a Camera+ effect](http://taptaptap.com/blog/creating-a-camera-plus-fx/)


- Log polar Transform
	- [Log-Polar Mapping](http://users.isr.ist.utl.pt/~alex/Projects/TemplateTracking/logpolar.htm)



## Liblinear

if ```Exception: LIBLINEAR library not found.```

run ```make lib``` to generate the so file manually.
