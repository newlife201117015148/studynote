package com.wangle.algorithm;

public class Test003 {
	/**
	 * 
	   * @Title : main 
	   * @��������: ˮ�ɻ�����һ����λ�������Ҹ�λ��������ֵ�3����֮�͵��������
	   * 		   �ҳ�����ˮ�ɻ���
	   * @�趨�ļ���@param args 
	   * @�������ͣ�void 
	   * @throws ��
	 */
	public static void main(String[] args) {
		
		long time =0;
		time=System.currentTimeMillis();
		for (int i = 100; i < 1000; i++) {//��Χ��100~999
			int temp  = i;
			int b = temp/100;
			int s = (temp%100)/10;//Ҳ����д��temp-b*100
			int g = temp%10;
			int sum = b*b*b+s*s*s+g*g*g;
			if(temp == sum){
				System.out.println(temp);
			}
		}
		System.out.println(System.currentTimeMillis()-time);
	}

}
