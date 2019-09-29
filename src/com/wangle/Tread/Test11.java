package com.wangle.Tread;

import java.util.concurrent.TimeUnit;

public class Test11 {
	private Test11 a = this;
	public static void main(String[] args) {
		Test11 b = new Test11().a;
		Test11 c = new Test11().a;
		System.out.println(b==c);
	}
	
	static class T implements Runnable{
		/*volatile*/ boolean stop = true;
		@Override
		public void run() {
			System.out.println("start ...");
			while(stop){
			}	
			System.out.println("... end");
		}
		
	}
}
