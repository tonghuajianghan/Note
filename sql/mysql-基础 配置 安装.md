---
title: mysql基础\配置\安装\基础mysql sql
date:
categories:
- mysql
tags:
- mysql基础
- mysql配置\安装
---


### mysql配置
- 安装 mysql 5.7：
	下载地址: http://dev.mysql.com/downloads/mysql/5.1.html
	
- 解压版安装:	
	1. 配置环境变量
	2. cd到mysql的bin下面
		mysqld --initialize
		mysqld -install
		net start mysql
	3. 然后登入,第一次登入是没有密码的
		 mysql -u root
	  有密码则设置不用密码访问:
		 在mysql.ini文件最后添加(默认没有mysql.ini要自己手动新建)
			skip-grant-tables (注意末尾空格)

	4. 登入之后进行密码修改:  
		- mysql 5.7以前的做法:(新版本没有password字段)
		
			```
			mysql> use mysql;
			mysql> update user set password=password("新密码") 
			where user="root";
			```
		- mysql 5.7 password字段被替换成authentication_string
		
		```
		mysql> update `User` SET   authentication_string=PASSWORD("root") where USER='root';
		mysql> flush privileges;
		mysql> quit;```
 
### 第一次安装mysql的时候密码不为空,问题解决如下:
			ERROR 1045 (28000): Access denied for user'root'@'localhost' (using password: YES)
1. 编辑mysql配置文件my.ini在[mysqld]这个条目下加入skip-grant-tables
2. 保存退出后重启mysql
3. 点击“开始”->“运行”(快捷键Win+R)。
4. 启动：输入 net stop mysql
5. 停止：输入 net start mysql
6. 在cmd里面输入mysql -u root -p就可以不用密码登录了，出现password：的时候直接回车可以进入
7. mysql> use mysql;
8. mysql> update user set password=password("新密码") where user="root";  
(如果是user表中没有password字段的时候,如下所示,否则直接跳过)  
```
mysql> update `User` SET authentication_string=PASSWORD("0000")  
where USER='root';  
mysql> flush privileges;  
mysql> quit;  
```

在第一个登入之后,还需要重新设置密码,否则会提示没有权限操作:  
step 1: SET PASSWORD = PASSWORD(‘your new password‘);  
step 2: ALTER USER ‘root‘@‘localhost‘ PASSWORD EXPIRE NEVER;  
step 3: flush privileges;  

在my.ini中设置如下,解决数据库乱码问题:  
```
[mysql]  
default-character-set=utf8  
[mysqld]  
character-set-server=utf8  
```

### mysql命令

0. 建库
```sql
create database xxx;
mysql> Create TABLE MYTABLE (name VARCHAR(20), sex CHAR(1));
```
1. 建表  
命令：create table <表名> ( <字段名1> <类型1> [,..<字段名n> <类型n>]);   
```sql
mysql> create table MyClass(
> id int(4) not null primary key auto_increment,
> name char(20) not null,
> sex int(4) not null default '0',
> degree double(16,2));
```
2. 获取表结构  
命令： desc 表名，或者show columns from 表名  
```sql
mysql>DESCRIBE MyClass
mysql> desc MyClass; 
mysql> show columns from MyClass;
```

3. 删除表  
命令：drop table <表名>  
mysql> drop table MyClass;  

4. 插入数据  
命令：insert into <表名> [( <字段名1>[,..<字段名n > ])] values ( 值1 )[, ( 值n )]  
```sql
mysql> insert into MyClass   values(1,'Tom',96.45),(2,'Joan',82.99), (2,'Wang', 96.59);  
```

5. 查询表中的数据  
	1. 查询所有行  
	命令： select <字段1，字段2，...> from < 表名 > where < 表达式 >    
	例如：查看表 MyClass 中所有数据    
	mysql> select * from MyClass;    
	2. 查询前几行数据   
	例如：查看表 MyClass 中前2行数据  
	mysql> select * from MyClass order by id limit 0,2;   
	或者：   
	mysql> select * from MyClass limit 0,2;  

6. 删除表中数据  
命令：delete from 表名 where 表达式
例如：删除表 MyClass中编号为1 的记录
	- mysql> delete from MyClass where id=1;
7. 修改表中数据：update 表名 set 字段=新值,… where 条件
	- mysql> update MyClass set name='Mary' where id=1;
8. 在表中增加字段：  
命令：alter table 表名 add字段 类型 其他;   
例如：在表MyClass中添加了一个字段passtest，类型为int(4)，默认值为0  
```sql 
mysql> alter table MyClass add passtest int(4) default '0' 
```
9. 更改表名：
命令：rename table 原表名 to 新表名; 
例如：在表MyClass名字更改为YouClass 
mysql> rename table MyClass to YouClass; 

10. 更新字段内容  
update 表名 set 字段名 = 新内容  
update 表名 set 字段名 = replace(字段名,'旧内容','新内容');   
文章前面加入4个空格  
update article set content=concat('　　',content); 

### mysql 分页
+ 最常见MYSQL最基本的分页方式：  
--0是查询开始的行数（查询起点），10是查询数量（分页的大小）（需要的行数）  
select * from person order by id desc limit 0, 10

+ 特殊：  
select * from persons limit 10;  
意思是，起点为0，开始查询，返回10条记录。


### mysql dump 
这个命令是和mysql命令一样的,运行在cmd窗口下  
参考:
	http://www.cnblogs.com/feichexia/p/MysqlDataBackup.html

>mysqldump -u root -p ams >d:\hh.sql

--opt  
	 如果加上--opt参数则生成的dump文件中稍有不同：  
     建表语句包含drop table if exists tableName  
     insert之前包含一个锁表语句lock tables tableName write，insert之后包含unlock tables  
