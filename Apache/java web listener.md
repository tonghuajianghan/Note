
##java web listener##

在JavaWeb被监听的事件源为：ServletContext、HttpSession、ServletRequest，即三大域对象。
-------------------------------------------------------------------------------------------------------
监听域对象“创建”与“销毁”的监听器；
监听域对象“操作域属性”的监听器；
监听HttpSession的监听器。

创建与销毁监听器一共有三个：
ServletContextListener：Tomcat启动和关闭时调用下面两个方法
	public void contextInitialized(ServletContextEvent evt)：ServletContext对象被创建后调用；
	public void contextDestroyed(ServletContextEvent evt)：ServletContext对象被销毁前调用；
HttpSessionListener：开始会话和结束会话时调用下面两个方法
	public void sessionCreated(HttpSessionEvent evt)：HttpSession对象被创建后调用；
	public void sessionDestroyed(HttpSessionEvent evt)：HttpSession对象被销毁前调用；
ServletRequestListener：开始请求和结束请求时调用下面两个方法
	public void requestInitiallized(ServletRequestEvent evt)：ServletRequest对象被创建后调用；
	public void requestDestroyed(ServletRequestEvent evt)：ServletRequest对象被销毁前调用。

-------------------------------------------------------------------------------------------------------
事件对象:
ServletContextEvent：ServletContextgetServletContext()；
HttpSeessionEvent：HttpSessiongetSession()；
ServletRequestEvent：

--------------------------------------------------------------------------------------------------------
操作域属性的监听器
	ServletContextAttributeEvent
	HttpSessionBindingEvent
	ServletRequestAttributeEvent



-------------------------------------ServletContextAttributeEvent----------------
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
public class MyServletContextAttributeListener implements ServletContextAttributeListener{
 
    @Override
    public void attributeAdded(ServletContextAttributeEvent arg0) {
        System.out.println(attributeAdded:+arg0.getName()+,+arg0.getValue());
    }
 
    @Override
    public void attributeRemoved(ServletContextAttributeEvent arg0) {
        System.out.println(attributeRemoved:+arg0.getName()+,+arg0.getValue());
    }
 
    @Override
    public void attributeReplaced(ServletContextAttributeEvent arg0) {
        //arg0.getValue()为替代之前的值
        //arg0.getServletContext().getAttribute(arg0.getName())为替代之后的值
        System.out.println(attributeReplaced:+arg0.getName()+,+arg0.getValue()
                +,+arg0.getServletContext().getAttribute(arg0.getName()));
    }
 
}
-------------------------------------------------------------------------------------------------------------------------------------
ServletContext对象

ServletContext对象代表了一个应用，他是一个Context域对象，它里面的方法主要是一些全局性的方法，可以用来存储各个Servlet之间的共享数据。
ServletContext对象的应用场景，主要用于Servlet之间数据共享(可以用来做聊天室)，获取web应用的初始化参数，实现Servlet转发，读取资源文件。