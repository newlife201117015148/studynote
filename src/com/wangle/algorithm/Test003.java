package com.wangle.algorithm;

public class Test003 {
	/**
	 * 
	   * @Title : main 
	   * @功能描述: 水仙花数：一个三位数，并且各位上面的数字的3次幂之和等于这个数
	   * 		   找出所有水仙花数
	   * @设定文件：@param args 
	   * @返回类型：void 
	   * @throws ：
	 */
	public static void main(String[] args) {
		
		long time =0;
		time=System.currentTimeMillis();
		for (int i = 100; i < 1000; i++) {//范围在100~999
			int temp  = i;
			int b = temp/100;
			int s = (temp%100)/10;//也可以写成temp-b*100
			int g = temp%10;
			int sum = b*b*b+s*s*s+g*g*g;
			if(temp == sum){
				System.out.println(temp);
			}
		}
		System.out.println(System.currentTimeMillis()-time);
	}

}
