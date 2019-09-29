package com.wangle.Net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Test01 {
	//InetAddress��������ַ��Ŀ�����������������������ַ��ת��
	public static void main(String[] args) throws Exception {
		InetAddress ia = InetAddress.getLocalHost();//����һ������������InetAddress����
		InetAddress[] inetAddress = InetAddress.getAllByName("www.taobao.com");//����Զ������������InetAddress����
		for (InetAddress inetAddress2 : inetAddress) {
			System.out.println(inetAddress2.getHostAddress());
		}
		
		System.out.println(InetAddress.getByName("192.168.0.01"));
		System.out.println(ia.getHostAddress());
		System.out.println(ia.getHostName());
		
		
		//������ʱ����
		Socket s = new Socket();
		s.setSoTimeout(10000);//�����ʱ���ã���ָ�������Ӻ��д�ĳ�ʱʱ�䣬����������
		//new Socket(String host,int port)���췽�����������޵�������ȥ��֪���������
		//���·�ʽ���Խ�����ӳ�ʱ����
		s.connect(new InetSocketAddress("time-a.nist.gov", 13),10000);
		
		Scanner scan = new Scanner(s.getInputStream(),"UTF-8");
		
		while(scan.hasNext()){
			System.out.println(scan.nextLine());
		}
	}

}
