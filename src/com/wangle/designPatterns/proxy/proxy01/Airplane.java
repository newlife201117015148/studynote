package com.wangle.designPatterns.proxy.proxy01;

import java.util.Random;

public class Airplane implements Flyable {

	@Override
	public String fly() {
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("airplane is flying ");

		return null;
	}

}
