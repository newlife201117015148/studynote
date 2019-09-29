package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test01 {

	// 数据库连接方式多样化：
	// DBC、ODBC、JDBC
	// C/C++用DBC桥接连接数据库；ODBC和DBC类似，是微软提供一种连接技术，主要是针对C#/.net连接数据库，必须要对应的数据库jar包
	// JDBC不通过桥接方式，因为太慢，所以直连数据库，它提供的api都是接口，这些接口需要各大数据库厂商自己去实现，所以需要一些JAR包来实现。

	// 熟悉几大接口：
	// java.sql.Connection; 连接
	// java.sql.Statement; sql处理
	// java.sql.PreparedStatement; sql预处理
	// java.sql.CallableStatement; 存储过程调用
	// java.sql.ResultSet; 结果集
	// java.sql.ResultSetMetaData; 元数据结果集

	// 驱动管理器
	// java.sql.DriverManager;
	
	// JDBC使用流程：
	// Class.forName("com.mysql.jdbc.Driver");//目的是加载类，执行Driver静态块中的registerDriver（）方法，加载驱动
	// Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","123456");//根据数据源信息获得连接
	// Statement statement = connection.createStatement(); //通过连接创建sql处理类
	// ResultSet resultSet = statement.executeQuery("select * from user");//sql处理类执行sql语句获得结果集
	// while(resultSet.next()){//while语句遍历结果集
	// 		System.out.println(resultSet.getString("name"));//取得结果
	// }
	//connection.close();//关闭连接
	
	/*
	 * 几个要点：
	 * 重要接口或类：Connection statement preparestatement resultset rowSet 
	 * 
	 * 1.连接数据库，获取连接的相关配置forname DriverManager
	 * 2.获取statement对象，构造方法statement（）statement（type concurent）type：
	 * 	是表示是否可滚动，concurent表示是否可读或可更新
	 * 3.statement的方法：
	 * 普通
	 * execute（） executeUpdate（）返回更新成功个数 executeQuery（）产生结果集
	 * 批量
	 * addBatch(sql);statement.executeBatch();statement.clearBatch();
	 * 4.preparestatement：
	 * 普通操作
	 * preparestatement(sql) preparestatement(sql,type,concurent)
	 * 批量
	 * addBatch();statement.executeBatch();statement.clearBatch();
	 * 5.resultset 遍历 没有hasnext（），只有next（），获取数据rs.getXXX()。另外更新数据也就是调用
	 * conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)时：
	 * 修改updateRow:
	 * 			rs.updateXXX(更新的字段，更新的值);
	 * 			rs.updateRow();
	 * 插入inserRow:
	 * 			rs.moveToInsertRow();移动到插入行，无法指定位置
	 * 			rs.updateXXX(更新的字段，更新的值);
	 * 			...非空字段，必须有值
	 * 			rs.insertRow();
	 * 			rs.moveToCurrentRow();
	 * 删除行deleteRow:
	 * 			rs.deleteRow();删除游标所指行
	 * 修改结果集的弊端：是数据库连接不会断开，浪费资源。尽量还是使用sql语句修改数据库，更高效。
	 * 6.行集RowSet，继承于resultSet,优点就是缓存结果集，修改后再同步到数据库，不要长连接数据库:
	 * 			RowSetFactory f = RowSetProvider.newFactory();
	 * 			CacheRowSet crs = f.createCacheRowSet();
	 * 			crs.populate(result);
	 * 			crs.setTable();设置要更新的表名
	 * 			conn.close();就可以关闭数据库连接了
	 * 			...修改数据的操作
	 * 			setPageSize(int);设置页数
	 * 			crs.nextPage();翻页
	 * 			crs.acceptChanges(conn);同步
	 * 	还可以单独连接数据库，查询数据：
	 * 			crs.setURL(url);
	 * 			crs.setUsername(username);
	 * 			crs.setPassword(password);
	 *			crs.setCommand(sql<带？>);
	 *			crs.setPageSize(int);
	 *			crs.setString(1,"");
	 *			crs.execute();该方法会创建连接、执行sql语句、填充行集、断开连接。
	 *			遍历、修改数据，可以翻页
	 *			crs.acceptChanges();同步
	 *
	 * 弊端：数据库不一致问题
	 * 填充行集后，还没来得及将数据提交到数据库，数据就发生改变，会抛出SyncProviderException异常
	 * 7.元数据
	 * 8.事务 
	 * 	关键点：setAutoCommit（false); commit();rollback();savePoint();
	 * 		  rollback(savePoint);releaseSavePoint(savePoint);
	 * 9.数据库连接池
	 * //DBCP
	 *	BasicDataSource source = new BasicDataSource();	
	 * C3p0 会自动回收空闲连接
	 * 	ComboPooledDataSource ds = new ComboPooledDataSource();
	 */
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");//目的是加载类，执行静态块中的registerDriver（）方法，加载驱动
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");//根据数据源信息获得连接
		Statement statement = connection.createStatement(); //通过连接创建sql处理类
		ResultSet resultSet = statement.executeQuery("select * from user");//sql处理类执行sql语句获得结果集
		while(resultSet.next()){//while语句遍历结果集
			System.out.println(resultSet.getString("name"));//取得结果
		}
		
		connection.close();//关闭连接
	}
}
