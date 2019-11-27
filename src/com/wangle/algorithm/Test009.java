package com.wangle.algorithm;

import java.util.Arrays;
public class Test009 {
	/**
	 * 
	   * @Title : main 
	   * @功能描述: 环形加油站
	   * 
	   * 环形路上有n个加油站，第i个加油站的汽油量是gas[i].
	   * 你有一辆车，车的油箱可以无限装汽油。从加油站i走到下一个加油站（i+1）花费的油量是cost[i]，你从一个加油站出发，刚开始的时候油箱里面没有汽油。
	   * 求从哪个加油站出发可以在环形路上走一圈。返回加油站的下标，如果没有答案的话返回-1。
	   * 注意：
	   * 答案保证唯一。
	   * 
	   * @设定文件：@param args 
	   * @返回类型：void 
	   * @throws ：
	 */
	public static void main(String[] args) {
		int[] arr = {};
		int[] arr2 = {};
		int a = canCompleteCircuit2(arr,arr2);
		System.out.println(a);
	}
	//两种方法都用到了指针的概念，两个方法都没有考虑空数组的情况
	//比较新颖的思维方式
	public static  int canCompleteCircuit(int[] gas, int[] cost) {
        int end = gas.length-1;
        int start = 0;
        int sum = gas[end] - cost[end];
        while(end > start){
            if(sum >= 0){
                sum += gas[start] - cost[start];
                ++start;
            }else{
                --end;
                sum += gas[end] - cost[end];
            }
        }
        return sum >=0 ? end : -1;
    }
	//比较传统、大众的思维方式
	public static int canCompleteCircuit2(int[] gas,int[] cost){
		int start = 0,total = 0,tank = 0;
        for(int i=0;i<gas.length;i++){
            if((tank=tank+gas[i]-cost[i])<0){
                start=i+1;
                total+=tank;
                tank=0;
            }
        }
        return (total+tank<0)?-1:start;
	}
	
}
