package com.wangle.JDBC;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test08 {
	//��������������ݿ�
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
		
//		PreparedStatement pst = con.prepareStatement("insert into datas (datas) values (?)");
//		
//		pst.setBinaryStream(1, new FileInputStream("F:\\����\\������.png"));
//		
//		pst.executeUpdate();
		
		PreparedStatement pst = con.prepareStatement("select * from datas");
		ResultSet resultSet = pst.executeQuery();
		while(resultSet.next()){
			FileOutputStream outputStream = new FileOutputStream("D:\\������.png");
			InputStream stream = resultSet.getBinaryStream(1);
			byte[] b = new byte[1024*8];
			while(stream.read(b)!=-1){
				outputStream.write(b, 0, b.length);
			}
			outputStream.close();
		}
		con.close();
	}

}
