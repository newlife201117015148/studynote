package com.wangle.Tread;
/**
 * 同步方法
   * @类 名： Thread6
   * @功能描述： TODO
   * @作者信息： wangle
   * @创建时间： 2019年5月6日下午10:21:10
   * @修改备注：
 */
public class Thread6{

	private static int number = 0;

	public static int getNumber() {
		return number;
	}

	public static   synchronized void add() {
		number++;
	}
	
}
