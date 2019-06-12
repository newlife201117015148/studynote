package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Test10 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");

		Statement st = con.createStatement();

//		ResultSet re = st.executeQuery("show databases");
//		ResultSet re = st.executeQuery("show tables");
		ResultSet re = st.executeQuery("desc users");

		while(re.next()){
			for (int i = 1; i <= re.getMetaData().getColumnCount(); i++) {
				System.out.print(re.getString(i)+"\t");
			}
			System.out.println();
		}
		
		con.close();
	}
}
