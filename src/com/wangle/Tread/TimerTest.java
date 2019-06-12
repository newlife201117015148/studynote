package com.wangle.Tread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest extends TimerTask{

	
	public static void main(String[] args) {
		Timer timer = new Timer();
		
		timer.schedule(new TimerTest(), 3000);//三秒后执行一次
		timer.schedule(new TimerTest(), 3000,1000);//三秒后每一秒执行一次
	}

	@Override
	public void run() {
		System.out.println("睡觉了");
		
	}
}
