package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

public class Test03{
	
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
		
		Statement statement = con.createStatement();
		//ÅúÁ¿Ö´ÐÐ
		long time = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			statement.addBatch("insert into user (name ,address) values ('A','B')");
//			statement.addBatch("delete from user where id >4");
		}
		
		int[] arr = statement.executeBatch();
		statement.clearBatch();
		System.out.println(Arrays.toString(arr));
		System.out.println(System.currentTimeMillis()-time);
		con.close();
		
		
	}
	
}