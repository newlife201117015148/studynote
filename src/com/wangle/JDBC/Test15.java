package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

import com.mysql.jdbc.Wrapper;
/**
 * 
   * @�� ���� Test15
   * @���������� ���ӳ�
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��21������6:01:04
   * @�޸ı�ע��
 */
public class Test15 {
	//���ӳش��ڵ����壺Ϊ ������ÿ�λ�ȡ���ӣ�TCP�����ʱ�����ĵ�ʱ�䡣
	public static void main(String[] args) throws Exception{
		
//		javax.sql.DataSource;//����������getConnection������getConnection(String, String)
		
//		�ṩ�Ķ��ǽӿڡ��������ݿ⳧���Լ�ʵ�֣���ô����Ҫ����jar����
//		
//		��Ҫ���ӳس��̣�c3p0��DBCP
		
//		c3p0�����Զ����տ������ӣ�DBCP����
		
		
		//DBCP
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/test");
		source.setUsername("root");
		source.setPassword("123456");
		
		source.setMaxTotal(3);
		source.setMaxIdle(1);
//		Statement statement = con.createStatement();
//		ResultSet rs = statement.executeQuery("select * from user");
//		while(rs.next()){
//			System.out.println(rs.getString("name"));
//		}
		Connection con = source.getConnection();
		System.out.println(con);
		System.out.println(source.getConnection());
		System.out.println(source.getConnection());
		con.close();//���ӹرպ󣬱��Ż����ӳأ���һ�������õ���������رգ��ͻ�һֱ���������һ����һֱ�ȴ��������ӹر�
		System.out.println(source.getConnection());
		
		source.close();
	}

}
