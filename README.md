简章
=

#流量记录服务模块

  >>模块采用spring boot +mongodb +swagger2


		tce-storage-flowwriter(模块主程序)

		tce-storage-flowwriter-connect(流量记录服务外部访问适配，内含连接工具类，测试类)

		tce-storage-flowwriter-db(模块数据库访问层，规定数据库信息)
		
		

##1.简要说明
从 Spring Boot 项目名称中的 Boot 可以看出来，Spring Boot 的作用在于创建
和启动新的基于 Spring 框架的项目。它的目的是帮助开发人员很容易的创建出独立运行和
产品级别的基于 Spring 框架的应用。Spring Boot 会选择最适合的 Spring 子项目
和第三方开源库进行整合。大部分 Spring Boot 应用只需要非常少的配置就可以快速运行
起来。<br>
###Spring Boot 包含的特性如下：<br>
    • 创建可以独立运行的 Spring 应用。<br>
    • 直接嵌入 Tomcat 或 Jetty 服务器，不需要部署 WAR 文件。<br>
    • 提供推荐的基础 POM 文件来简化 Apache Maven 配置。<br>
    • 尽可能的根据项目依赖来自动配置 Spring 框架。<br>
    • 提供可以直接在生产环境中使用的功能，如性能指标、应用信息和应用健康检查。<br>
    • 没有代码生成，也没有 XML 配置文件。
  



##2.模块启动参数设置

    --server.port=					#模块开发端口
    --spring.data.mongodb.host=				#mongo数据库地址IP
    --spring.data.mongodb.database=			#mongo表空间

##3.swagger2 提供测试UI

  >>地址：http://ip:port/swagger-ui.html
  
                               
    {                              
      "IPAddr": "192.168.3.158", 
      "Type": "1",               
      "NodeId": "001",           
      "Application": "car",      
      "TimeStamp": "1890498234", 
      "Flow": "24"               
    }                              
  
注：<br/>
	1.接口参数不区分大小写。<br/>
	2.接口参数没有规定参数顺序，但都是非空参数。

