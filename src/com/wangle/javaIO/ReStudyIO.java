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

		System.out.println(file.exists());// �ļ��Ƿ����
		System.out.println(file.isFile());// �Ƿ����ļ�
		System.out.println(file.isDirectory());// �Ƿ����ļ���
		System.out.println(file.isAbsolute());// �Ƿ��Ǿ���·��
		System.out.println(file.isHidden());// �Ƿ�������״̬
		System.out.println(file.canRead());// �ļ��ܲ��ܶ�
		System.out.println(file.canWrite());// �ļ��ܲ���д
		System.out.println(file.canExecute());// �ļ��Ƿ���ִ��

		System.out.println(file.length());// �ļ��ĳ��� �ֽ�
		System.out.println(new Date(file.lastModified()).toLocaleString());
		System.out.println(file.getName());// �ļ�����
		System.out.println(file.getPath());// �������õ�·�����磺new
											// File("a/b.txt")�õ�����a/b.txt;
		System.out.println(file.getAbsolutePath());// ���ת����·������ȫ����·��

		// ִ��ɾ����ʱ������Ǽ��ӣ������������ݣ����ӻ��ļ����Ͳ��ܱ�ɾ����û�в��ܱ�ɾ�������Ҫɾ�����õݹ鷽��
		// boolean a = file.delete();//����ִ��ɾ�����з���ֵ��boolean��
		// System.out.println(a);
		// file.deleteOnExit();//����ر�֮ǰɾ��������ǷǷ��رգ��Ͳ�ִ���ˣ�û�з���ֵ
		// Thread.sleep(10000);

		// �����ļ������ӣ���ʱ�ļ���
		File file5 = new File("b.txt");
		boolean b = file5.createNewFile();// ��ʲô�����쳣����Ϊ�������ļ��п���·�������ڣ�����û�д���Ȩ��
		System.out.println(b);
		//File file6 = File.createTempFile("aaa", "bbbb");
		//File file6 = File.createTempFile("aaa", "bbbb",new File("d:/"));
		//System.out.println(file6);
		File file7 = new File("a/b/c/d");
		//boolean boo = file7.mkdir();
		boolean boo = file7.mkdirs();
		System.out.println(boo);
		
		//�޸�·������ʵ���Ǽ���
		File file8 = new File("E:/Ѹ������/�������ҵĹ�.Amazing.China.2018.HD720P.X264.AAC.Mandarin.CHS.mp4");
		file8.renameTo(new File("E:/�������ҵĹ�.Amazing.China.2018.HD720P.X264.AAC.Mandarin.CHS.mp4"));
		
		//���ϵͳ��Ŀ¼
		File[] files = File.listRoots();
		for (File file6 : files) {
			System.out.println(file6);
		}
		
		//�г�Ŀ¼�µ����еļ��Ӻ��ļ�,ֻ��һ��
		
		File file9 = new File("a/");
		String[] filenames = file9.list();
		for (String string : filenames) {
			File f = new File(file9,string);
			System.out.println(f.isFile());
		}
		System.out.println("--------");
		//����������list����������ɸѡ���ã�Ϊʲô�ǽӿڣ���Ϊ�жϷ��������Լ�����
		String[] filenames2 = file9.list(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				//�����false�ʹ������Ϲ��ˣ�true������Ϲ���
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
