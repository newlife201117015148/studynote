package com.wangle.Tread;

public class Thread11 extends Thread{

	static boolean stop = false;
	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!stop){
			System.out.println("stop:"+stop);
		}
	}
	public static void main(String[] args) {
		try {
			Thread t =new Thread11();
			t.start();
			stop = true;
			Thread.sleep(1000);
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
