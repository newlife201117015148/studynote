package com.wangle.designPatterns.adapter;

import java.io.*;

public class Main {

	//������ģʽ
	//�������е�ת��ͷ���ڱ����߱�ʾһ������ֱ�ӱ����ʣ����Կ����ȷ���ĳ�����������ȥ����Ҫ���ʵ��࣬ʵ�ּ�ӷ��ʡ�
	
	//ʵ����1>JavaIO�е�InputStreamReader����outputstreamwriter������һ������������reader��inputstream��ת
	//	   2>JDBC---->JDBC-ODBC Bridge(�����õ��Ž�ģʽ��----->ODBC---->sql server
	//ע�⣺������WindowAdapter��MouseAdapter�ȵȶ�����ʵ�ʵ�adapterģʽ����ֻ�Ƿ����̣�������ʹ��windowListener��ô�鷳�������ò��ö�Ҫÿ�ζ�Ҫʵ�����еķ���
	public static void main(String[] args) throws Exception {
		FileInputStream input = new FileInputStream(new File("sparseArr.data"));
		InputStreamReader isr = new InputStreamReader(input);//�����һ��������
		BufferedReader r = new BufferedReader(isr);
		String b ;
		while((b= r.readLine())!=null){
			System.out.println(b);
		}
		r.close();
	}
}
