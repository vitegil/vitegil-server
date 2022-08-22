## Vitegil Server 🌐

- 技术栈：SpringBoot + Mybatis Plus
- 基于 Jdk 1.8
- 成功部署到服务器
- 主要实现的功能：
  - 接收 sdk 监控到的信息：
    - 错误信息：js、promise、resource...
    - 设备信息：device
    - 性能信息：Performance
    - PV 数量
    - ...
  - 将收集到的信息统计整理发送给前台：
    - 错误数量、类型、得分
    - 统计当天内每小时的错误数量、PV 数量
    - 统计 UV 数量
    - 统计平均性能表现
    - ...

> 还未解决的问题：
>
> - JWT 登录验证问题
> - 用户的注册、退出登录功能
> - 增加 redis 缓存提高性能
> - 数据库表的设计优化
> - ...

项目主要结构：

> ```Bash
> .
> ├─src
> │  ├─main
> │  │  ├─java
> │  │  │  └─com
> │  │  │      └─vitegil
> │  │  │          │  VitegilApplication.java #项目的启动类
> │  │  │          │
> │  │  │          ├─config #配置跨域
> │  │  │          │
> │  │  │          ├─controller #Controller层
> │  │  │          │
> │  │  │          ├─mapper #mapper层
> │  │  │          │
> │  │  │          ├─pojo #实体类，pojo层
> │  │  │          │
> │  │  │          ├─service #业务逻辑层
> │  │  │          │
> │  │  │          └─util #工具类
> │  │  │
> │  │  └─resources
> │  │      │  application.yml #配置文件
> │  │      │
> │  │      ├─static
> │  │      └─templates
> │  └─test
> │      └─java
> │          └─com
> │              └─vitegil
> │                      VitegilApplicationTests.java #测试文件
> ```

> 注：小白一个，仅仅是实现了某些功能

