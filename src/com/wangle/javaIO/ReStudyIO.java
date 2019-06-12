package com.wangle.javaIO;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

public class ReStudyIO {

	public static void main(String[] args) throws InterruptedException, IOException {
		File file = new File("a.txt");
		boolean iscreate = file.createNewFile();
		System.out.println(iscreate);
		File file2 = new File("c:/", "a.txt");

		File File3 = new File("c:/");

		File file4 = new File(File3, "a.txt");
		System.out.println(file4);

		System.out.println(file.exists());// 文件是否存在
		System.out.println(file.isFile());// 是否是文件
		System.out.println(file.isDirectory());// 是否是文件夹
		System.out.println(file.isAbsolute());// 是否是绝对路径
		System.out.println(file.isHidden());// 是否是隐藏状态
		System.out.println(file.canRead());// 文件能不能读
		System.out.println(file.canWrite());// 文件能不能写
		System.out.println(file.canExecute());// 文件是否能执行

		System.out.println(file.length());// 文件的长度 字节
		System.out.println(new Date(file.lastModified()).toLocaleString());
		System.out.println(file.getName());// 文件名称
		System.out.println(file.getPath());// 里面设置的路径，如：new
											// File("a/b.txt")得到的是a/b.txt;
		System.out.println(file.getAbsolutePath());// 相对转绝对路径，补全绝对路径

		// 执行删除的时候，如果是夹子，夹子中有内容（夹子或文件）就不能被删除，没有才能被删除，如果要删除，用递归方法
		// boolean a = file.delete();//立即执行删除，有返回值（boolean）
		// System.out.println(a);
		// file.deleteOnExit();//程序关闭之前删除，如果是非法关闭，就不执行了，没有返回值
		// Thread.sleep(10000);

		// 创建文件，夹子，临时文件，
		File file5 = new File("b.txt");
		boolean b = file5.createNewFile();// 问什么会抛异常，因为，创建文件有可能路径不存在，或者没有创建权限
		System.out.println(b);
		//File file6 = File.createTempFile("aaa", "bbbb");
		//File file6 = File.createTempFile("aaa", "bbbb",new File("d:/"));
		//System.out.println(file6);
		File file7 = new File("a/b/c/d");
		//boolean boo = file7.mkdir();
		boolean boo = file7.mkdirs();
		System.out.println(boo);
		
		//修改路径，其实就是剪切
		File file8 = new File("E:/迅雷下载/厉害了我的国.Amazing.China.2018.HD720P.X264.AAC.Mandarin.CHS.mp4");
		file8.renameTo(new File("E:/厉害了我的国.Amazing.China.2018.HD720P.X264.AAC.Mandarin.CHS.mp4"));
		
		//获得系统根目录
		File[] files = File.listRoots();
		for (File file6 : files) {
			System.out.println(file6);
		}
		
		//列出目录下的所有的夹子和文件,只有一级
		
		File file9 = new File("a/");
		String[] filenames = file9.list();
		for (String string : filenames) {
			File f = new File(file9,string);
			System.out.println(f.isFile());
		}
		System.out.println("--------");
		//带过滤器的list（）方法，筛选作用，为什么是接口，因为判断方法由你自己决定
		String[] filenames2 = file9.list(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				//如果是false就代表不符合过滤，true代表符合过滤
				File fi = new File(dir,name);
				return fi.isDirectory();
			}
		});
		for (String string : filenames2) {
			System.out.println(string);
		}
		System.out.println("--------");
		File[] filess = file9.listFiles();
		filess = file9.listFiles(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				File fi = new File(dir,name);
				return fi.isFile();
			}
		});
		
		filess = file9.listFiles(new FileFilter() {
			
			public boolean accept(File pathname) {
				return pathname.isFile();
			}
		});
		for (File string : filess) {
			System.out.println(string);
		}
		
	}

}
