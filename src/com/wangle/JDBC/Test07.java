package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;

public class Test07 {

	public static void main(String[] args) throws Exception {

		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
		
		PreparedStatement prest = con.prepareStatement("insert into users (username,password) values (?,?)");	
		
		for (int i = 0; i < 10000; i++) {
			prest.setString(1, "lisi");
			prest.setString(2, "321");
			prest.addBatch();
		}
		int[] row = prest.executeBatch();
		
		System.out.println(Arrays.toString(row));
		con.close();
	}

}
