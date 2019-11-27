package com.wangle.algorithm;

public class Test019 {
//	细胞分裂 有一个细胞 每一个小时分裂一次，一次分裂一个子细胞，第三个小时后会死亡。那么n个小时候有多少细胞？
	// a 初始态 一个小时 前一个小时的 a+b+c
	// b 幼年态 两个小时 前一个小时的 a
	// c 成熟态 三个小时 前一个小时的 b
	
	public static void main(String[] args) {
		System.out.println(allCell(4));
		System.out.println(allCell(5));
		System.out.println(allCell(6));
		System.out.println(allCell(7));
		System.out.println(allCell(8));
	}
	
	
	public static int allCell(int n){
	    return aCell(n)+bCell(n)+cCell(n);
	}
	 // a态细胞
	public static int aCell (int n){
        if(n==1){
            return 1;
        }else{
            return aCell(n-1)+bCell(n-1)+cCell(n-1);
        }
    }
    // b态细胞
	public static int bCell (int n){
        if(n==1){
            return 0;
        }else{
            return aCell(n-1);
        }
    }
    // c态细胞
	public static int cCell (int n){
        if(n==1||n==2){
            return 0;
        }else{
            return bCell(n-1);
        }
    }
}
