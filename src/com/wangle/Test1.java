package com.wangle;


import java.util.concurrent.Semaphore;

import javax.swing.JOptionPane;

/**
 * 
 * @�� ���� Test1 @���������� ð������ @������Ϣ�� wangle @����ʱ�䣺 2019��4��1������8:26:21 @�޸ı�ע��
 */
public class Test1 {
	static int num = 0;

	/**
	 * @Title : main
	 * @��������: TODO
	 * @�趨�ļ���@param args
	 * @�������ͣ�void
	 * @throws ��
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
