package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test04 {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");

		Statement st = con.createStatement();
		//ͨ��������ȡֵ
//		ResultSet re = st.executeQuery("select * from user");
//
//		while (re.next()) {
//			System.out.println(re.getString("id"));
//		}
		//ͨ������Ż�ȡֵ
		ResultSet re = st.executeQuery("select * from user");

		while (re.next()) {
			System.out.print(re.getString(1)+"\t");
			System.out.print(re.getString(2)+"\t");
			System.out.println(re.getString(3));
		}
		//���������Ǻ����ѯsql�е�һ�£����������ݿ��е�����
		// ResultSet re = st.executeQuery("select id as i from user");
		//
		// while(re.next()){
		// System.out.println(re.getString("id"));
		// }

		//�����ȡֵ
		re.afterLast();//������ָ���α���ʼλ�õ���������next��������Ĭ���ڵ�һλ
		while(re.previous()){
			System.out.print(re.getString(1)+"\t");
			System.out.print(re.getString(2)+"\t");
			System.out.println(re.getString(3));
		}
		
		
		con.close();

	}

}
