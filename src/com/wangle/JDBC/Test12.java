package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * 
   * @类 名： Test12
   * @功能描述： 事务和锁
   * @作者信息： wangle
   * @创建时间： 2019年5月21日下午8:43:06
   * @修改备注：
 */
public class Test12 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
		
		con.setAutoCommit(false);//设置为不自动提交。默认会自动回滚，数据库不会生成数据
		
		Statement st = con.createStatement();
		
		int rs = st.executeUpdate("insert into user (name ,address) values ('a','v')");
		
		if(rs>0){
			con.commit();
		}
	
		
//		con.rollback();//回滚
		System.out.println(rs);
		
//		同一条数据如果被一个事务正在修改(DML操作)，那么其他事务就只能查，不能修改这条记录,这种锁被称为排他锁。
//		还有一种锁是在查询语句加上for update，称为更新锁。如：select * from user for update；
	}

}
