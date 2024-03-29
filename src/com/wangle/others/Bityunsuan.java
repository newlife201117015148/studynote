package com.wangle.others;

import javax.swing.JOptionPane;

public class Bityunsuan {

	static int num = 0;

	/**
	 * @Title : main
	 * @功能描述: TODO
	 * @设定文件：@param args
	 * @返回类型：void
	 * @throws ：
	 */
	public static void main(String[] args) {
		// int[] a = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4 };
		// singleNumberII(a);

		// System.out.println(findNums(new int[]{12,23,1,1,2,2,3,3}));
		// MyABS(-12312412);

//		int a = 12;
//		int b = 1;
//		System.out.println(a++);
//		System.out.println(++a + 1);
//		System.out.println(++a + a);
//		System.out.println(a - a++);
//		System.out.println(a);
//		System.out.println(++a + ++b);
		
		String a = "1";
		method(a);
		System.out.println(a);
	}

	static void method(String a ){
		a = "2";
	}
	public static char byteToChar(byte[] b) {
		char c = (char) (((b[0] & 0xFF) << 8) | (b[1] & 0xFF));
		return c;
	}

	public static int singleNumberII(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int result = 0;
		int a[] = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				a[i] += A[j] >> i & 1;//取每个数二进制数第i位的数，然后求和
			}
			a[i] %= 3;//因为除了这个独数，其它数都出现了三次所以其它数模3都是0，那么该结果就是独数的二进制在第i位的值
			result = result | (a[i] << i);//恢复到第i位上，然后拼接上，就是这个独数的值了
		}
		return result;
	}

	// 取二进制中首个为1的位置
	public static int findFirstOne(int value) {
		int pos = 0;
		while ((value & 1) != 1) {
			value = value >> 1;
			pos++;
		}
		return pos;
	}

	// 测试某位置是否为1
	public static boolean testBit(int value, int pos) {
		return ((value >> pos) & 1) == 1 ? true : false;
	}

	// 一个整数数组里面，除了两个数之外，其他的数字都出现了两次，写一个程序找出这两个数
	public static String findNums(int date[]) {
		int num1 = 0;
		int num2 = 0;
		int length = date.length;
		if (length < 2) {
			return "-1";
		}

		int ansXor = 0;
		int i = 0;
		int pos = 0;

		for (i = 0; i < length; i++) {
			ansXor ^= date[i]; // 异或
		}

		pos = findFirstOne(ansXor);

		for (i = 0; i < length; i++) {
			if (testBit(date[i], pos)) {
				num1 ^= date[i];
			} else {
				num2 ^= date[i];
			}
		}

		return num1 + "\t" + num2;

	}

	public static void MyABS(int fushu) {
		if (fushu >= 0) {
			JOptionPane.showMessageDialog(null, "请输入负数");
			return;
		}

		fushu = (fushu ^ -1) + 1;
		System.out.println(fushu);
	}

}
