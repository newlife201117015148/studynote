package com.wangle.others;

import javax.sql.rowset.JdbcRowSet;
/**
 * 
   * @�� ���� Test3
   * @���������� �����̵߳����ַ�ʽ�������ڲ���ĶԱ����ķ���Ȩ��
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��4��1������8:23:58
   * @�޸ı�ע��
 */
public class Test3 {
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new ThreadTest1());
		//Thread thread2= new Thread (new ThreadTest2());
//		Thread[] threads = new Thread[100];
//		for(int i=0;i<threads.length;i++){
//			threads[i] = new Thread(new ThreadTest1());
//			threads[i].start();
//		}
		String a = "s";
		Thread thread = new Thread(){
			public void run() {
//				System.out.println(a);//�����ڲ���;ֲ��ڲ���ֻ�ܷ���final����
			};
		};
		thread.start();
		
//		ThreadTest3 test = new ThreadTest3();
//		test.start();
	}
}
