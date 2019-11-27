package com.wangle.algorithm;

public class Test005 {
	/**
	 * 
	 * @Title : main
	 * @功能描述: 求两个数的最大公约数和最小公倍数
	 * 
	 *        两个数m、n，m>n，求最大公约数
	 * 
	 * 		  	核心思路：
	 * 					欧几里得算法：m%n=r;如果r=0，说明r就是最大公约数，如果r！=0，就用n%r，然后在重复前面的步骤，直到取模为零；
	 * 					stein算法:gcd()为最大公约函数,odd表示奇数,even表示偶数
	 * 						gcd(0,a)=a;
	 * 						gcd(2*a,2*b)=2*gcd(a,b)
	 * 						gcd(even,odd)=gcd(even/2,odd)
	 * 						gcd(odd,even)=gcd(odd,even/2)
	 * 						gcd(odd1,odd2)=gcd(|odd1-odd2|,min(odd1,odd2))
	 * 
	 * @设定文件：@param args
	 * @返回类型：void
	 * @throws ：
	 */
	public static void main(String[] args) {
		int a = 8;
		int b = 12;
		int c = upgradeM1(a,b);
		System.out.println(c);//stein(Math.abs(a-b),Math.min(a, b))
		System.out.println(stein(a,b)==stein((Math.abs(a-b))>>2,(a+b)>>2));
	}
	
	/**
	 * 
	   * @Title : m1 
	   * @功能描述: 欧几里得算法
	   * @设定文件：@param a
	   * @设定文件：@param b 
	   * @返回类型：void 
	   * @throws ：
	 */
	public static void m1(int a,int b){
		int m = a>=b?a:b;
		int n = a<=b?a:b;
		long time = 0;
		time = System.currentTimeMillis();
		int temp = m % n;
		while (temp != 0){
			m = n;
			n = temp;
			temp = m%n;
		}
		System.out.println("最大公约数为："+n);
		System.out.println("最小公倍数为："+(a*b)/n);
		System.out.println(System.currentTimeMillis() - time);
	}
	
	public static int upgradeM1(int a,int b){
		int m = a>=b?a:b;
		int n = a<=b?a:b;
		if(n==0) return m;
		return upgradeM1(n,m%n);
	}
	/**
	 * 
	   * @Title : stein 
	   * @功能描述: stein算法
	   * @设定文件：@param a
	   * @设定文件：@param b
	   * @设定文件：@return 
	   * @返回类型：int 
	   * @throws ：
	 */
	public static void m2(int a,int b){
		long time = System.currentTimeMillis();
		int n = stein(a,b);
		System.out.println("最大公约数为："+n);
		System.out.println("最小公倍数为："+(a*b)/n);
		System.out.println(System.currentTimeMillis() - time);
	}
	public static int stein(int a,int b){
	    if(a<b) {a^=b;b^=a;a^=b;}        //交换，使a为较大数； 
	    if(b==0)return a;                    //当相减为零，即两数相等时，gcd=a； 
	    if((a&1)==0&&(b&1)==0) return stein(a>>1,b>>1)<<1;   //s1,注意最后的左移，在递归返回过程中将2因子乘上;找出公约数2
	    else if((a&1)==1&&(b&1)==0)return stein(a,b>>1);            //s2;剔除A中没有，B中有的约数2
	    else if((a&1)==0&&(b&1)==1)return stein(a>>1,b);//s3;  剔除A中有B中没有的约数2
	    else return stein(a-b,b);//欧几里得算法，A和B都没有约数2的话利用该算法将其转换成其他情况，以接近出口。奇数减去一个奇数就是个偶数
	} 

}
