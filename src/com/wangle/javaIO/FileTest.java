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
			file1.mkdirs();//�༶����
			File file = new File("D:\\a\\aa\\aaa\\aaaa\\a.txt");
			//file.createNewFile(); //������delete()����ʱ��ֱ��ɾ���ļ������ܸ��ļ��Ƿ���ڣ�һ����������ִ�У�
			//file.deleteOnExit();//ֻ���൱�ڶ�deleteOnExit������һ�����������������н�����JVM��ֹʱ����������deleteOnExit()����ʵ��ɾ��������
			
			//file1.mkdir();//һ������
			//file1.delete();//����ɾ�����������ļ������ļ���
			//file1.deleteOnExit();//�����ֹͣ���е�ʱ��ɾ��
			boolean isa = file.isAbsolute();//�Ƿ�Ϊ�ļ���
			String abs = file.getAbsolutePath();//��ȡ����·��
			String path = file.getPath();//��ȡ·��
			String pa = file.getParent();//��ȡ�����ļ�·�����Żص�String
			File file2 = new File(pa);//����File����
//			Runtime.getRuntime().exec("attrib +H \""+file.getAbsolutePath()+"\"");//�����ļ�
			String se = File.separator;//�����ļ�·���ָ���
			String ps = File.pathSeparator;//�ָ��������·���ַ����ķָ���
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
			System.out.println(file2.isFile());//�ж��Ƿ�Ϊ�ļ�����
			System.out.println(file2.isDirectory());//�ж��Ƿ�Ϊ�ļ�������
			System.out.println(new SimpleDateFormat("yyyy��MM��dd��  HHʱmm��ss��  SSS����  E һ�����е�F�� һ���е�D�죬�� w�ܣ�һ�����е� W��").format(new Date()));
			//��������ת��������ʱ��
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
			//������ת���ɺ�����
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("2019-04-02 21:09:42 808").getTime());
			File[] lf = new File(file1.getParent()).listFiles();//�����ļ����ļ��У����ص���File����
			for (File file3 : lf) {
				System.out.println(file3);
			}
			String[] list = new File(file1.getParent()).list();//�����ļ����ļ��У����ص���String�ļ����ļ�����
			for (String string : list) {
				System.out.println(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
