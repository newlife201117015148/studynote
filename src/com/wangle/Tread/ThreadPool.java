package com.wangle.Tread;
import java.util.concurrent.*;

public class ThreadPool implements Runnable{
	
	public static void main(String[] args) throws InterruptedException {
		//��һ���ǹ̶��߳�������������Ҳ����
		/*ExecutorService pool = Executors.newFixedThreadPool(10);//������ʮ����Ȼ��ȴ����е��߳�ʹ��
		for (int i = 0; i < 20; i++) {
			pool.execute(new ThreadPool());//��ʵ��Runnable������󽻸��̳߳أ�ִ��run���� ��ִ�����pool�Զ��Ż��߳�
			Thread.sleep(100);
		}*/
//		pool.shutdown();//ִ�����ر�
//		pool.shutdownNow();//ǿ�ƹر�
		
		//�ڶ����ǻ����̳߳أ��п��еľ��ã�����û���ƣ��ʺϲ�������С��ʹ��
		/*ExecutorService pool1 = Executors.newCachedThreadPool();
		for (int i = 0; i < 200; i++) {
			pool1.execute(new ThreadPool());
		}*/
		
		
		//�������Ƕ�ʱ�̳߳أ�
		/*ScheduledExecutorService pool2 = Executors.newScheduledThreadPool(10);
		for (int i = 0; i < 20; i++) {
			pool2.schedule(new ThreadPool(), 1, TimeUnit.SECONDS);
		}*/
		//�����ֵ��߳�
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
