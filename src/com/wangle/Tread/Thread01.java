package com.wangle.Tread;

public class Thread01 extends Thread{
	
	
	public void run() {
		
		System.out.println("Thread:"+getName());
	}
	
	public static void main(String[] args) {
		//什么是线程，一个程序进行多任务处理
		//什么是进程，在操作系统上的多任务，一个任务就是一个程序如QQ，浏览器，也叫一个进程
		
		
		//进程之间不能进行数据访问，操作系统为每个进程单独开辟一个内存空间，
		//  访问其他进程的内存的程序叫木马，有专门访问别个进程内存的函数，360杀毒就是扫描你是否调用这类函数来判断是否为木马  外挂是辅助程序，但是不是木马
		//  进程里面有子进程，子进程之间可以进行内存访问  或者网络访问
		
		//进程的访问内存弊端，就引出线程，在进程之上进行多任务处理
		//线程之间可以进行数据访问
		
		
		
		//这是通过继承Thread类的方式创建线程
		Thread01 thread01 = new Thread01();
		Thread01 thread02 = new Thread01();
		Thread01 thread03 = new Thread01();
		Thread01 thread04 = new Thread01();
		
		
		thread01.start();
		thread02.start();
		thread03.start();
		thread04.start();
		
		
		//通过实现Runnable接口的方式创建线程,
		Thread thread1 = new Thread(new Test01());
		Thread thread2 = new Thread(new Test01());
		Thread thread3 = new Thread(new Test01());
		Thread thread4 = new Thread(new Test01());
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
