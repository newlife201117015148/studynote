package com.wangle;

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
//		int[] a = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4 };
//		singleNumberII(a);
		
//		System.out.println(findNums(new int[]{12,23,1,1,2,2,3,3}));
		MyABS(-12312412);
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
				a[i] += A[j] >> i & 1;
			}
			a[i] %= 3;
			result = result | (a[i] << i);
		}
		return result;
	}

	// ȡ���������׸�Ϊ1��λ��
	public static int findFirstOne(int value) {
		int pos = 0;
		while ((value & 1) != 1) {
			value = value >> 1;
			pos++;
		}
		return pos;
	}

	// ����ĳλ���Ƿ�Ϊ1
	public static boolean testBit(int value, int pos) {
		return ((value >> pos) & 1) == 1 ? true : false;
	}
	//һ�������������棬����������֮�⣬���������ֶ����������Σ�дһ�������ҳ���������
	public static String  findNums(int date[]) {
		int num1  = 0;
		int num2  = 0;
		int length = date.length;
		if (length < 2) {
			return "-1";
		}

		int ansXor = 0;
		int i = 0;
		int pos = 0;

		for (i = 0; i < length; i++) {
			ansXor ^= date[i]; // ���
		}

		pos = findFirstOne(ansXor);

		
		for (i = 0; i < length; i++) {
			if (testBit(date[i], pos)) {
				num1 ^= date[i];
			} else {
				num2 ^= date[i];
			}
		}

		return num1 +"\t"+num2;

	}
	
	public static void MyABS(int fushu){
		if(fushu>=0){
			JOptionPane.showMessageDialog(null, "�����븺��");
			return;
		}
		
		fushu = (fushu ^ -1)+1;
		System.out.println(fushu);
	}
}
