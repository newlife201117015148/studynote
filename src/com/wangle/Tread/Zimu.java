package com.wangle.Tread;

public class Zimu extends Thread {

	@Override
	public void run() {

		synchronized (String.class) {
			for (char i = 'A'; i <= 'Z'; i++) {
				System.out.print(i);

				String.class.notifyAll();
				if(i<'Z'){
					try {
						String.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}
	}
}
