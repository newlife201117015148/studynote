package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * 
   * @�� ���� Test12
   * @���������� �������
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��21������8:43:06
   * @�޸ı�ע��
 */
public class Test12 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
		
		con.setAutoCommit(false);//����Ϊ���Զ��ύ��Ĭ�ϻ��Զ��ع������ݿⲻ����������
		
		Statement st = con.createStatement();
		
		int rs = st.executeUpdate("insert into user (name ,address) values ('a','v')");
		
		if(rs>0){
			con.commit();
		}
	
		
//		con.rollback();//�ع�
		System.out.println(rs);
		
//		ͬһ�����������һ�����������޸�(DML����)����ô���������ֻ�ܲ飬�����޸�������¼,����������Ϊ��������
//		����һ�������ڲ�ѯ������for update����Ϊ���������磺select * from user for update��
	}

}
