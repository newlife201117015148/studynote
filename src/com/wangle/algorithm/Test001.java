package com.wangle.algorithm;

public class Test001 {
	/**
	 * 
	   * @Title : main 
	   * @��������: ����  = ����������ӣ���6 = 1+2+3���ҳ�����n��Χ�ڵ�����
	   * @�趨�ļ���@param args 
	   * @�������ͣ�void 
	   * @throws ��
	 */
	public static void main(String[] args) {
		int n = 10000;
		int cyclenum = 0;
		for (int i = 1; i < n; i++) {
			int temp = i;
			for (int j = 1; j <= i/2; j++) {//����i����������
				if(i%j==0){
					temp -= j;
				}
				if(temp<0) break;
				cyclenum++;
			}
			
			if(temp == 0){
				System.out.println(i);
			}
			
		}
		
		System.out.println(cyclenum);
	}

}
