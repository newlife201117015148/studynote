package com.wangle.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 
   * @�� ���� Test
   * @���������� TODO
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��9��29������3:43:58
   * @�޸ı�ע��
 */
public class Test {
	public void reOrderArray(int[] array) {  
        for (int i = 0; i < array.length - 1; i++) {  
            for (int j = 0; j < array.length - 1 - i; j++) {  
                // ǰż�������ͽ���  
                if ((array[j] & 1) == 0 && (array[j + 1] & 1) == 1) {  //��1λ���1����������1ֻ�����һλ��1
                    array[j] ^= array[j+1];
                    array[j+1] ^= array[j];
                    array[j] ^= array[j+1];
                }  
            }  
        }  
    }
	
	public static void main(String[] args) {
		String a = "a";
		String b = "b";
		
		swap(a,b);
		System.out.println("a��"+a+" b:"+b);
		
	}
	
	public static void swap(String a,String b){
//		String temp = "";
//		temp = a;
//		a=b;
//		b = temp;
		a = "b";
		b = "a";
		System.out.println("a��"+a+" b:"+b);
	}
}
