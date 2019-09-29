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
		//注意：在jiemi对象里面没有read（byte[]）的方法，那么调用父类，即inputStream的read（byte[]）方法，而inputstream中的read（byte[]）方法
		//调用的是read（）方法，而该方法又被子类jiemi所重写，所以读取的时候再取反，就成功解密
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
