package com.wangle.Tread;

public class ThreadD extends Thread {
	 int total; 
	 
	    public void run() {
	        synchronized (this) {
	            for (int i = 0; i < 101; i++) {
	                total += i; 
	            } 
	            //����ɼ����ˣ������ڴ˶���������ϵȴ��ĵ����̣߳��ڱ������߳�A������
	            notify(); 
	            System.out.println("�������");
	        } 
	    } 

}
