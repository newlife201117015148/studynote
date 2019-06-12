package com.wangle.JDBC;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test16 {

	public static void main(String[] args) throws Exception {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql:///test");
		ds.setUser("root");
		ds.setPassword("123456");
		ds.setMaxPoolSize(3);
		Connection con = ds.getConnection();
		System.out.println(ds.getConnection());
		System.out.println(ds.getConnection());
		System.out.println(con);
		con.close();
		System.out.println(ds.getConnection());
		
		ds.close();
	}

}
