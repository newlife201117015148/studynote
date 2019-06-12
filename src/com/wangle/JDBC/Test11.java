package com.wangle.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Test11 {
	//返回变量
//	public static void main(String[] args) throws Exception {
//		Class.forName("com.mysql.jdbc.Driver");
//
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
//
//		CallableStatement prepareCall = con.prepareCall("{call getname(?,?)}");
//		
//		prepareCall.setInt(1, 4);
//		prepareCall.registerOutParameter(2, java.sql.Types.VARCHAR);
//		
//		prepareCall.execute();
//		
//		System.out.println(prepareCall.getString(2));
//		
//		
//		con.close();
//	}
	//返回结果集
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");

		CallableStatement prepareCall = con.prepareCall("{call getusers()}");
		
		prepareCall.execute();
		
		ResultSet rs = prepareCall.getResultSet();
		
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		
		con.close();
	}
}
