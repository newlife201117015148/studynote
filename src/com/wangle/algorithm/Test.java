package com.wangle.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
/**
 * 
   * @�� ���� Test
   * @���������� ��һ��������������鰴������������ұ���ż������
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��9��29������3:43:58
   * @�޸ı�ע��
 */
public class Test {
	public static void reOrderArray(int[] array) {  
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
		int[] array = {2,14,56,7,8,23};
		reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
	
}
