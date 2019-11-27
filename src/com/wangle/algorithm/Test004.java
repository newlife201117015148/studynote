package com.wangle.algorithm;

public class Test004 {
	/**
	 * 
	   * @Title : main 
	   * @功能描述: 自守数：一个数的平方结果的后几位数等于该数本身。如6的平方是36,25的平方是625；
	   * 		   找出给出范围的所有自守数
	   * @设定文件：@param args 
	   * @返回类型：void 
	   * @throws ：
	 */
	public static void main(String[] args) {
		int n = 10000;
		long time =0;
		time=System.currentTimeMillis();
		for (int i = 1; i < n; i++) {
			int temp  = i;
			int count =1 ;//核心思想：判断如（625-25）%100==0是true还是false，如果是true就表示找到该数。count就是这里的100
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
