package com.wangle.Tread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest extends TimerTask{

	
	public static void main(String[] args) {
		Timer timer = new Timer();
		
		timer.schedule(new TimerTest(), 3000);//�����ִ��һ��
		timer.schedule(new TimerTest(), 3000,1000);//�����ÿһ��ִ��һ��
	}

	@Override
	public void run() {
		System.out.println("˯����");
		
	}
}
