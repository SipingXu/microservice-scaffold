# microservice-scaffold

2019-09

    > 整体依赖升级，
        springboot  --> 2.1.7.RELEASE
        springcloud --> 2.1.3.RELEASE
        druid       --> 1.1.18
        feign       --> openfeign

---
    基于springboot开发的脚手架，旨在迅速搭建开发平台。采用分布式架构，
    集群部署方式。适用于中小型项目开发，具备快速集成，快速上手的特点。

# 使用技术

---
    1、基础框架：springboot + mybatis + springcloud
    2、权限框架：shiro
    3、缓存：redis
    4、数据库：mysql/arangodb
    5、UI：LayUI
    6、session共享：spring-session-redis
# 包含模块

---
    1、系统管理
        1.1 用户管理
        1.2 角色管理
        1.3 权限分配
        1.4 字典管理
    2、报表模块
        2.1 Echarts集成
    3、导入导出
        3.1 Excel的导入导出
        3.2 简单word的导出
# 模块说明

---
    0.scaffold-actuator：服务监控
    1.scaffold-admin：后台管理系统
    2.scaffold-api：给移动端提供接口服务，集成jwt认证
    3.scaffold-entity：实体类
    4.scaffold-file：文件服务
    5.scaffold-provider：服务注册中心
    6.scaffold-service：业务处理服务接口
    7.scaffold-tools：工具包
    8.scaffold-web：PC/Wap服务
    9.scaffold-consumer：消息队列消费者
# 运行步骤

---
    1、创建数据库：scaffold，导入scaffold-admin/src/main/resources/sql/v{x}.sql
    2、导入项目，下载maven依赖
    3、配置scaffold-service中的数据库信息
    4、配置scaffold-admin/scaffold-api中的redis信息
    5、配置scaffold-file中的文件上传路径
    6、依次启动scaffold-provider、scaffold-file、scaffold-service、scaffold-admin
    7、访问 [首页](http://localhost:8882/index),默认用户名：superadmin，密码：123456