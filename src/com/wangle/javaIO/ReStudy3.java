package com.wangle.javaIO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReStudy3 {

	public static void main(String[] args) throws Exception {
		//9699 7514
		System.out.println("�ܹ�������"+method3());
		
	}
	//��ȡһ��2M�������ļ�
	public static void method1() throws Exception{
		FileInputStream inputStream = new FileInputStream("cd.txt");
		FileOutputStream  outputStream= new FileOutputStream("b.txt");
		byte[] b = new byte[ (int)new File("cd.txt").length()];
		inputStream.read(b);
		System.out.println(new String(b));
		outputStream.close();
		inputStream.close();
	}
	//��һ���ļ����Ƴ���
	public static void method2()throws Exception{
		FileInputStream inputStream = new FileInputStream("cd.txt");
		FileOutputStream  outputStream= new FileOutputStream("b.txt");
		byte[] b = new byte[1024];
		int a = 0;
		while((a=inputStream.read(b))!=-1){
			outputStream.write(b, 0, a);
			System.out.println(new String(b,0,a));
		}
		outputStream.close();
		inputStream.close();
	}
	//дһ������ͳ���ļ������ж��ٸ��ظ��ֽ�
	public static int method3() throws IOException{
		long time = System.currentTimeMillis();
		FileInputStream inputStream = new FileInputStream("b.txt");
		BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream); 
		//byte[] b = new byte[1024*1024];
		int a = 0;
		int shangyige = bufferedInputStream.read();
		int size = 1;
		int count = 0;
		while((a=bufferedInputStream.read())!=-1){
			//str+=new String(b,0,a);
			if(shangyige==a){
				size++;
			}else{
				if(size>=2){
					count ++;
					System.out.println(size);
				}
				size=1;
			}
			shangyige = a;
		}
		if(size>=2){
			count ++;
			System.out.println(size);
		}
		inputStream.close();
		//System.out.println(System.currentTimeMillis()-time);
		return count;
	}
}
