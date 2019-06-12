package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test02 {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
		
		Statement statement = con.createStatement();
		
//		statement.executeQuery("");//����ִ�в�ѯ��䣬��ѯ�������ڸ�����������
//		statement.executeBatch(); //ִ������sql���
		
//		int i = statement.executeUpdate("insert into user (name ,address) values ('zhangsan','sichuan')");//����ִ�и�����䣬����ɾ�����޸ġ�����
//		System.out.println(i);//ִ��sql�󣬷��ص�����Ӱ���е�һ������
//		int i = statement.executeUpdate("delete from user where id = 3");
//		System.out.println(i);
//		int i = statement.executeUpdate("update user set name = 'lisi' where id = 4");
//		System.out.println(i);
		
		int i = statement.executeUpdate("create table stu (sid int ,name varchar(100) not null )");
		System.out.println(i);
		
		i = statement.executeUpdate("drop table stu");
		System.out.println(i);
		
//		DML DDL >>>> executeUpdate
//		DQL     >>>> executeQuery
		
//		DDL:DDL(���ݶ�������,Data Definition Language),���⡢��������Լ���ȣ�create\drop\alter
//		DML: (���ݲ������ԣ�Data Manipulation Language ) ��Ҫָ���ݵ���ɾ���: Select\delete\\update\insert\call
//		DQL:(���ݲ�ѯ���ԣ�Data Query Language )����Ҫ��select���
//		DCL��(���ݿ������ԣ�Data Control Language ) grant revoke commit rollback��
		con.close();
	}

}
