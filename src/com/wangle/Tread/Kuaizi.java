package com.wangle.Tread;

public class Kuaizi {
	
	private boolean flag = false;
	
	public synchronized void naqi(){
		while(flag){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		flag = true;
	}

	public synchronized void fangxia(){
		flag = false;
		notify();
	}
}
