package com.wangle.Tread;

public class Number1 extends Thread{
	static int i =0;
	private int thread;
	public Number1(int thread){
		this.thread = thread;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":开始...");
		synchronized (String.class) {
			System.out.println(Thread.currentThread().getName()+":同步开始、、、、");
			while(i<75){
				if(i/5%3+1 == thread){
					System.out.println(Thread.currentThread().getName()+":"+(++i));
					System.out.println(Thread.currentThread().getName()+":执行notify。。。。");
					String.class.notify();
				}else{
					try {
						System.out.println(Thread.currentThread().getName()+":不满足条件，开始进入waitting。。。。");
						String.class.wait();//线程一旦被挂起堵塞，就等待被唤醒，唤醒后会接着执行上次wait（）的后面代码
						System.out.println(Thread.currentThread().getName()+":被唤醒。。。");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(Thread.currentThread().getName()+":同步结束...");
		}
		System.out.println(Thread.currentThread().getName()+":线程结束");
	}

}
