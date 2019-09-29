package com.wangle.Net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Test01 {
	//InetAddress因特网地址，目的是完成主机名和因特网地址的转换
	public static void main(String[] args) throws Exception {
		InetAddress ia = InetAddress.getLocalHost();//创建一个本地主机的InetAddress对象
		InetAddress[] inetAddress = InetAddress.getAllByName("www.taobao.com");//创建远程所有主机的InetAddress对象
		for (InetAddress inetAddress2 : inetAddress) {
			System.out.println(inetAddress2.getHostAddress());
		}
		
		System.out.println(InetAddress.getByName("192.168.0.01"));
		System.out.println(ia.getHostAddress());
		System.out.println(ia.getHostName());
		
		
		//两个超时设置
		Socket s = new Socket();
		s.setSoTimeout(10000);//这个超时设置，是指建立连接后读写的超时时间，并不是连接
		//new Socket(String host,int port)构造方法，会无期限的阻塞下去，知道获得连接
		//以下方式可以解决连接超时问题
		s.connect(new InetSocketAddress("time-a.nist.gov", 13),10000);
		
		Scanner scan = new Scanner(s.getInputStream(),"UTF-8");
		
		while(scan.hasNext()){
			System.out.println(scan.nextLine());
		}
	}

}
