package com.wangle;


import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

/**
 * 
 * @类 名： Test1 @功能描述： 冒泡排序法 @作者信息： wangle @创建时间： 2019年4月1日下午8:26:21 @修改备注：
 */
public class Test1 {
	static int num = 0;

	/**
	 * @Title : main
	 * @功能描述: TODO
	 * @设定文件：@param args
	 * @返回类型：void
	 * @throws ：
	 */
	public static void main(String[] args) {
		 int[] a = { 1, 31, 21, 21, 2, 24, 3, 33, 3, 4 };
		 
		 for(int i=0;i<a.length;i++){
			 for(int j=i+1;j<a.length;j++){
				 if(a[j]<a[i]){
					 int temp = a[j];
					 a[j] = a[i];
					 a[i] = temp;
				 }
			 }
		 }
		 
		 for (int i : a) {
			System.out.println(i);
		}
	}

}
