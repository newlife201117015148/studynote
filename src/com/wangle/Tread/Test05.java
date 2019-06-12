package com.wangle.Tread;

/**
 * 
   * @类 名： Test05
   * @功能描述： 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15. 接着再由线程1打印16,17,18,19,20….以此类推, 直到打印到75.
   * @作者信息： wangle
   * @创建时间： 2019年5月7日下午1:01:27
   * @修改备注：
 */
public class Test05 {
	
	public static void main(String[] args) {
		Number1 number1 = new Number1(1);
		Number1 number2 = new Number1(2);
		Number1 number3 = new Number1(3);
		
		number1.setName("线程1");
		number2.setName("线程2");
		number3.setName("线程3");
		
		number1.start();
		number3.start();
		number2.start();
	}

}
