全部功能列表（技术）:
    前后端分离
    Redis
    Mybatis
    MQ
    定时任务
    邮件
    部署打包自动化
    shiro权限认证管理
    文件上传
    Actuator监控
    docker部署
    日志框架
    CI（持续集成）
    性能监控
    数据库连接池
    文档管理
    Vue


正在开发：
    1.用户模块（2019年3月11日）


## 注意事项⚠️

️
如果从GitHub下载代码直接在idea运行，会出现这个问题

```
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'shiroConfig': Injection of autowired dependencies failed; nested exception is java.lang.IllegalArgumentException: Could not resolve placeholder 'spring.redis.host' in value "${spring.redis.host}"

```
这个错误需要设置一下idea的配置文件，操作方法如下（把Resource目录设置为资源目录）
选择jfun/src/main/resources->Mark Directory as->Resource Root
