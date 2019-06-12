package com.wangle.Tread;
/**
 * 同步方法
   * @类 名： Thread7
   * @功能描述： TODO
   * @作者信息： wangle
   * @创建时间： 2019年5月6日下午10:20:41
   * @修改备注：
 */
public class Thread7 extends Thread {
	Thread6 thread = new Thread6();

	@Override
	public void run() {
		try {
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				thread.add();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread7[] test = new Thread7[10];
		for (int i = 0; i < test.length; i++) {
			test[i] = new Thread7();
		}
		for (Thread7 thread7 : test) {
			thread7.start();
		}

		for (Thread7 thread7 : test) {
			thread7.join();
		}
		System.out.println(new Thread6().getNumber());
		
		
		
		//同步块和同步方法
		//同步块就是用synchronized（obj）{代码}的形式修饰一段代码
		//同步方法就是用synchronized修饰方法的方式
		
		//便于理解，形象比喻：
		//首先两个概念，同步内容就是一个带有门的房间；对象就是开门的钥匙
		
		//但是要实现同步用synchronized不一定能实现，只有多对一，一对一才能实现同步，用比喻的话就是：多个人一把钥匙一个房间；一对一就是同一个人一把钥匙一个房间
		
		//同步方法：分为静态同步方式和实例同步方法。静态同步方法是对类对象进行加锁，实例同步方法是对实例对象进行加锁。
		//同步代码块：synchronized（obj）中的obj分为不变对象和可变对象，即相当于对类对象加锁和对实例对象加锁。
	}
}
