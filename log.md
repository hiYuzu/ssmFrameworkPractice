#日志

>2018.10.24 17:58

上传了SSM框架的demo，但是代码跑不通，推测原因是配置文件出了问题。

P.S.报错内容似曾相识的样子。

>2018.10.25 11:45

test跑通

问题解决:

1.pom缺少必要的jar包,resource目录需要手动设置

2.查询条件做了修改,无条件查询所有信息

>2018.10.25 15:30

增加了ControllerTest，测试跑通

当前问题：

js无法通过ajax获取后台数据

可能原因：

1.配置文件

2.url路径

>2018.10.26 13:07

解决了js无法通过ajax获取后台数据的问题，原因是spring-mvc.xml配置文件中servlet-name不一致。

>2018.10.26 16:12

新增欢迎页,页面跳转至详情页

未来可增加登录验证跳转至不同页面

>2018.10.29 21:18

前台搭建-简历初步模型-完成

>2018.10.29 22:15

数据库新增sender表用于存储留言信息，功能目前只完成查询，插入功能未添加

前台无查询按钮，未来设置登录系统后添加查询权限

前台拥有留言按钮，后台方法未添加插入功能，待更新

>2018.11.05 09:20

插入功能添加完成

>2018.11.05 13:35

添加了登录功能,通过邮箱密码登录

登录成功页面可以直接跳转(无需登录,但需要知道地址)

登陆成功页面可以查看所有留言

前台页面未美化

>2018.11.07 08:03

前台页面修改美化

删除简历页面,改为留言页面

>2018.11.07 09:02

新增session的登录验证

未登录不可进入登录成功页面

>2018.11.07 09:22

增加跳转页面按钮

修改数据库数据存储类型和默认值

>2018.11.07 15:57

增加登录方式(用户名/手机号/邮箱)

项目部署到服务器(http://118.89.246.137:8080)

>2018.11.09 14:17

主页背景颜色修改,样式修改

>2018.11.15 14:44

更改主页、登录页、登录成功页的样式

>2018.11.15 16:16

前端修改整合

>2018.11.26 14:44

后台代码修改一定逻辑

解决上传到云服务器后,向数据库插入数据时,中文变成??的问题(jdbc配置设置characterEncoding=utf-8(ps:在本地插入正常))

修改登录成功后的显示样式

新增工具类(时间转换工具,默认值工具)

>2018.11.17 16:56

规范代码,新增默认值

>2018.12.03 14:30

页面控制交给springMVC

增加基础实体类

设置session有效时长15min

查看留言请求需要通过session验证

删除BLOG页面

>2018.12.04 15:59

增加加密工具

删除查询用户功能

>2018.12.19 09:08

增加拦截器和Session管理类

拦截除指定接口外的所有请求

增加页面及跳转控制类,页面跳转全部交由后台控制

数据库新增用户等级表,博客表,博客类型表

登录用户将对应id存储在Session中以做验证

云服务器已注销(穷逼要啥云服务器？本地自己搭个tomcat一边玩去)

>2018.12.19 13:40

将数据库转储文件及其说明文件上传

>2019.01.11 13:37

新增登录验证码

>2019.03.05 11:14

新增地图,以及相应数据库表单,显示坐标点

>2019.03.11 11:06

更新加密方式，隐藏秘钥

将地图秘钥更新为个人所有

>2019.03.12 14:30

添加彩蛋（算是彩蛋8..）

>2019.03.12 14:51

更新数据库，增加记录登录信息的表

更新.sql转储文件（仅结构）

地图坐标信息需登录后查看（未登录情况下仅可查看普通地图）

>2019.04.28 08:31

修改多个地图坐标会重名的错误

>2019.04.30 11:34

更新SQL文件