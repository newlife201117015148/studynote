package com.wangle.javaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.wangle.others.Test1;

public class FileInputOutputStream {
	public static void main(String[] args){
		//FileOutputStream fo =null;
		FileOutputStream fo2 = null;
		FileInputStream fi = null;
		try {
			//�ܽ᣺һ���ֽ�һ���ֽڵĶ���������read(byte[] b)Ҳֻ�ǽ�ÿ�ζ������ֽڷ���һ���ֽ�������
			//fo = new FileOutputStream(file);
			//fo.write("abcdefghijklmnopqrstuvwxyz".getBytes());
//			File file = new File();
//			File file2 = new File();
			//���Դ��������ļ�����Ƶ��ͼƬ
			fo2= new FileOutputStream("D:\\a\\aa\\aaa\\aaaa\\a2.txt");
			fi = new FileInputStream("D:\\a\\aa\\aaa\\aaaa\\a.txt");
//			fo2= new FileOutputStream("D:\\a\\aa\\aaa\\aaaa\\a2.jpg");
//			fi = new FileInputStream("D:\\a\\aa\\aaa\\aaaa\\a.jpg");
//			fo2= new FileOutputStream("D:\\a\\aa\\aaa\\aaaa\\a2.mp4");
//			fi = new FileInputStream("D:\\a\\aa\\aaa\\aaaa\\a.mp4");
			byte[] b = new byte[1024];
			int n =0;
			while((n=fi.read(b))!=-1){
//				System.out.println(n);
//				for (byte c : b) {
//					System.out.print((char)c);
//				}
				
//				System.out.println(new String(b,0,n));
				fo2.write(b,0,n);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("�����ļ�ʧ��");
		}finally{
			try {
				if(fi!=null)
				fi.close();
//				fo.close();
				if(fo2!=null)
				fo2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("��ȡ�ļ�ʧ��");
			}
		}
	}
}
