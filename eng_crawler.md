Crawler
=============================

## Scheduler

- Bloomfilter v.s. HashFilter
	- HashFilter: The default duplicate filter, that is used in scrapy for filtering visited urls, uses a list of url fingerprints – basically sha1 hashes in length of 40 characters that is 77 bytes long in Python 2.7. Lets say you have to scrape a site with 2M of pages, then your duplicates filter list might grow up to 2M * 77b = 154Mb per one Crawler. [reference](http://alexeyvishnevsky.com/?p=26)
	- Bloomfilter: When we define it to store 2M of items with probability of false positive matches equal to 0.00001% we are getting the duplicate filter that is good enough for only 11Mb of memory. 

- Manage two queues in the scheduler:
	- Deduplicate queue
		- minimize the size of this queue. Since for every new url, scheduler need to check if this link has been crawler before.
	- To request queue
		- Should place the priority on the end nodes. only if the high priority nodes has been crawled, it will start to crawl more candidates url.
	- My experience
		- one process can crawl around 100 pages at the beginning but can only do around 5 pages, where there are more than 10M hashed urls in the deduplicate queue.
		
- There is no big difference between BFS and DFS. Choose based on the specific needs.
	
- Cache: Redis
	- Be careful about the cache size. Since the two queues increasing exponentially, it may take lots of memories.	
－ distributed crawl:
	- redis job queue https://github.com/nvie/rq
	- scrapy with redis: https://github.com/darkrho/scrapy-redis. [chinese analysis](http://blog.csdn.net/u012150179/article/details/38091411)
	
- [使用scrapy,redis,mongodb实现的一个分布式网络爬虫](http://wenku.baidu.com/view/2566b7737e21af45b307a838.html)
- [分布式爬虫架构](http://www.zhihu.com/question/20899988)
	
## Storage

- MongoDB
	- replicate set is very useful, since sometime the aws machine can be unreachable.
	- [mongodb integration](http://python.jobbole.com/81320/)
	- [Why MongoDB Is a Bad Choice for Storing Our Scraped Data](http://blog.scrapinghub.com/2013/05/13/mongo-bad-for-scraped-data/)

- [add mongodb to scrapy](https://realpython.com/blog/python/web-scraping-with-scrapy-and-mongodb/)


## Proxy

- [proxy for crawling](http://stackoverflow.com/questions/19446536/proxy-ip-for-scrapy-framework)
- [scrapy - proxies](https://github.com/aivarsk/scrapy-proxies)

## Distributed Crawler

## Overview

- A typical crawler components:
	- Schedu
	- Download

## Performance

- Bloomfilter v.s.
	- 5531833, 5296524, 3gb

## Debugging

- selector from html: `sel = Selector(text="my html)`
- [scrapy shell](http://doc.scrapy.org/en/latest/topics/shell.html)

- Managing the request path and duplicate filter is expensive. Should use all the possible method minimize the size of these two filters.
	- On the 
- Shouldn't use the BFS or DFS would make the crawler 

## Development Environment

- python virtual environment
	```
	mkdir myproject
	cd myproject
	virtualenv venv
	. venv/bin/activate   
	deactivate
	```

- project config
	```
	scrapy startproject pin_spider
	cd pin_spider/
	virtualenv venv
	. venv/bin/activate   
	scrapy genspider ** **
	```
- [PyCharm configuration](http://www.cnblogs.com/lgphp/p/3841098.html)

## Domain specific

- [Pinterest Developer](https://developers.pinterest.com/api_docs/v3_domain_search_pins/)
- [How to obtain Pinterest V3 API-KEY or access_token](http://stackoverflow.com/questions/24194892/how-to-obtain-pinterest-v3-api-key-or-access-token)
- [How to implement Pinterest Pin](http://www.alexpeta.ro/article/building-a-pinterest-like-image-crawler)

## Other open source

- [pyspider](http://docs.pyspider.org/en/latest/Quickstart/)