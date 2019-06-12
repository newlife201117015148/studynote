package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

import com.mysql.jdbc.Wrapper;
/**
 * 
   * @类 名： Test15
   * @功能描述： 连接池
   * @作者信息： wangle
   * @创建时间： 2019年5月21日下午6:01:04
   * @修改备注：
 */
public class Test15 {
	//连接池存在的意义：为 了缩短每次获取连接，TCP请求的时候消耗的时间。
	public static void main(String[] args) throws Exception{
		
//		javax.sql.DataSource;//就两个方法getConnection（）、getConnection(String, String)
		
//		提供的都是接口。都由数据库厂商自己实现，那么就需要引入jar包。
//		
//		主要连接池厂商：c3p0和DBCP
		
//		c3p0可以自动回收空闲连接，DBCP不能
		
		
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
		con.close();//连接关闭后，被放回连接池，下一个才能拿到。如果不关闭，就会一直被挂起，最后一个会一直等待其他连接关闭
		System.out.println(source.getConnection());
		
		source.close();
	}

}
