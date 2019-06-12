package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test04 {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");

		Statement st = con.createStatement();
		//通过列名获取值
//		ResultSet re = st.executeQuery("select * from user");
//
//		while (re.next()) {
//			System.out.println(re.getString("id"));
//		}
		//通过列序号获取值
		ResultSet re = st.executeQuery("select * from user");

		while (re.next()) {
			System.out.print(re.getString(1)+"\t");
			System.out.print(re.getString(2)+"\t");
			System.out.println(re.getString(3));
		}
		//列名必须是和你查询sql中的一致，而不是数据库中的列名
		// ResultSet re = st.executeQuery("select id as i from user");
		//
		// while(re.next()){
		// System.out.println(re.getString("id"));
		// }

		//倒叙获取值
		re.afterLast();//必须先指定游标起始位置到最后，如果是next（），是默认在第一位
		while(re.previous()){
			System.out.print(re.getString(1)+"\t");
			System.out.print(re.getString(2)+"\t");
			System.out.println(re.getString(3));
		}
		
		
		con.close();

	}

}
