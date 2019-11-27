package com.wangle.algorithm;

public class Test002 {
	/**
	 * 
	   * @Title : main 
	   * @功能描述: 亲密数：a的所有因子之和等于b，b的所有因子之和等于a，并且a不等于b；
	   * 		   找出n以内的所有亲密数对
	   * @设定文件：@param args 
	   * @返回类型：void 
	   * @throws ：
	 */
	public static void main(String[] args) {
		
		int n = 50000;
		long time =0;
		time=System.currentTimeMillis();
		for (int i = 2; i < n; i++) {
			
			int a = i;
			int sumOfa = 0;
			for (int j = 1; j <= a/2; j++) {//计算a的所有因子
				if(a%j==0){
					sumOfa += j;
				}
			}
			int b = sumOfa;
			int sumOfb = 0;
			for (int j = 1; j <= b/2; j++) {//计算b的所有因子
				if(b%j==0){
					sumOfb += j;
				}
			}
			
			if(sumOfb == a&&sumOfa>sumOfb){//为什么要用>符号呢？比如220,284亲密数，计算的时候可能会出现计算两次的情况[220,284]和[284,220]
				System.out.println("["+a+","+b+"]");
			}
		}
		System.out.println(System.currentTimeMillis()-time);
	}

}
