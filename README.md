# script
脚本管理工具,管理我们许许多多的脚本文件，特别是服务器重启没设置自启的各个脚本，一个一个去启动特麻烦，
项目使用Spring Boot + MySQL。

## 特性
	- 支持windows 命令管理
	- 支持windows 脚本管理
	- 支持linux 服务器远程命令管理
	- 支持linux 服务器远程脚本管理
	- 支持命令和脚本查看(linux远程脚本管理查看未实现)
	- 支持执行结果日志输出

## 使用

通过maven工程直接引入,打包即可，不过打包之前记得修改数据库配置。
![](https://i.imgur.com/doIM2G6.png)

数据库的脚本在此地。

![](https://i.imgur.com/2EFgjw0.png)


## 截个图举个栗子🌰
主界面
![](https://i.imgur.com/sC2irEz.gif)
查看脚本功能
![](https://i.imgur.com/UUZzdqo.gif)
查看执行结果
![](https://i.imgur.com/JqvKVfX.png)

## 存在问题
	-是否生效选择那里没实现，不知道layui怎么初始化那块，我再研究一下
	-linux远程脚本查看没实现
	-为了赶时间，把代码结构写的挺差，后续再慢慢优化了
	-没有安全认证，容易泄密

## 感谢
[layui](http://www.layui.com/)

[hutool](http://www.hutool.cn/)
## 问题建议
	- 提Issues 
	- 联系我的邮箱：ilovey_hwy@163.com