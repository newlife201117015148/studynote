package com.wangle.others;

import javax.sql.rowset.JdbcRowSet;
/**
 * 
   * @类 名： Test3
   * @功能描述： 创建线程的两种方式和匿名内部类的对变量的访问权限
   * @作者信息： wangle
   * @创建时间： 2019年4月1日下午8:23:58
   * @修改备注：
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
//				System.out.println(a);//匿名内部类和局部内部类只能访问final变量
			};
		};
		thread.start();
		
//		ThreadTest3 test = new ThreadTest3();
//		test.start();
	}
}
