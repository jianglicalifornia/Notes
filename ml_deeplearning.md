Deep learning
===================



## Deep learning Hardware

- [Which gpu for deep learning](https://timdettmers.wordpress.com/2014/08/14/which-gpu-for-deep-learning/)
- [A Full Hardware Guide to Deep Learning](https://timdettmers.wordpress.com/2015/03/09/deep-learning-hardware-guide/)
	- [Comments from HackNews](https://news.ycombinator.com/item?id=9172048)
- [Existing machine configuration](http://www.findlaptopdriver.com/dell-0nw73c-mainboard-specifications/)
	- CPU: i7-3770 @ 3.40 GHz * (8 cpus)
	- Memory: 32 gb
	- Graphic card: GT640
	- Power: [Existing power supply is not good enough](http://www.tomshardware.com/answers/id-1744460/dell-xps-8500-gpu-250-budget.html)
	- SSD: 256GB + HD: 3TB


## Caffee

- [Caffe 深度学习框架上手教程](http://suanfazu.com/t/caffe-shen-du-xue-xi-kuang-jia-shang-shou-jiao-cheng/281)

## Prior reading

- [Andrew Ng: Deep Learning, Self-Taught Learning and Unsupervised Feature Learning](https://www.youtube.com/watch?v=n1ViNeWhC24)
- [Simple but effective demo](http://v.youku.com/v_show/id_XMjE2MDY4NTg0.html)
- [Sparse coding and ‘ICA’](http://redwood.berkeley.edu/vs265/handout-sparse-08.pdf)
- Locality-Sensitive Hashing
	- [局部敏感哈希(Locality-Sensitive Hashing, LSH)方法介绍](http://blog.csdn.net/icvpr/article/details/12342159)
	- [LSH-Forest in Python sci-kit](https://www.google.com/search?q=LSH-Forest&oq=LSH-Forest&aqs=chrome..69i57j0.379j0j7&sourceid=chrome&es_sm=91&ie=UTF-8#q=LSH-Forest+in+python)

##ING

- [Getting Started with Deep Learning and Python](http://www.pyimagesearch.com/2014/09/22/getting-started-deep-learning-python)
- [Introduction to Deep Learning with Python - Theano](https://www.youtube.com/watch?v=S75EdAcXHKk&hd=1)
- [Chinese student's summary](http://blog.csdn.net/abcjennifer/article/details/42493493#0-tsina-1-19647-397232819ff9a47a7b7e80a40613cfe1)
- [DEEP LEARNING: Methods and Applications from microsoft](http://research.microsoft.com/pubs/209355/DeepLearning-NowPublishing-Vol7-SIG-039.pdf)
- [Online course in NYU](http://cilvr.cs.nyu.edu/doku.php?id=deeplearning:slides:start)



## Finished reading

- [easy tutorial from ConvNetJS](http://cs.stanford.edu/people/karpathy/convnetjs/started.html) **Good high level overview**
	- Questions: how does the MagicNet work? 
- [Training a Convolutional Network for Images](http://cs.stanford.edu/people/karpathy/convnetjs/demo/cifar10.html)
	- CIFAR-10 is 32x32x3 (3 is the RGB channels)
	- When I change the learning rate to 0.01, the model doesn't performa well.
	- The realtime prediction accuracy seems based on the accumulative predictions. Everytime the new batch data comes in, it will update the prediction statistic. 
	- Does it require additional iterations? It seems like a one time pass training based on data augmentation?
- [Deep Q Learning algorithm](http://cs.stanford.edu/people/karpathy/convnetjs/demo/rldemo.html)
	- Reinforcement learning seems a more complex kalman filter.
- [4-easy-lessons-from-google](https://gigaom.com/2015/01/29/new-to-deep-learning-here-are-4-easy-lessons-from-google/)
	- At least 100 trainable observations per feature. is this large enough?
- [Deep learning - introduction](https://www.youtube.com/watch?v=PlhFWT7vAEw&hd=1) didn't have too much details. can just ignore this link.
- [Nobel 2014 for the neuro science](http://www.guokr.com/article/439282/) it's a hype. but after reading this story, i also want to advertise this hype somehow.
- [Get off the deep learning bandwagon and get some perspective](http://www.pyimagesearch.com/2014/06/09/get-deep-learning-bandwagon-get-perspective/) like the comments on these machine learning bandwagons' history.
- [Hacker's Guide to neural networks](http://karpathy.github.io/neuralnets/)
	- Great article. Great overview and details, but without mid-level information
- [Understanding Convolution in Deep Learning]( https://timdettmers.wordpress.com/2015/03/26/convolution-deep-learning/)


**Todo**

- http://www.slimy.com/~steuard/teaching/tutorials/Lagrange.html
- http://en.wikipedia.org/wiki/Logistic_regression
- [supervised learning](http://scikit-learn.org/stable/tutorial/statistical_inference/supervised_learning.html)
- [DeepLearning DIY](https://docs.google.com/presentation/d/1UeKXVgRvvxg9OUdh_UiC5G71UMscNPlvArsWER41PsU/preview?sle=true&slide=id.g583563d7a_161101)
- [convolutional neural networks in C++](https://github.com/nyanp/tiny-cnn)
- [Deep Learning tutorial in Chinese - 51 lectures in total](http://www.cnblogs.com/tornadomeet/tag/Deep%20Learning/default.html?page=3)
- [Python for Signal Processing: Featuring IPython Notebooks](http://www.amazon.com/Python-Signal-Processing-Featuring-Notebooks/dp/3319013416#customerReviews)
- [Chinese discussion on the DeepMind's RL ](http://www.infoq.com/cn/articles/atari-reinforcement-learning)
- [Probabilistic Programming & Bayesian Methods for Hackers](https://camdavidsonpilon.github.io/Probabilistic-Programming-and-Bayesian-Methods-for-Hackers/)
- [UFLDL教程](http://deeplearning.stanford.edu/wiki/index.php/UFLDL%E6%95%99%E7%A8%8B)
- [Word2Vec](http://liweithu.me/word2vec/)
- [Kernel in SVM](http://crsouza.blogspot.com/2010/03/kernel-functions-for-machine-learning.html)
- [Unsupervised learning talk from Andrew Ng](https://www.youtube.com/watch?v=ZmNOAtZIgIk)
- [Deeplearning tutorial, Stanford](http://deeplearning.stanford.edu/tutorial/)
- [Deep learning visualization](http://colah.github.io/posts/2015-01-Visualizing-Representations/)
- [reinforcement learning: an introduction](http://webdocs.cs.ualberta.ca/~sutton/book/the-book.html)
- [collaborative filter vs content based ml. genome. pandora ]
- http://blog.csdn.net/dark_scope/article/details/17228643
- Programming Collective Intelligence 
- [tutorial collection](http://www.jianshu.com/p/5WP1Eh)
- [http://eng.kifi.com/from-word2vec-to-doc2vec-an-approach-driven-by-chinese-restaurant-process/]