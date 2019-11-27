package com.wangle.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
/**
 * 
   * @类 名： Test
   * @功能描述： 将一个随机的整数数组按照左边是奇数右边是偶数排列
   * @作者信息： wangle
   * @创建时间： 2019年9月29日下午3:43:58
   * @修改备注：
 */
public class Test {
	public static void reOrderArray(int[] array) {  
        for (int i = 0; i < array.length - 1; i++) {  
            for (int j = 0; j < array.length - 1 - i; j++) {  
                // 前偶后奇数就交换  
                if ((array[j] & 1) == 0 && (array[j + 1] & 1) == 1) {  //与1位与得1就是奇数，1只有最后一位是1
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
