package com.wangle.Tread;

public class Thread10 extends Thread{

	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if(this.getName().equals("·�˼�")){
				this.yield();//�ó�ʱ��Ƭ
			}
			Thread10.method();
		}
	}
	public static synchronized void method(){
		System.out.println(Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		
		Thread10 test1 = new Thread10();
		Thread10 test2 = new Thread10();
		test1.setName("·�˼�");
		test2.setName("·����");
		//�������ȼ�
//		test1.setPriority(MIN_PRIORITY);
//		test2.setPriority(MAX_PRIORITY);
		
		test1.start();
		test2.start();
	}
}
