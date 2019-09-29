package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

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
	
	/*
	 * ����Ҫ�㣺
	 * ��Ҫ�ӿڻ��ࣺConnection statement preparestatement resultset rowSet 
	 * 
	 * 1.�������ݿ⣬��ȡ���ӵ��������forname DriverManager
	 * 2.��ȡstatement���󣬹��췽��statement����statement��type concurent��type��
	 * 	�Ǳ�ʾ�Ƿ�ɹ�����concurent��ʾ�Ƿ�ɶ���ɸ���
	 * 3.statement�ķ�����
	 * ��ͨ
	 * execute���� executeUpdate�������ظ��³ɹ����� executeQuery�������������
	 * ����
	 * addBatch(sql);statement.executeBatch();statement.clearBatch();
	 * 4.preparestatement��
	 * ��ͨ����
	 * preparestatement(sql) preparestatement(sql,type,concurent)
	 * ����
	 * addBatch();statement.executeBatch();statement.clearBatch();
	 * 5.resultset ���� û��hasnext������ֻ��next��������ȡ����rs.getXXX()�������������Ҳ���ǵ���
	 * conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)ʱ��
	 * �޸�updateRow:
	 * 			rs.updateXXX(���µ��ֶΣ����µ�ֵ);
	 * 			rs.updateRow();
	 * ����inserRow:
	 * 			rs.moveToInsertRow();�ƶ��������У��޷�ָ��λ��
	 * 			rs.updateXXX(���µ��ֶΣ����µ�ֵ);
	 * 			...�ǿ��ֶΣ�������ֵ
	 * 			rs.insertRow();
	 * 			rs.moveToCurrentRow();
	 * ɾ����deleteRow:
	 * 			rs.deleteRow();ɾ���α���ָ��
	 * �޸Ľ�����ı׶ˣ������ݿ����Ӳ���Ͽ����˷���Դ����������ʹ��sql����޸����ݿ⣬����Ч��
	 * 6.�м�RowSet���̳���resultSet,�ŵ���ǻ����������޸ĺ���ͬ�������ݿ⣬��Ҫ���������ݿ�:
	 * 			RowSetFactory f = RowSetProvider.newFactory();
	 * 			CacheRowSet crs = f.createCacheRowSet();
	 * 			crs.populate(result);
	 * 			crs.setTable();����Ҫ���µı���
	 * 			conn.close();�Ϳ��Թر����ݿ�������
	 * 			...�޸����ݵĲ���
	 * 			setPageSize(int);����ҳ��
	 * 			crs.nextPage();��ҳ
	 * 			crs.acceptChanges(conn);ͬ��
	 * 	�����Ե����������ݿ⣬��ѯ���ݣ�
	 * 			crs.setURL(url);
	 * 			crs.setUsername(username);
	 * 			crs.setPassword(password);
	 *			crs.setCommand(sql<����>);
	 *			crs.setPageSize(int);
	 *			crs.setString(1,"");
	 *			crs.execute();�÷����ᴴ�����ӡ�ִ��sql��䡢����м����Ͽ����ӡ�
	 *			�������޸����ݣ����Է�ҳ
	 *			crs.acceptChanges();ͬ��
	 *
	 * �׶ˣ����ݿⲻһ������
	 * ����м��󣬻�û���ü��������ύ�����ݿ⣬���ݾͷ����ı䣬���׳�SyncProviderException�쳣
	 * 7.Ԫ����
	 * 8.���� 
	 * 	�ؼ��㣺setAutoCommit��false); commit();rollback();savePoint();
	 * 		  rollback(savePoint);releaseSavePoint(savePoint);
	 * 9.���ݿ����ӳ�
	 * //DBCP
	 *	BasicDataSource source = new BasicDataSource();	
	 * C3p0 ���Զ����տ�������
	 * 	ComboPooledDataSource ds = new ComboPooledDataSource();
	 */
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
