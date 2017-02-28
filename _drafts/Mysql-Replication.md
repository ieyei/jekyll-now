---
  layout: post
  title: Mysql 5.6 Replication
---

# Table of Contents
- [What is it?] (#what-is-it)
- [Replication Types] (#replication-types)
- [Parameters] (#parameters)
- [Improvement] (#improvement)

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
* Slave pre-fetching  
[Making slave pre-fetching work better with SSD](http://yoshinorimatsunobu.blogspot.kr/2011/10/making-slave-pre-fetching-work-better.html)
* Group commit

