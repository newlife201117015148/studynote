package com.wangle.javaIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStream {
	
	public static void main(String[] args) {
		byte a = -2;
		float b = 0.1234567890123456789F;
		double c = 0.1234567890123456789D;
		int d = 0x223ff;
		int e = 02327;
		System.out.println(Math.pow(2,128));
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		//test2();
	}
	/**
	   * @Title : test2 
	   * @功能描述: 缓冲字符流
	   * @设定文件： 
	   * @返回类型：void 
	   * @throws ：
	 */
	private static void test2() {
		
		File file = new File("D:\\a\\aa\\aaa\\aaaa\\a.txt");
		File file1 = new File("D:\\a\\aa\\aaa\\aaaa\\a2.txt");
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(file));
			bw = new BufferedWriter(new FileWriter(file1));
			String str= "";
			while((str=br.readLine())!=null){
				bw.write(str+"\r\n");
			}
					
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(bw!=null)
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	/**
	   * @Title : test 
	   * @功能描述: 文件字符流
	   * @设定文件： 
	   * @返回类型：void 
	   * @throws ：
	 */
	private static void test() {
		File file = new File("D:\\a\\aa\\aaa\\aaaa\\a.txt");
		File file1 = new File("D:\\a\\aa\\aaa\\aaaa\\a2.txt");
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(file);
			fw = new FileWriter(file1);
			char[] buff = new char[1024];
			int n = 0;
			while((n=fr.read(buff))!=-1){
				fw.write(buff, 0, n);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
