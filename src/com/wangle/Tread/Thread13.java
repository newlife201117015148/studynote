package com.wangle.Tread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.wangle.javaIO.FileInputOutputStream;

public class Thread13 extends Thread{
	//还有一种中断线程的方法，答案是添加一个开关。
	 private volatile static boolean on = false;

	
	public static void main(String[] args) throws InterruptedException {
		Thread13 t = new Thread13();
		t.start();
		Thread.sleep(1000);
		t.interrupt();//与开关on配合使用，目的是防止while中出现堵塞，如io读写堵塞
		on = true;
		t.join();
		System.out.println("main end");
	}
	
	
	@Override
	public void run() {
		
		while(!on){
			
			
			if(Thread.interrupted()){
				System.out.println("我被打断了");
			}else{
				System.out.println("我没有被打断");
			}
			
			try {
				FileInputStream fi = new FileInputStream(new File("D://c.txt"));
				try {
					fi.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//模拟业务操作
			try {
				Thread.sleep(10000000000l);
			} catch (InterruptedException e) {
				System.out.println("被中断"+e);
			}
		}
	}
}
