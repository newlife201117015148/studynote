package com.wangle.algorithm;

public class Test001 {
	/**
	 * 
	   * @Title : main 
	   * @功能描述: 完数  = 所有因子相加；如6 = 1+2+3；找出数字n范围内的完数
	   * @设定文件：@param args 
	   * @返回类型：void 
	   * @throws ：
	 */
	public static void main(String[] args) {
		int n = 10000;
		int cyclenum = 0;
		for (int i = 1; i < n; i++) {
			int temp = i;
			for (int j = 1; j <= i/2; j++) {//计算i的所有因子
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
