package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test14 {

	public static void main(String[] args) throws Exception  {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
		
		con.setAutoCommit(false);

		Statement st = con.createStatement();
		
		st.executeQuery("select * from users for update");
		
		Thread.sleep(5000);
	
		st.executeQuery("select * from user for update");
		
		con.commit();
	}

}
