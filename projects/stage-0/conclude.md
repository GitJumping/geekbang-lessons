 \# Java EE 单体架构

## 核心 - Servlet

- Servlet API使用

- Servlet 技术架构（规范 Specification）

- 具体框架实现

  \> Struts
  \>
  \> Spring MVC



## Servlet 转发技术

Q: Java Servlet Forward tech 与 Intetnet 转发有什么关系？



# Servlet处理静态内容请求

各应用容器（servlet engine）的处理



# JSP - Servlet扩展







# 数据存储 - JDBC

## JDBC核心API

- javax.sql.DataSource

- 获取方式

  \> 普通对象
  \>
  \> JNDI依赖查找

## 主要的DataSource实现项目

DBCP

C3P0

Druid

## JDBC 驱动

- java.sql.Driver

- java.sql.DriverManager

- java.sql.Connection

- java.sql.Statement

- java.sql.ResultSet
- java.sql.ResultSetMetaData
- java.sql.SQLException
- ***java.sql.Savepoint***

> 一个 JDBC Connection 相当于 MyBatis Session 或者 Hibernate Session

## JDBC 相关

- 单一数据源
- 多数据源








# 数据存储 - JPA
## 数据表相关
- 实体继承
- 复制主键
- JPA组合与关联
- JPA事务提交，回滚
## JPA开发项目
### 基础
核心API
- EntityManager
- EntityTransaction 
- javax.persistence.Query
JPA SPI
- Persistence 
- PersistenceProvider
- PersistenceProviderResolverHolder
- PersistenceUnitInfo
> 基本的配置信息
> 字节码提升
核心EntityManager获取步骤
EntityManager -\> Persistence & META-INF/persistence.xml -\> EntityManagerFactory
### 关于编程模型






# 数据校验
## 通用校验
Apache Commons Validator
- Date 与 Time 校验器
- 数值校验器
- 正则表达式校验器
- ISBN校验器
- etc
## Bean校验（JSR-303）
### 核心
- 注解 @javax.validation.Constraint
- Bean Validation 校验器 ConstraintValidator
> 内建方法
> 自定义注解校验器实现
- 文本解释器 javax.validation.MessageInterpolator
### 校验分组
### 引导 Bean Validation
- Bean Validation SPI javax.validation.spi.ValidationProvider
- Bean Validation 配置 API javax.validation.Configuration






# 配置管理与 Java Logging
## 配置管理
优先外部配置，其次内部配置（作为兜底策略）
### Java SE标准外部化配置
- java.util.prefs.Preferences
### Java EE标准外部化配置
- javax.servlet.ServletContext
- javax.servlet.ServletConfig
- javax.servlet.descriptor.JspConfigDescriptor
- javax.naming.Context
### 整合MicroProfile Config
- org.eclipse.microprofile.config.Config
- 配置来源 - ConfigSource
- 配置 SPI org.eclipse.microprofile.config.spi.ConfigPr oviderResolver

### 通用配置管理
- Apache Commons Configuration

## 日志配置
- 控制流程
- 日志级别 Levels
- 日志对象 Loggers
- 日志处理器 Handlers
- 日志格式化器 Formatters
- 日志管理器 LogManager
- 日志配置文件 Configuration File
- 日志默认配置Default Configuration
- 日志动态配置更新Dynamic Configuration Updates
- 日志本地化Localization






# 监控
## JMX规范
### MBean 属性
- JMX API - MBeanAttributeInfo
- JavaBeans API - PropertyDescriptor
### MBean 通知
- JMX API - MBeanOperationInfo
- JavaBeans API - MethodDescriptor
### 标准MBean
- Java interface 之 外，其接口名称必须以 "MBean" 为后缀
- MBeanAttributeInfo
- MBeanOperationInfo
- MBeanConstructorInfo
### 动态MBean
- javax.management.DynamicMBean
### 开放MBean
- 简单类型
- 合成类型
- 扁平类型
### 模型 MBean
> 从底层而言，所有类型 MBean 最终会变成 DynamicMBean
### 五种结构
属性 操作 通知 构造器 参数
### JMX工具
JConsole 
VisualVM 
JMX Remote API








# Maven项目管理
## artifact 发布
## Profiles







# 持续集成
## 代码托管
SVN
Git
项目 Rebase
开发：分支开发
CodeReview

## 云效平台
代码编辑器
代码管理
Code Review

## 单元测试
测试覆盖度

## 工具
Junit
TestNG
Mock

## 测试驱动开发

## 持续集成工具
流水线
Pipeline
自动化
TravisCI
CircleCI

Jenkins

Gtilab CI/CD

Github Build and Test

## Jenkins的使用

- 多种安装方式

  > ```java
  > java -jar jenkins.war
  > ```

- 多种基础功能













# *九：*服务调用

## RPC（通信协议）

- 消息（Message）
- 存根（存根）

> Servlet请求与线程映射关系：一对一



## REST规范

### 架构属性

性能

可伸缩性

统一接口简化性

组件可修改性

etc...

### 架构约束

C/S架构

无状态

可缓存

分层系统

etc...

### REST请求基本步骤

1. 构建 URI - 请求资源

2. 确定请求方法 - GET、POST

3. 设置请求头和参数 - Headers、Parameters

4. 设置请求主题（可选） - Body

5. URI -> 设置到请求

6. 执行请求（发送到 Server 服务器）

7. 处理响应



## JAX-RS规范

### 应用

Servlet Container

Standalone

### 处理步骤

同REST请求步骤

- 服务端
- 客户端

### API

Application

RuntimeDelegate

UriBuilder













# *十：*异步服务

## 基础知识

RPC特定消息模型

面向消息中间件的消息模型

## JMS

javax.jms.ConnectionFactory

javax.jms.Connection

javax.jms.Session

javax.jms.MessageProducer

javax.jms.MessageConsumer

#### JMS元素 

#### JMS消息

#### JMS消息头字段

#### JMS消息主题

#### JMS消息确认

#### JMS消息模型



## MicroProfile Reactive Messaging

- 架构
- Channel
- Message

## Servlet异步

### Reactive Streams

#### Java 9 Flow API

#### Spring Reactor

#### Reactive.x



### Reactive Stack

#### Vert.x

#### Srping Reactive Stack

#### Spring Cloud Stream



### Java Messaging Stack

#### Spring JMS

#### Spring AMQP













#  *十一：*应用容器安全

## Web安全

### CSRF

-  CSRF Token

- CSRF Token仓库
- CSRF 请求校验匹配器

#### Tomcat CSRF实现

http://tomcat.apache.org/tomcat-7.0-doc/config/filter.html#CSRF_Prevention_Filter

### XSS

#### Tomcat Http头安全实现

## JNDI相关

创建Context















# *十二：*应用容器高可用

## 缓存

#### 缓存的目标

#### 缓存类型

- 集中式缓存
- 分片式缓存

## Java缓存

- JVM缓存
- 分布式缓存

#### Java缓存API

- javax.cache.configuration.CacheEnt ryListenerConfiguration
- javax.cache.event.CacheEntryEvent Filter
- javax.cache.spi.CachingProvider
- javax.cache.CacheManager
- javax.cache.Cache
- javax.cache.Cache.Entry
- javax.cache.expiry.ExpiryPolicy

#### 缓存存储

- 值存储
- 引用存储

#### Cache与Map的类似点

#### Cache与Map的区别点

## Java序列化















# *十三：*Spring基础架构重构

## Spring Web MVC

#### Web MVC 核心组件

##### DispatcherServlet

##### HandlerMapping

##### HandlerAdapter

##### HandlerExecutionChain

##### HandlerInterceptor

##### ModelAndView

##### RequestAttributes 

##### WebMvcConfigurer

##### DelegatingWebMvcConfiguration

##### DefaultServletHttpRequest Handler

etc...

#### Web MVC处理器管理

#### Web MVC页面渲染

##### 模板引擎

- JSP
- Thymeleaf
- Freemarker
- Velocity

##### 模板设计模式

#### Web MVC异常处理

#### Web MVC注解驱动

#### Web MVC自动装配

#### Web MVC REST支持

#### REST服务端

##### HTTP方法

##### URI

#### 内容协商

##### MediaType(主类型/子类型)

##### 序列化和反序列化

## Servelt 与 JSP





























