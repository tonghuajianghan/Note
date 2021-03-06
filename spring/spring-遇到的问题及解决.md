---
title: Spring遇到的问题及解决
date: 2016/5/6
categories:
- spring
tags:
- spring
- Spring遇到的问题及解决
---

### progress loading spring xsd
    最常见的导致这一问题的原因其实与使用了一个名为“assembly”的maven打包插件有关。  
很多项目需要将工程连同其所依赖的所有jar包打包成一个jar包，maven的assembly插件就是用来完成这个任务的。  
但是由于工程往往依赖很多的jar包，而被依赖的jar又会依赖其他的jar包，这样，当工程中依赖到不同的版本的spring时，  
在使用assembly进行打包时，只能将某一个版本jar包下的spring.schemas文件放入最终打出的jar包里，这就有可能遗漏了  
一些版本的xsd的本地映射，进而出现了文章开始提到的错误。如果你的项目是打成单一jar的，你可以通过检查最终生成的  
jar里的spring.schemas文件来确认是不是这种情况。而关于这种情况，解决的方法一般是推荐使用另外一种打包插件shade,  
它确实是一款比assembly更加优秀的工具，在对spring.schemas文件处理上，shade能够将所有jar里的spring.schemas文件  
进行合并，在最终生成的单一jar包里，spring.schemas包含了所有出现过的版本的集合！  

### org.springframework.web.servlet.PageNotFound noHandlerFound   
No mapping found for HTTP request with URI [/spring_test_002/userContoller/userManager]  
in DispatcherServlet with name 'dispatcher'
    
    do: p:prefix="/page/" 默认开始寻找的文件位置，找不到页面。
        return "userpage/userManager"; 
