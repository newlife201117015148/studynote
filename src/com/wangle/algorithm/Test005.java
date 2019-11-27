package com.wangle.algorithm;

public class Test005 {
	/**
	 * 
	 * @Title : main
	 * @��������: �������������Լ������С������
	 * 
	 *        ������m��n��m>n�������Լ��
	 * 
	 * 		  	����˼·��
	 * 					ŷ������㷨��m%n=r;���r=0��˵��r�������Լ�������r��=0������n%r��Ȼ�����ظ�ǰ��Ĳ��裬ֱ��ȡģΪ�㣻
	 * 					stein�㷨:gcd()Ϊ���Լ����,odd��ʾ����,even��ʾż��
	 * 						gcd(0,a)=a;
	 * 						gcd(2*a,2*b)=2*gcd(a,b)
	 * 						gcd(even,odd)=gcd(even/2,odd)
	 * 						gcd(odd,even)=gcd(odd,even/2)
	 * 						gcd(odd1,odd2)=gcd(|odd1-odd2|,min(odd1,odd2))
	 * 
	 * @�趨�ļ���@param args
	 * @�������ͣ�void
	 * @throws ��
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
	   * @��������: ŷ������㷨
	   * @�趨�ļ���@param a
	   * @�趨�ļ���@param b 
	   * @�������ͣ�void 
	   * @throws ��
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
		System.out.println("���Լ��Ϊ��"+n);
		System.out.println("��С������Ϊ��"+(a*b)/n);
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
	   * @��������: stein�㷨
	   * @�趨�ļ���@param a
	   * @�趨�ļ���@param b
	   * @�趨�ļ���@return 
	   * @�������ͣ�int 
	   * @throws ��
	 */
	public static void m2(int a,int b){
		long time = System.currentTimeMillis();
		int n = stein(a,b);
		System.out.println("���Լ��Ϊ��"+n);
		System.out.println("��С������Ϊ��"+(a*b)/n);
		System.out.println(System.currentTimeMillis() - time);
	}
	public static int stein(int a,int b){
	    if(a<b) {a^=b;b^=a;a^=b;}        //������ʹaΪ�ϴ����� 
	    if(b==0)return a;                    //�����Ϊ�㣬���������ʱ��gcd=a�� 
	    if((a&1)==0&&(b&1)==0) return stein(a>>1,b>>1)<<1;   //s1,ע���������ƣ��ڵݹ鷵�ع����н�2���ӳ���;�ҳ���Լ��2
	    else if((a&1)==1&&(b&1)==0)return stein(a,b>>1);            //s2;�޳�A��û�У�B���е�Լ��2
	    else if((a&1)==0&&(b&1)==1)return stein(a>>1,b);//s3;  �޳�A����B��û�е�Լ��2
	    else return stein(a-b,b);//ŷ������㷨��A��B��û��Լ��2�Ļ����ø��㷨����ת��������������Խӽ����ڡ�������ȥһ���������Ǹ�ż��
	} 

}
