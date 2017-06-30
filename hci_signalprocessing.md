Signal Processing
===========

## Kalman filter

- [pykalman](https://pykalman.github.io/)
	- easy to use, install and apply.
	
- [Some Python Implementations of the Kalman Filter](https://github.com/balzer82/Kalman)
	- lots of good application examples
	
- [Kalman-and-Bayesian-Filters-in-Python](https://github.com/rlabbe/Kalman-and-Bayesian-Filters-in-Python) 
	- a very good top-down learning tutorial

## Dead reckoning

- [Multi-sensor fusion in Kalman Filter with different data rates](http://www.rcgroups.com/forums/showthread.php?t=1215585)

- [Slides about sensor details](http://www.slideshare.net/paller/motion-recognition-with-android-devices)


## Tracking toolkit
- [1€ Filter](http://www.lifl.fr/~casiez/1euro/)


##Chirp Processing
- [Some Comments on the Signal Processing Used By Chirp Subbottom Profilers](http://www.ldeo.columbia.edu/res/pi/MB-System/sonarfunction/SubbottomProcessing/subbottomdataprocessing.html)
	- How to increase the time resolution
	- [Root of sine](http://www.physics.miami.edu/~curtright/TheRootsOfSin.pdf) 
	- [Hilbert transform](http://www.physionet.org/physiotools/apdet/apdet-1.0/ht.c)

##Audio Processing
- [Matlab Audio Processing Examples](http://www.ee.columbia.edu/ln/LabROSA/matlab/)


##Signal Encoding

- [Binary key shift keying](http://cnx.org/contents/eed1c63e-9733-4294-9cb6-f27db06efc92@15)
- [m-sequence](http://www.silcom.com/~aludwig/Signal_processing/Maximum_length_sequences.htm) **Best article**
- [m-sequence details](https://cfn.upenn.edu/aguirre/wiki/public:m_sequences)
- Hilbert transform for match filter: [Some Comments on the Signal Processing Used By Chirp Subbottom Profilers](http://www.mbari.org/data/mbsystem/sonarfunction/SubbottomProcessing/subbottomdataprocessing.html)


## Filter
- [Online filter generation](http://www-users.cs.york.ac.uk/~fisher/mkfilter/) 
	- [How to use it](http://stackoverflow.com/questions/664877/i-need-to-implement-a-butterworth-filter-in-c-is-it-easier-get-a-library-with-t)  
	
- [Kalman Filter](http://nbviewer.jupyter.org/github/rlabbe/Kalman-and-Bayesian-Filters-in-Python/blob/master/table_of_contents.ipynb)
	
	
## Signal Smoothing

- different smoothing methods work differently depending on the nature of the signal and noise contained in the signal. Each method offers a different performance to best show significant aspects of your results.
	- Savitzky-Golay seeks to preserve shapes of peaks
	- Adjacent Averaging does wide smoothing.
	- the percentile filter (especially 50% percentile filter or median filter) allows you to eliminate noise with abnormal amplitude.