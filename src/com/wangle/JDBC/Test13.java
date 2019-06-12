package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 
   * @类 名： Test13
   * @功能描述： 与test14测试数据库死锁
   * @作者信息： wangle
   * @创建时间： 2019年5月21日下午5:46:37
   * @修改备注：
 */
public class Test13 {

	public static void main(String[] args) throws Exception  {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
		
		con.setAutoCommit(false);

		Statement st = con.createStatement();
		
		st.executeQuery("select * from user for update");
		
		Thread.sleep(10000);
	
		st.executeQuery("select * from users for update");
		
		con.commit();
	}

}
