package com.wangle;

import java.util.Arrays;

/**
 * �ҳ������в��ظ�������������������Ϊ�ɶԳ��� ���� 1 2 3 4 4 5 5 6 6 ���1 2 3
 * 
 *
 */
public class TheThreeSingleNum {
	
	
	public static void main(String[] args) {
		int[] arr = TheThreeSingleNum.findTheThreeSingleNum(new int[]{1,2,3,4,4,5,5,6,6});
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
 /**
	 * �ҵ�bit��Ϊ1�����һλ���±�
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
	 * ��bitλ���һ��1�����������Ϊ 1 
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
  int x = 0;
  int y = 0;
  // �������õ�x=a^b^c
  for (int i = 0; i < arr.length; i++) {
   x ^= arr[i];
  }
  // �õ� f(x^a)^f(x^b)^f(x^c)
  for (int i = 0; i < arr.length; i++) {
   y ^= saveLast1(x ^ arr[i]);
  }
  // �õ�λ��M
  int M = getLastBitIndexOf1(y);
  int a=0,b=0,c = 0;
  int xorOfAB = 0;
  for (int i = 0; i < arr.length; i++) {
   // ������x����MλΪ1������Ԫ��һ�������ܵó�����һ������ֵ
   if (((x ^ arr[i]) & (1 << M)) == 0) {
    c ^= arr[i];
   }else{ // ʣ���Ԫ�ذ��ҳ������в��ظ���2��Ԫ���������ȼ����a^b
    xorOfAB ^= arr[i];
   }
  }
  // ��a^b������һ��Ϊ1��λ
  int N = getLastBitIndexOf1(xorOfAB);
  // ����һ������
  for (int i = 0; i < arr.length; i++) {
   // ������x����MλΪ1������Ԫ��һ�������ܵó�����һ������ֵ
   if (((x ^ arr[i]) & (1 << M)) == 0) {
   } else { // ʣ���Ԫ�ذ��ҳ������в��ظ���2��Ԫ���������ȼ����a^b
    if ((arr[i] & (1 << N)) == 0) {
     a ^= arr[i];
    } else {
     b ^= arr[i];
    }
   }
  }
  int result[] = new int[3];
  result[0] = a;
  result[1] = b;
  result[2] = c;
  return result;
 }
}
