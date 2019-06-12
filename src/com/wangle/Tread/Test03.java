package com.wangle.Tread;
/**
 * 
   * @类 名： Test3
   * @功能描述： 多线程经典案例练习:三个售票窗口，一共售票20张，售完为止
   * @作者信息： wangle
   * @创建时间： 2019年5月6日下午10:29:39
   * @修改备注：
 */
public class Test03 {
	
	public static void main(String[] args) {
		
		TicketsOffice office1 = new TicketsOffice();
		TicketsOffice office2 = new TicketsOffice();
		TicketsOffice office3 = new TicketsOffice();
	
		office1.start();
		office2.start();
		office3.start();
	}
}
