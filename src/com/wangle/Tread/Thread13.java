package com.wangle.Tread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.wangle.javaIO.FileInputOutputStream;

public class Thread13 extends Thread{
	//����һ���ж��̵߳ķ������������һ�����ء�
	 private volatile static boolean on = false;

	
	public static void main(String[] args) throws InterruptedException {
		Thread13 t = new Thread13();
		t.start();
		Thread.sleep(1000);
		t.interrupt();//�뿪��on���ʹ�ã�Ŀ���Ƿ�ֹwhile�г��ֶ�������io��д����
		on = true;
		t.join();
		System.out.println("main end");
	}
	
	
	@Override
	public void run() {
		
		while(!on){
			
			
			if(Thread.interrupted()){
				System.out.println("�ұ������");
			}else{
				System.out.println("��û�б����");
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
			
			//ģ��ҵ�����
			try {
				Thread.sleep(10000000000l);
			} catch (InterruptedException e) {
				System.out.println("���ж�"+e);
			}
		}
	}
}
