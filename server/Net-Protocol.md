
#http
    https://zh.wikipedia.org/wiki/超文本传输协议
    https://tools.ietf.org/html/rfc2616 http1.1
    https://tools.ietf.org/html/rfc7540 http2.0
超文本传输协议（英文：HyperText Transfer Protocol，缩写：HTTP）是一种用于分布式、协作式和超媒体信息系统的应用层协议[1]。HTTP是万维网的数据通信的基础。

征求意见稿（英语：Request For Comments，缩写为RFC）https://zh.wikipedia.org/wiki/RFC

请求方法:
    GET 
    HEAD 
        与GET方法一样，都是向服务器发出指定资源的请求。只不过服务器将不传回资源的本文部分。它的好处在于，使用这个方法可以在不必传输全部内容的情况下，就可以获取其中“关于该资源的信息”（元信息或称元数据）。
    POST PUT DELETE 
    TRACE 回显服务器收到的请求，主要用于测试或诊断。
    OPTIONS
         这个方法可使服务器传回该资源所支持的所有HTTP请求方法。用'*'来代替资源名称，向Web服务器发送OPTIONS请求，可以测试服务器功能是否正常运作。
    CONNECT
        HTTP/1.1协议中预留给能够将连接改为管道方式的代理服务器。通常用于SSL加密服务器的链接（经由非加密的HTTP代理服务器）。
    PATCH
        用于将局部修改应用到资源。

副作用
    若干次请求的副作用与单次请求相同或者根本没有副作用，那么这些请求方法就能够被视作`幂等(idempotence)`

状态代码的第一个数字代表当前响应的类型：
    1xx消息——请求已被服务器接收，继续处理
    2xx成功——请求已成功被服务器接收、理解、并接受
    3xx重定向——需要后续操作才能完成这一请求
    4xx请求错误——请求含有词法错误或者无法被执行
    5xx服务器错误——服务器在处理某个正确请求时发生错误

持续连线
    在HTTP 0.9和1.0中，TCP连接在每一次请求/回应对之后关闭。在HTTP 1.1中，引入了保持连接的机制，一个连接可以重复在多个请求/回应使用。持续连接的方式可以大大减少等待时间，因为在发出第一个请求后，双方不需要重新运行TCP交握程序。