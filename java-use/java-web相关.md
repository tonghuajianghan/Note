---
title: java web处理
date: 2015/10/1
categories:
- java基础
tags:
- jdk web处理
---

### web.xml 加载顺序：

		加载顺序与它们在 web.xml 文件中的先后顺序无关。
		context-param -> listener -> filter -> servlet

context-param   
	context-param，它用于向 ServletContext 提供键值对，即应用程序上下文信息。  
	我们的 listener, filter 等在初始化时会用到这些上下文中的信息  
