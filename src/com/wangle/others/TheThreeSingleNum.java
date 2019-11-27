package com.wangle.others;

import java.util.Arrays;

/**
 * 找出数组中不重复的三个数，其余数皆为成对出现 输入 11 21 31 41 41 51 51 61 61 输出1 2 3
 * 
 *
 */
public class TheThreeSingleNum {
	
	
	public static void main(String[] args) {
		int[] arr = TheThreeSingleNum.findTheThreeSingleNum(new int[]{112,212,312,41,41,51,51,61,61});
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
 /**
	 * 找到bit上为1的最后一位的下标
	 * 
	 * @param n
	 * @return
	 */
 public static int getLastBitIndexOf1(int n) {
  for (int i = 0; i < 32; i++) {
   if ((n & (1 << i)) != 0) {
    return i;
   }
  }
  return -1;
 }
 /**
	 * 将bit位最后一个1保留，其余变为 1 
	 * 1001 
	 * ^ 
	 * 0001 
	 * ---- 
	 * 1000 
	 * & 
	 * 1001 
	 * ------ 
	 * 0001
	 * 
	 * @param n
	 * @return
	 */
 public static int saveLast1(int n) {
  int index = getLastBitIndexOf1(n);
  return 1 << index;
 }
 public static int[] findTheThreeSingleNum(int[] arr) {
	 System.out.println("数组："+Arrays.toString(arr));
  int x = 0;
  int y = 0;
  // 连续异或得到x=a^b^c
  for (int i = 0; i < arr.length; i++) {
   x ^= arr[i];
  }
  System.out.println("所有值异或结果x："+x);
  // 得到 f(x^a)^f(x^b)^f(x^c)
  for (int i = 0; i < arr.length; i++) {
   y ^= saveLast1(x ^ arr[i]);
  }
  System.out.println("函数f(x*a)^f(x*b)^f(x*c)的结果y："+y);
  // 得到位置M
  int M = getLastBitIndexOf1(y);
  System.out.println("M位置:"+M);
  int a=0,b=0,c = 0;
  int xorOfAB = 0;
  for (int i = 0; i < arr.length; i++) {
   // 满足在M位上与x有相同的值就能得出其中一个特殊值
   if (((x ^ arr[i]) & (1 << M)) == 0) {
    c ^= arr[i];
   }else{ // 剩余的元素按找出数组中不重复的2个元素来处理，先计算出a^b
    xorOfAB ^= arr[i];
   }
  }
  // 求a^b倒数第一个为1的位
  int N = getLastBitIndexOf1(xorOfAB);
  System.out.println("N位置:"+N);
  // 再来一次区分
  for (int i = 0; i < arr.length; i++) {
   // 满足在M位上与x有相同的值就能得出其中一个特殊值
   if (((x ^ arr[i]) & (1 << M)) == 0) {
   } else { // 剩余的元素按找出数组中不重复的2个元素来处理，先计算出a^b
    if ((arr[i] & (1 << N)) == 0) {
     a ^= arr[i];
    } else {
     b ^= arr[i];
    }
   }
  }
  System.out.println("所有值异或结果的二进制："+Integer.toBinaryString(x));
  System.out.println("特殊值c二进制："+Integer.toBinaryString(c^x));
  System.out.println("a值异或结果："+Integer.toBinaryString(a^x));
  System.out.println("b值异或结果："+Integer.toBinaryString(b^x));
  System.out.println("c:"+c);
  System.out.println("a:"+a);
  System.out.println("b:"+b);
  int result[] = new int[3];
  result[0] = a;
  result[1] = b;
  result[2] = c;
  return result;
 }
}
