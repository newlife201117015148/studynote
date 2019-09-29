package com.wangle.Tread;

public class Thread12 extends Thread{

	@Override
	public void run() {
		
		while(true){
			boolean b = false;
			if(b=Thread.interrupted()){//只能用一次，第二次状态恢复为false。与sleep一样都是判断当前线程
				//的状态
				System.out.println("我被打断了");
				//业务逻辑一般写在这里
				break;
			}else{
				System.out.println(b);
				System.out.println("我没有被打断");
			}
			//业务逻辑写在这里的话，需要重新更新打断状态为打断
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {//抛异常后打断状态被重置
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread12 t = new Thread12();
		t.start();
		Thread.sleep(1000);
		t.interrupt();//interrupt()不能中断在运行中的线程，它只能改变中断状态而已。
		//t.interrupted()当前线程是否已经中断。线程的中断状态 由该方法清除
		
		//总结一般想要中断一个线程，从外部是无法办到的，只有线程自己结束。java中单单用interrupt（）是
		//不行的，他只是改变了线程中断的状态，要想中断线程需要和Thread.interrupted()配合使用。
	}
}
