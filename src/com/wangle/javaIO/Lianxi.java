package com.wangle.javaIO;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

public class Lianxi {

	public static void main(String[] args) throws IOException {
		// U();
		// getpanfudaxiao();
		// diguiwenjian(new File("a"));
		// diguideleteFile(new File("D:\\�½��ļ���"));
		// int result = tongjihouzuishu(new File("E:/"));
		// System.out.println(result);
		// oneMonthNoUseFiles(new File("E:/"));
//		sizeSort(new File("E:/"));
		showFile(new File("E:/"));
	}
	public static void showFile(File dir){
		ArrayList<File> list = (ArrayList<File>) diguiwenjian(dir);
		for (File file : list) {
			System.out.println(file.getName()+"\t"+(file.canWrite() ? "��д" : "����д")+"\t"+(file.length()<1024*1024&&file.length()<1024?file.length()/1024+"k":file.length()<1024*1024*1024&&file.length()>1024*1024?file.length()/1024/1024+"M":file.length())+"\t"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E").format(new Date(file.lastModified())));
		}
	}
	public static void sizeSort(File dir) {
		ArrayList<File> list = (ArrayList<File>) diguiwenjian(dir);
		Collections.sort(list, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				if(o1.length()>o2.length()){
					return -1;
				}else if(o1.length()==o2.length()){
					return 0;
				}else{
					return 1;
				}
			}
		});
		int size = list.size()>100?100:list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i).getPath() + "-----" + list.get(i).length());
		}
	}

	public static void oneMonthNoUseFiles(File dir) {
		ArrayList<File> list = (ArrayList<File>) diguiwenjian(dir);
		for (int index = 0; index < list.size(); index++) {
			long lastTime = list.get(index).lastModified();
			long oneMonth = 1 * 31 * 24 * 60 * 60 * 1000;
			long time = System.currentTimeMillis() - lastTime;
			if (time < oneMonth) {
				list.remove(index);
			}
		}
		for (File file : list) {
			System.out.println(file.getPath() + "----" + new Date(file.lastModified()).toLocaleString());
		}
	}

	/**
	 * 
	 * @Title : tongjihouzuishu
	 * @��������: ͳ�ƺ�׺�� @�趨�ļ���
	 * @�������ͣ�void
	 * @throws ��
	 */
	public static int tongjihouzuishu(File dir) {
		ArrayList<File> list = (ArrayList<File>) diguiwenjian(dir);
		HashSet<String> houzhuis = new HashSet<String>();
		for (File file : list) {
			int index = file.getName().lastIndexOf(".");
			if (index != -1) {
				houzhuis.add(file.getName().substring(index));
			}
		}
		for (String string : houzhuis) {
			System.out.println(string);
		}
		return houzhuis.size();
	}

	public static void diguideleteFile(File dir) {
		if (dir.isFile()) {
			dir.delete();
			System.out.println(dir.getPath());
		} else {
			File[] files = dir.listFiles();
			if (files != null) {
				for (File file : files) {
					diguideleteFile(file);
				}
			}
			dir.delete();
		}
	}

	static List<File> list = new ArrayList<File>();

	public static List<File> diguiwenjian(File dir) {
		if (dir.isFile()) {
			list.add(dir);
		} else {
			File[] files = dir.listFiles();
			if (files != null) {
				for (File file : files) {
					diguiwenjian(file);
				}
			}
		}
		return list;
	}

	public static void getpanfudaxiao() {
		File[] files = File.listRoots();
		for (File file : files) {
			System.out.println(file);
			System.out.println("�ܼƴ�С��" + file.getTotalSpace() / 1024 / 1024 / 1024 + "G");
			System.out.println("ʣ���С��" + file.getFreeSpace() / 1024 / 1024 / 1024 + "G");
			System.out.println("���ô�С��"
					+ (file.getTotalSpace() / 1024 / 1024 / 1024 - file.getFreeSpace() / 1024 / 1024 / 1024) + "G");
		}
	}

	public static void U() throws IOException {
		// ����Ƿ���U�̲��룬����оʹ�
		while (true) {
			FileSystemView fileview = FileSystemView.getFileSystemView();
			File[] files = File.listRoots();
			File upan = null;
			for (File file : files) {
				String type = fileview.getSystemTypeDescription(file);
				System.out.println(file + "____" + type);
				if (type.equals("���ƶ�����")) {
					upan = file;
					System.out.println("��U�̻����ƶ����̲��룡");
					break;
				}
			}
			if (upan == null) {
				System.out.println("û��U��");
			} else {
				Runtime.getRuntime().exec("cmd /c start " + upan.getPath());
				return;
			}
		}
	}
}
