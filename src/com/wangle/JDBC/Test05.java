package com.wangle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test05 {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
		
		Statement st = con.createStatement();
		
		ResultSet re = st.executeQuery("select count(*) from user");
		
		int count= 0 ;
		//获取总记录数
		if(re.next()){
			count = re.getInt(1);
			System.out.println(count);
		}
		//总页数
		int pagenums = count%10 !=0 ? count/10+1 :count/10;
		
		for (int i = 0; i < pagenums; i++) {
			ResultSet res = st.executeQuery("select * from user limit "+(i*10)+",10");//查询分页用limit [起始记录位置],[记录数]
			System.out.println("----------------------第"+(i+1)+"页------------------------");
			while (res.next()) {
				System.out.print(res.getString(1)+"\t");
				System.out.print(res.getString(2)+"\t");
				System.out.println(res.getString(3));
			}
		}
	}

}
