---
title: zookeeper基础 安装 运行
date:
categories:
- zookeeper
tags:
- zookeeper基础安装与运行
---

### 安装并运行zookeeper
地址：   
  http://zookeeper.apache.org/doc/r3.3.6/zookeeperStarted.html#sc_Download   
windows配置：  
  ```
  cd zookeeper-3.3.6    
  copy conf\zoo_sample.cfg conf\zoo.cfg  
  .\bin\zkServer.cmd  `(启动zookeeper服务)`
  ```
linux 配置
 ```
 sh zkServer.sh start
 sh zkServer.sh start-foreground(好使)
 ```  
 需要设置:
 ```  
 initLimit=5
 syncLimit=2
 server.1=127.0.0.1:2888:3888
 ```
