package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 
   * @�� ���� Test13
   * @���������� ��test14�������ݿ�����
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��21������5:46:37
   * @�޸ı�ע��
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
