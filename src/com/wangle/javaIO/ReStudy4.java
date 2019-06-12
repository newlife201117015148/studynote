package com.wangle.javaIO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReStudy4 {
	/*public static void main(String[] args) throws Exception {
		
		FileInputStream fileInputStream = new FileInputStream("E:/Applications/360cse_9.5.0.138.exe");
		FileOutputStream fileOutputStream = new FileOutputStream("E:/神奇女侠.exe");
		
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
	
	public static void main(String[] args) throws Exception {
		
		
//		FileOutputStream fileOutputStream = new FileOutputStream("a.txt",true);
//		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//		
//		Student student1 = new Student("张三","男",12,85f);
//		student1.setCard(new IDCard("333"));
//		Student student2 = new Student("李四","男",12,85f);
//		student2.setCard(new IDCard("4444"));
//		objectOutputStream.writeObject(student1);
//		objectOutputStream.writeObject(student2);
//		objectOutputStream.close();
		
//		FileInputStream inputstream = new FileInputStream("a.txt");
//		
//		ObjectInputStream objectInputStream = new ObjectInputStream(inputstream);
//		
//		Student stu = (Student)objectInputStream.readObject();
//		System.out.println(stu.getName());
//		System.out.println(stu.getAge());
//		System.out.println(stu.getSex());
//		System.out.println(stu.getScore());
//		Student stu2 = (Student)objectInputStream.readObject();
//		System.out.println(stu2.getName());
//		System.out.println(stu2.getAge());
//		System.out.println(stu2.getSex());
//		System.out.println(stu2.getScore());
//		objectInputStream.read();//EOFException
		
		
		
		
		FileInputStream inputstream = new FileInputStream("a.txt");
		
		ObjectInputStream objectInputStream = new ObjectInputStream(inputstream);
		List<Student> list = new ArrayList<Student>();
		try {
			while(true){
				Student stu = (Student)objectInputStream.readObject();
				list.add(stu);
			}
		} catch (EOFException e) {//该异常表示结束，InputStream读到结尾的标识符是-1，Reader读到结尾的标识符是null
			for (Student stu : list) {
				System.out.println(stu.getName()+stu.getCard().getID()+stu.a);
			}
			System.out.println("读取结束");
		}
		//stu.countStar();
		
	}
}
