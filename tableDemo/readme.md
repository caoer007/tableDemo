通过自定义的注解实现一个简单的创表sql返回
功能列表：

1、服务端定义的实体Bean，支持以下注释：

@Table(name="")

@Field(isKey="",type="",isNull="",comment="")

2、浏览器端可输入：某个已定义的实体Bean的类名

3、提交后，浏览器端能显示出服务端生成的创表SQL的文本

浏览器路径参考 ： http://localhost:8080/tableDemo/
示例：
文本框输入BnnDemo
返回：
create table bnnDemo(id2 int (11) NOT NULL COMMENT ' 编号2 ' ,
id int (11) NOT NULL COMMENT ' 编号1 ' ,
value char (200) COMMENT ' 值 ' ,
PRIMARY KEY (id2,id) )
ENGINE=InnoDB DEFAULT CHARSET=utf8;

