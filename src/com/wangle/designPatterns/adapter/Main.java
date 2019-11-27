package com.wangle.designPatterns.adapter;

import java.io.*;

public class Main {

	//适配器模式
	//像生活中的转接头，在编程里边表示一个不能直接被访问，可以考虑先访问某个类让这个类去访问要访问的类，实现间接访问。
	
	//实例：1>JavaIO中的InputStreamReader（或outputstreamwriter）就是一个适配器，让reader和inputstream互转
	//	   2>JDBC---->JDBC-ODBC Bridge(不是用的桥接模式）----->ODBC---->sql server
	//注意：常见的WindowAdapter、MouseAdapter等等都不是实际的adapter模式，它只是方便编程，不用像使用windowListener那么麻烦，管你用不用都要每次都要实现所有的方法
	public static void main(String[] args) throws Exception {
		FileInputStream input = new FileInputStream(new File("sparseArr.data"));
		InputStreamReader isr = new InputStreamReader(input);//这就是一个适配器
		BufferedReader r = new BufferedReader(isr);
		String b ;
		while((b= r.readLine())!=null){
			System.out.println(b);
		}
		r.close();
	}
}
