package com.wangle.javaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReStudy6 {
	
	public static void main(String[] args) throws Exception {
		
		FileOutputStream out = new FileOutputStream("a.txt");
		
		Jiami jiami = new Jiami(out);
		jiami.write("a".getBytes());
		
		FileInputStream in = new FileInputStream("a.txt");
		
		Jiemi jiemi = new Jiemi(in);
		byte[] b = new byte[10];
		int len = 0;
		//ע�⣺��jiemi��������û��read��byte[]���ķ�������ô���ø��࣬��inputStream��read��byte[]����������inputstream�е�read��byte[]������
		//���õ���read�������������÷����ֱ�����jiemi����д�����Զ�ȡ��ʱ����ȡ�����ͳɹ�����
		while((len=jiemi.read(b))!=-1){
			//len = jiemi.read(b);
			System.out.println(new String(b,0,len));
			for (int i = 0; i < b.length; i++) {
				System.out.println(b[i]);
			}
		}
		jiemi.close();
		jiami.close();
	}
}
