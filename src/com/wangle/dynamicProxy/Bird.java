package com.wangle.dynamicProxy;

import java.util.Random;

public class Bird implements Flyable ,Runable
{

	@Override
	public String fly() {
		 System.out.println("Bird is flying...");
	        try {
	            Thread.sleep(new Random().nextInt(1000));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        return "hhh";
	}

	@Override
	public void run() {
		System.out.println("Bird is runing...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	}

}
