package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test01 {

	// ���ݿ����ӷ�ʽ��������
	// DBC��ODBC��JDBC
	// C/C++��DBC�Ž��������ݿ⣻ODBC��DBC���ƣ���΢���ṩһ�����Ӽ�������Ҫ�����C#/.net�������ݿ⣬����Ҫ��Ӧ�����ݿ�jar��
	// JDBC��ͨ���Žӷ�ʽ����Ϊ̫��������ֱ�����ݿ⣬���ṩ��api���ǽӿڣ���Щ�ӿ���Ҫ�������ݿ⳧���Լ�ȥʵ�֣�������ҪһЩJAR����ʵ�֡�

	// ��Ϥ����ӿڣ�
	// java.sql.Connection; ����
	// java.sql.Statement; sql����
	// java.sql.PreparedStatement; sqlԤ����
	// java.sql.CallableStatement; �洢���̵���
	// java.sql.ResultSet; �����
	// java.sql.ResultSetMetaData; Ԫ���ݽ����

	// ����������
	// java.sql.DriverManager;
	
	// JDBCʹ�����̣�
	// Class.forName("com.mysql.jdbc.Driver");//Ŀ���Ǽ����ִ࣬��Driver��̬���е�registerDriver������������������
	// Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","123456");//��������Դ��Ϣ�������
	// Statement statement = connection.createStatement(); //ͨ�����Ӵ���sql������
	// ResultSet resultSet = statement.executeQuery("select * from user");//sql������ִ��sql����ý����
	// while(resultSet.next()){//while�����������
	// 		System.out.println(resultSet.getString("name"));//ȡ�ý��
	// }
	//connection.close();//�ر�����
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");//Ŀ���Ǽ����ִ࣬�о�̬���е�registerDriver������������������
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");//��������Դ��Ϣ�������
		Statement statement = connection.createStatement(); //ͨ�����Ӵ���sql������
		ResultSet resultSet = statement.executeQuery("select * from user");//sql������ִ��sql����ý����
		while(resultSet.next()){//while�����������
			System.out.println(resultSet.getString("name"));//ȡ�ý��
		}
		
		connection.close();//�ر�����
	}
}
