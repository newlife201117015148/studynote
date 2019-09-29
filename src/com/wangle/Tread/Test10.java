package com.wangle.Tread;

import java.util.concurrent.TimeUnit;

public class Test10 {

	public static void main(String[] args) {
		T t = new T();
		
		new Thread(t,"t1").start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.stop = false;
		
		System.out.println("main id end");
	}
	
	static class T implements Runnable{
		/*volatile*/ boolean stop = true;
		@Override
		public void run() {
			System.out.println("start ...");
			while(stop){
			}	
			System.out.println("... end");
		}
		
	}
}
