package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test02 {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
		
		Statement statement = con.createStatement();
		
//		statement.executeQuery("");//这是执行查询语句，查询语句相对于更新语句更复杂
//		statement.executeBatch(); //执行批量sql语句
		
//		int i = statement.executeUpdate("insert into user (name ,address) values ('zhangsan','sichuan')");//这是执行更新语句，包括删除、修改、新增
//		System.out.println(i);//执行sql后，返回的是所影响行的一个整数
//		int i = statement.executeUpdate("delete from user where id = 3");
//		System.out.println(i);
//		int i = statement.executeUpdate("update user set name = 'lisi' where id = 4");
//		System.out.println(i);
		
		int i = statement.executeUpdate("create table stu (sid int ,name varchar(100) not null )");
		System.out.println(i);
		
		i = statement.executeUpdate("drop table stu");
		System.out.println(i);
		
//		DML DDL >>>> executeUpdate
//		DQL     >>>> executeQuery
		
//		DDL:DDL(数据定义语言,Data Definition Language),建库、建表、设置约束等：create\drop\alter
//		DML: (数据操纵语言，Data Manipulation Language ) 主要指数据的增删查改: Select\delete\\update\insert\call
//		DQL:(数据查询语言，Data Query Language )，主要是select语句
//		DCL：(数据控制语言，Data Control Language ) grant revoke commit rollback等
		con.close();
	}

}
