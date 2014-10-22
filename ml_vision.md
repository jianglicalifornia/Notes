Vision
===================

Video Processing
===

####FFmpeg

- [How to speed up / slow down a video](https://trac.ffmpeg.org/wiki/How%20to%20speed%20up%20/%20slow%20down%20a%20video)
- [19 ffmpeg commands for all needs](http://www.catswhocode.com/blog/19-ffmpeg-commands-for-all-needs)
- [How can I remove multiple segments from a video using FFmpeg?](http://superuser.com/questions/681885/how-can-i-remove-multiple-segments-from-a-video-using-ffmpeg)
- [FFmpeg filtering](http://trac.ffmpeg.org/wiki/FilteringGuide)
- [Audio editing - sentence by sentence](http://www-ie.meijo-u.ac.jp/~banno/spLibs/spwave/index.html)
- [How to install ffmpeg](http://www.renevolution.com/how-to-install-ffmpeg-on-mac-os-x/)

- [Create a video slideshow from images](https://trac.ffmpeg.org/wiki/Create%20a%20video%20slideshow%20from%20images)

in case, the sequence of images are not continuous.

default frame rate
```
ffmpeg -f image2 -framerate 25 -i nfl_commercials_%d.jpg video.mpg
```

lower frame rate
``` 
ffmpeg -framerate 10 -i nfl_commercials_%*.jpg  -c:v libx264 -r 30 -pix_fmt yuv420p out.mp4
```

**Code that write text on images**

```
import os
from PIL import Image
from PIL import ImageFont
from PIL import ImageDraw 

def list_files(path):
    # returns a list of names (with extension, without full path) of all files 
    # in folder path
    files = []
    for name in os.listdir(path):
        if os.path.isfile(os.path.join(path, name)):
            files.append(name)
    return files


tagmap = {}
# load labeled data
f = open('../nfl_commercials/jia_result')
for line in f:
	array = line.split("\t")
	tagContentStr = array[2].strip()[1:-1]
	tagContent = tagContentStr.split(",")
	tags = {};
	for singletagstr in tagContent:
		tag_score = singletagstr.strip()[1:]
		if len(tag_score.split(":")) != 2:
			# print singletagstr, tag_score, len(tag_score.split(":"))
			continue
		tag   = tag_score.split(":")[0]
		score = tag_score.split(":")[1].strip()[:6]
		# print tag, score
		tags[tag] = score
	tagmap[ array[0] ] = tags
	# print array[0]
	# print array[0], tagContent[0].strip()[1:], tagContent[1].strip()[1:], tagContent[2].strip()[1:]
f.close()

# images = list_files("../nfl_commercials")
# for singleimage in images:
# 	if singleimage.endswith(".jpg"):
# 		print singleimage
for key, tagSet in tagmap.items():
	img = Image.open("../nfl_commercials/" + key)
	draw = ImageDraw.Draw(img)
	font = ImageFont.truetype("Roboto-Regular.ttf", 20)
	yheight = 10
	counter = 0;
	# print tagSet, type(tagSet)
	for tag, score in tagSet.items():
		width, height = font.getsize(tag)
		draw.text((10, yheight), tag + ' : ' + score, (255,0,0),font=font)
		yheight += height * 1.1
		if counter > 3:
			break
		counter += 1
	img.save('output/' + key)
	print key, tagSet

# ffmpeg -framerate 6 -i nfl_commercials_%*.jpg  -c:v libx264 -r 30 -pix_fmt yuv420p out.mp4


```

OpenCV
===

opencv with python support [reference](http://stackoverflow.com/questions/18729495/installing-opencv-with-python-module-on-centos-goes-wrong)

```
cmake -D CMAKE_BUILD_TYPE=RELEASE  -D MAKE_INSTALL_PREFIX=/usr/local -D BUILD_NEW_PYTHON_SUPPORT=ON  ..
```

Transform
===

### How filter works.
- [Creating a Camera+ effect](http://taptaptap.com/blog/creating-a-camera-plus-fx/)


####Log polar

- [Log-Polar Mapping](http://users.isr.ist.utl.pt/~alex/Projects/TemplateTracking/logpolar.htm)



