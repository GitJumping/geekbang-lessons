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

## Jenkins的使用