---
title: java 操作 mail 
date: 2015/9/10
categories:
- java基础
tags:
- java 操作 mail 
---

### SMTP
SMTP（Simple Mail Transfer Protocol）即简单邮件传输协议,它是一组用于由源地址到目的地址传送邮件的规则，  
由它来控制信件的中转方式。SMTP协议属于TCP/IP协议簇，它帮助每台计算机在发送或中转信件时找到下一个目的地。  
通过SMTP协议所指定的服务器,就可以把E-mail寄到收信人的服务器上了，整个过程只要几分钟。  
SMTP服务器则是遵循SMTP协议的发送邮件服务器，用来发送或中转发出的电子邮件。  
它使用由TCP提供的可靠的数据传输服务把邮件消息从发信人的邮件服务器传送到收信人的邮件服务器。  
跟大多数应用层协议一样，SMTP也存在两个 端：在发信人的邮件服务器上执行的客户端和在收信人的邮件服务器上执行的服务器端。  
SMTP的客户端和服务器端同时运行在每个邮件服务器上。当一个邮件服 务器在向其他邮件服务器发送邮件消息时，它是作为SMTP客户在运行。  

引用jar包：  
		
		mail.jar  
		activation.jar  


### JavaMail API的核心类：
会话、消息、地址、验证程序、传输，存储和文件夹。所有这些类都可以在JavaMail API即javax.mail的顶层包中找到，  
尽管你将频繁地发现你自己使用的子类是在javax.mail.internet包中找到的  
