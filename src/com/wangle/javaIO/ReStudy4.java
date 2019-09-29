package com.wangle.javaIO;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReStudy4 {
	/*public static void main(String[] args) throws Exception {
		
		FileInputStream fileInputStream = new FileInputStream("E:/Applications/360cse_9.5.0.138.exe");
		FileOutputStream fileOutputStream = new FileOutputStream("E:/����Ů��.exe");
		
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		
		byte[] b = new byte[1024*8];
		int i = 0;
		while((i = bufferedInputStream.read(b))!=-1){
			bufferedOutputStream.write(b,0,i);
		}
		//bufferedOutputStream.flush();
		//Thread.sleep(100000);
		bufferedInputStream.close();
		bufferedOutputStream.close();
	}*/
	public static void appendObj(Object obj,File file) throws Exception{
		boolean isexit = false;
		if (file.exists()&&file.length()!=0) {
			isexit = true;// ���л��ļ�����,׷������
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file,true);
		// ÿ��new��ʱ�򶼻�д��һ��StreamHeader,����Ҫ��ƨ�ɺ����StreamHeaderȥ��
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		long pos = 0;// ����˵���ļ��ĳ���
		if (isexit) {
			// getChannel()���ش�ͨ�����ļ�λ�ã�����һ���Ǹ���������������ļ��Ŀ�ʼ����ǰλ��֮����ֽ���
			pos = fileOutputStream.getChannel().position() - 4;// StreamHeader��4���ֽ����Լ�ȥ
			// ����ͨ�����ļ���ȡΪ������С
			fileOutputStream.getChannel().truncate(pos);
		}
 
		objectOutputStream.writeObject(obj);
		// �ر���
		objectOutputStream.close();
		fileOutputStream.close();
	}
	public static void main(String[] args) throws Exception {
		
		
		File file = new File("a.txt");
		Student student1 = new Student("����","��",12,85f);
		student1.setCard(new IDCard("333"));
		Student student2 = new Student("����","��",12,85f);
		student2.setCard(new IDCard("4444"));
		appendObj(student1,file);
		appendObj(student2,file); 
		appendObj(null,file); //�����ı�־λ
		
		FileInputStream inputstream = new FileInputStream("a.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(inputstream);
		Student stu = (Student)objectInputStream.readObject();
		System.out.println(stu.getName());
		System.out.println(stu.getAge());
		System.out.println(stu.getSex());
		System.out.println(stu.getScore());
		Student stu2 = (Student)objectInputStream.readObject();
		System.out.println(stu2.getName());
		System.out.println(stu2.getAge());
		System.out.println(stu2.getSex());
		System.out.println(stu2.getScore());
		objectInputStream.read();//EOFException
		
		
		
		
		/**
		 * ѭ����ȡ����
		 */
		@SuppressWarnings("resource")
		ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream("a.txt"));
		List<Student> list = new ArrayList<Student>();
		try {
//			while(true){
			Student student ;
			while((student= (Student)objectInputStream1.readObject())!=null){
//				Student student= (Student)objectInputStream1.readObject();
				list.add(student);
			}
			for (Student stu1 : list) {
				System.out.println(stu1.getName()+stu1.getCard().getID()+stu1.a);
			}
		} catch (EOFException e) {//���쳣��ʾ������InputStream������β�ı�ʶ����-1��Reader������β�ı�ʶ����null
			for (Student student : list) {
				System.out.println(student.getName()+student.getCard().getID()+student.a);
			}
			System.out.println("��ȡ����");
		}
		//stu.countStar();
		
	}
}
