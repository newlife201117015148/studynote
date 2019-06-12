package com.wangle.Tread;

public class Number extends Thread{

	@Override
	public void run() {

		synchronized (String.class) {
			for (int i = 1; i < 53; i++) {
				if(i>1&&i%2==1){
					System.out.print(" ");
				}
				System.out.print(i);

				if (i % 2 == 0) {
					String.class.notify();
					try {
						String.class.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
	}
}
