package com.wangle.algorithm;

public class Test004 {
	/**
	 * 
	   * @Title : main 
	   * @��������: ��������һ������ƽ������ĺ�λ�����ڸ���������6��ƽ����36,25��ƽ����625��
	   * 		   �ҳ�������Χ������������
	   * @�趨�ļ���@param args 
	   * @�������ͣ�void 
	   * @throws ��
	 */
	public static void main(String[] args) {
		int n = 10000;
		long time =0;
		time=System.currentTimeMillis();
		for (int i = 1; i < n; i++) {
			int temp  = i;
			int count =1 ;//����˼�룺�ж��磨625-25��%100==0��true����false�������true�ͱ�ʾ�ҵ�������count���������100
			int c = temp;
			while( c >0){
				c /=10;
				count *=10;
			}
			int pingfang  = temp*temp;
			if((pingfang-temp)%count==0){
				System.out.println(temp);
			}
		}
		System.out.println(System.currentTimeMillis()-time);
	}

}
