package com.wangle.javaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReStudy2 {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fileInputStream = new FileInputStream("a.txt");
//		int a = fileInputStream.read();
//		System.out.println((char)a);
//		int b= fileInputStream.read();
//		System.out.println((char)b);
//		System.out.println((char)fileInputStream.read());
//		System.out.println((char)fileInputStream.read());
//		System.out.println((char)fileInputStream.read());
//		fileInputStream.close();
//		System.out.println((char)fileInputStream.read());
//		System.out.println((char)fileInputStream.read());
//		System.out.println(fileInputStream.read());
//		byte[] b = new byte[3];
//		fileInputStream.read(b);
//		fileInputStream.read(b);
//		int a =fileInputStream.read(b);
//		fileInputStream.read(b);
//		System.out.println(a);
//		System.out.println(Arrays.toString(b));
//		System.out.println(new String(b, 0,a));
//		
//		byte[] b = new byte[10];
//		fileInputStream.read(b, 8, 2);//��2����������b�ĵ�8λ��ʼ��
//		fileInputStream.read(b, 1, 2);//��2����������b�ĵ�2λ��ʼ��
//		fileInputStream.read(b, 1, 2);//��2����������b�ĵ�2λ��ʼ��
//		int a = fileInputStream.read(b, 1, 2);//��2����������b�ĵ�2λ��ʼ��
//		fileInputStream.read(b, 1, 2);//��2����������b�ĵ�2λ��ʼ��
//		System.out.println(a);
//		System.out.println(Arrays.toString(b));
		
		
//		fileInputStream.skip(2);//�������ٸ�����
//		System.out.println((char)fileInputStream.read());
//		System.out.println((char)fileInputStream.read());
//		System.out.println((char)fileInputStream.read());
//		System.out.println((char)fileInputStream.read());
//		System.out.println((char)fileInputStream.read());
//		System.out.println(fileInputStream.read());
//		System.out.println(fileInputStream.available());//ʣ�����û��
		
		//�����������
		byte[] b = new byte[128];
		fileInputStream.read(b);
		System.out.println(new String (b));
		fileInputStream.read(b);
		System.out.println(new String (b));
		fileInputStream.read(b);
		System.out.println(new String (b));
		fileInputStream.read(b);
		System.out.println(new String (b));
		fileInputStream.read(b);
		System.out.println(new String (b));
		fileInputStream.read(b);
		System.out.println(new String (b));
		fileInputStream.read(b);
		System.out.println(new String (b));
		fileInputStream.read(b);
		System.out.println(new String (b));
		fileInputStream.read(b);
		System.out.println(new String (b));
		fileInputStream.read(b);
		System.out.println(new String (b));
		fileInputStream.read(b);
		System.out.println(new String (b));
		fileInputStream.read(b);
		System.out.println(new String (b));
		fileInputStream.read(b);
		System.out.println(new String (b));
		
//		FileOutputStream outputStream = new FileOutputStream(new File("d/cd.txt"));//û���ļ����Լ�����������linuxϵͳ����
		FileOutputStream outputStream = new FileOutputStream(new File("cd.txt"),true);
		byte[] b2 = "��ã��й�".getBytes();
		outputStream.write(b2, 0, 8);
	}
}
