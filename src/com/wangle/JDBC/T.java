package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class T {
	
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
		PreparedStatement statement = conn.prepareStatement("select * from user where id =? ");
		
//		ResultSet set = statement.executeQuery("select * from user where id =?");
//		while(set.next()){
//			System.out.println(set.getString(2));
//		}
		statement.setString(1, "1");
		statement.setString(1, "2");
		statement.addBatch();
		statement.executeBatch();
		while(statement.getResultSet().next()){
			System.out.println(statement.getResultSet().getString(2));
		}
	}

}
