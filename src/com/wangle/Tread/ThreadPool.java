package com.wangle.Tread;
import java.util.concurrent.*;

public class ThreadPool implements Runnable{
	
	public static void main(String[] args) throws InterruptedException {
		//第一种是固定线程数，并行数量也不怕
		/*ExecutorService pool = Executors.newFixedThreadPool(10);//先用完十个，然后等待空闲的线程使用
		for (int i = 0; i < 20; i++) {
			pool.execute(new ThreadPool());//将实现Runnable的类对象交给线程池，执行run方法 ，执行完后，pool自动放回线程
			Thread.sleep(100);
		}*/
//		pool.shutdown();//执行完后关闭
//		pool.shutdownNow();//强制关闭
		
		//第二种是缓存线程池，有空闲的就用，数量没限制，适合并行数量小的使用
		/*ExecutorService pool1 = Executors.newCachedThreadPool();
		for (int i = 0; i < 200; i++) {
			pool1.execute(new ThreadPool());
		}*/
		
		
		//第三种是定时线程池，
		/*ScheduledExecutorService pool2 = Executors.newScheduledThreadPool(10);
		for (int i = 0; i < 20; i++) {
			pool2.schedule(new ThreadPool(), 1, TimeUnit.SECONDS);
		}*/
		//第四种单线程
		ExecutorService pool3 = Executors.newSingleThreadExecutor();
		pool3.execute(new ThreadPool());
	}

	public void run() {
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
