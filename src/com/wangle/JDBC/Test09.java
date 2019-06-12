package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Test09 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");

		Statement st = con.createStatement();

		ResultSet re = st.executeQuery("select username from users");

		ResultSetMetaData metaData = re.getMetaData();//只是获取执行的sql语句的结果的表结构
		
		int num = metaData.getColumnCount();
		
		for (int i = 1; i <= num; i++) {
			System.out.println(metaData.getColumnName(i)+"\t"+metaData.getColumnTypeName(i)+"\t"+metaData.getColumnDisplaySize(i));
		}
		
		con.close();
	}
}
