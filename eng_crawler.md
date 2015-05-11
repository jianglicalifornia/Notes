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
	
## Storage

- MongoDB
	- replicate set is very useful, since sometime the aws machine can be unreachable.
	

## Overview

- A typical crawler components:
	- Schedu
	- Download

## Performance

- Bloomfilter v.s.
	- 5531833, 5296524, 3gb



- Managing the request path and duplicate filter is expensive. Should use all the possible method minimize the size of these two filters.
	- On the 
- Shouldn't use the BFS or DFS would make the crawler 

## Domain specific

- [Pinterest Developer](https://developers.pinterest.com/api_docs/v3_domain_search_pins/)
