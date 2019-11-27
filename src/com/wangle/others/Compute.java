package com.wangle.others;

public class Compute extends Thread{
	int i = 10;
	static Object obj = new Object();
	public void print (){
		System.out.println(Thread.currentThread().getName() + ":" +i);
		i--;
	}
	
	public void run(){
		while(i>0){
			synchronized (obj) {
				print();
			}
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
