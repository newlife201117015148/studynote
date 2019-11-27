package com.wangle.algorithm;

import java.util.Arrays;
public class Test009 {
	/**
	 * 
	   * @Title : main 
	   * @��������: ���μ���վ
	   * 
	   * ����·����n������վ����i������վ����������gas[i].
	   * ����һ���������������������װ���͡��Ӽ���վi�ߵ���һ������վ��i+1�����ѵ�������cost[i]�����һ������վ�������տ�ʼ��ʱ����������û�����͡�
	   * ����ĸ�����վ���������ڻ���·����һȦ�����ؼ���վ���±꣬���û�д𰸵Ļ�����-1��
	   * ע�⣺
	   * �𰸱�֤Ψһ��
	   * 
	   * @�趨�ļ���@param args 
	   * @�������ͣ�void 
	   * @throws ��
	 */
	public static void main(String[] args) {
		int[] arr = {};
		int[] arr2 = {};
		int a = canCompleteCircuit2(arr,arr2);
		System.out.println(a);
	}
	//���ַ������õ���ָ��ĸ������������û�п��ǿ���������
	//�Ƚ���ӱ��˼ά��ʽ
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
	//�Ƚϴ�ͳ�����ڵ�˼ά��ʽ
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
