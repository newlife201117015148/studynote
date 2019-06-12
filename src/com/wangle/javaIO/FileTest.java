package com.wangle.javaIO;

import java.io.File;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
	
	public static void main(String[] args) {
		try {
			File file1 = new File("D:\\a\\aa\\aaa\\aaaa");
			file1.mkdirs();//多级创建
			File file = new File("D:\\a\\aa\\aaa\\aaaa\\a.txt");
			//file.createNewFile(); //当调用delete()方法时，直接删除文件，不管该文件是否存在，一经调用立即执行；
			//file.deleteOnExit();//只是相当于对deleteOnExit（）作一个声明，当程序运行结束，JVM终止时才真正调用deleteOnExit()方法实现删除操作。
			
			//file1.mkdir();//一级创建
			//file1.delete();//立即删除，不管是文件还是文件夹
			//file1.deleteOnExit();//虚拟机停止运行的时候删除
			boolean isa = file.isAbsolute();//是否为文件夹
			String abs = file.getAbsolutePath();//获取绝对路径
			String path = file.getPath();//获取路径
			String pa = file.getParent();//获取父类文件路径，放回的String
			File file2 = new File(pa);//创建File对象
//			Runtime.getRuntime().exec("attrib +H \""+file.getAbsolutePath()+"\"");//隐藏文件
			String se = File.separator;//单个文件路径分隔符
			String ps = File.pathSeparator;//分隔连续多个路径字符串的分隔符
			char  a = File.separatorChar;
			char b = File.pathSeparatorChar;
			System.out.println(ps);
			System.out.println(se);
			System.out.println(a);
			System.out.println(b);
			System.out.println(isa);
			System.out.println(abs);
			System.out.println(path);
			System.out.println(pa);
			System.out.println(file2.isFile());//判断是否为文件类型
			System.out.println(file2.isDirectory());//判断是否为文件夹类型
			System.out.println(new SimpleDateFormat("yyyy年MM月dd日  HH时mm分ss秒  SSS毫秒  E 一个月中第F周 一年中第D天，第 w周，一个月中第 W周").format(new Date()));
			//将毫秒数转换成日期时间
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
			//将日期转换成毫秒数
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("2019-04-02 21:09:42 808").getTime());
			File[] lf = new File(file1.getParent()).listFiles();//遍历文件和文件夹，返回的是File数组
			for (File file3 : lf) {
				System.out.println(file3);
			}
			String[] list = new File(file1.getParent()).list();//遍历文件和文件夹，返回的是String文件或文件夹名
			for (String string : list) {
				System.out.println(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
