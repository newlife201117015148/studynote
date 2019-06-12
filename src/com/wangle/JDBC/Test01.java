package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test01 {

	// 数据库连接方式多样化：
	// DBC、ODBC、JDBC
	// C/C++用DBC桥接连接数据库；ODBC和DBC类似，是微软提供一种连接技术，主要是针对C#/.net连接数据库，必须要对应的数据库jar包
	// JDBC不通过桥接方式，因为太慢，所以直连数据库，它提供的api都是接口，这些接口需要各大数据库厂商自己去实现，所以需要一些JAR包来实现。

	// 熟悉几大接口：
	// java.sql.Connection; 连接
	// java.sql.Statement; sql处理
	// java.sql.PreparedStatement; sql预处理
	// java.sql.CallableStatement; 存储过程调用
	// java.sql.ResultSet; 结果集
	// java.sql.ResultSetMetaData; 元数据结果集

	// 驱动管理器
	// java.sql.DriverManager;
	
	// JDBC使用流程：
	// Class.forName("com.mysql.jdbc.Driver");//目的是加载类，执行Driver静态块中的registerDriver（）方法，加载驱动
	// Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","123456");//根据数据源信息获得连接
	// Statement statement = connection.createStatement(); //通过连接创建sql处理类
	// ResultSet resultSet = statement.executeQuery("select * from user");//sql处理类执行sql语句获得结果集
	// while(resultSet.next()){//while语句遍历结果集
	// 		System.out.println(resultSet.getString("name"));//取得结果
	// }
	//connection.close();//关闭连接
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");//目的是加载类，执行静态块中的registerDriver（）方法，加载驱动
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");//根据数据源信息获得连接
		Statement statement = connection.createStatement(); //通过连接创建sql处理类
		ResultSet resultSet = statement.executeQuery("select * from user");//sql处理类执行sql语句获得结果集
		while(resultSet.next()){//while语句遍历结果集
			System.out.println(resultSet.getString("name"));//取得结果
		}
		
		connection.close();//关闭连接
	}
}
