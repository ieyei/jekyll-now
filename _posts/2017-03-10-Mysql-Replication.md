---
  layout: post
  title: Mysql 5.6 Replication
---

# Table of Contents
- [What is it?] (#what-is-it)
- [Replication Types] (#replication-types)
- [Parameters] (#parameters)
- [Improvement] (#improvement)
- [References] (#references)

## What is it?
데이터 정합성이 중요한 비즈니스에서 MySQL Replication은 데이터 불일치 이슈가 존재  
Performance => Asynchronous(데이터 정합성 문제)  
High Availability => Replication  

## Replication Types

* Asynchronous Replication
* Semi-Synchronous Replication
* Synchronous Replication

![Replication Types](/images/ReplicationTypes.PNG)

## Parameters
* sync_binlog  

![sync_binlog](/images/sync_binlog.png)

* innodb_flush_log_at_trx_commit

![innodb_flush_log_at_trx_commit](/images/innodb_flush_log_at_trx_commit.png)

### Improvement
* Architecture  
  - Normal  
  ![Before](/images/replication1.png)
  - Upgrade  
  ![After](/images/replication2.png)
* Slave pre-fetching  
[Making slave pre-fetching work better with SSD](http://yoshinorimatsunobu.blogspot.kr/2011/10/making-slave-pre-fetching-work-better.html)
* Group commit

### References
[AWS re:Invent 2016: Deep Dive on Amazon Aurora] (https://www.youtube.com/watch?v=duf5uUsW3TM)  
[Amazon Aurora Deep Dive Slide] (https://www.slideshare.net/awskorea/amazon-aurora-deep-dive-61569862)  
[MHA wiki](https://github.com/yoshinorim/mha4mysql-manager/wiki)  
