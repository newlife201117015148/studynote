package com.wangle.algorithm;

public class Test002 {
	/**
	 * 
	   * @Title : main 
	   * @��������: ��������a����������֮�͵���b��b����������֮�͵���a������a������b��
	   * 		   �ҳ�n���ڵ�������������
	   * @�趨�ļ���@param args 
	   * @�������ͣ�void 
	   * @throws ��
	 */
	public static void main(String[] args) {
		
		int n = 50000;
		long time =0;
		time=System.currentTimeMillis();
		for (int i = 2; i < n; i++) {
			
			int a = i;
			int sumOfa = 0;
			for (int j = 1; j <= a/2; j++) {//����a����������
				if(a%j==0){
					sumOfa += j;
				}
			}
			int b = sumOfa;
			int sumOfb = 0;
			for (int j = 1; j <= b/2; j++) {//����b����������
				if(b%j==0){
					sumOfb += j;
				}
			}
			
			if(sumOfb == a&&sumOfa>sumOfb){//ΪʲôҪ��>�����أ�����220,284�������������ʱ����ܻ���ּ������ε����[220,284]��[284,220]
				System.out.println("["+a+","+b+"]");
			}
		}
		System.out.println(System.currentTimeMillis()-time);
	}

}
