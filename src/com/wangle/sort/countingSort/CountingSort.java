package com.wangle.sort.countingSort;

import java.util.Arrays;

public class CountingSort {

	//��������
	//˼·��1.���������ǲ���Ҫ�Ƚϵģ������ص������ַ�ΧС������������
	//     2.��ԭʼ�����ֵ��Ϊcount����������±꣬���±��ֵ��¼�������ֵĴ�����Ȼ�����ν�count������±갴����ȡֵ���������С�
	//    3.Ϊ��ʹ������ȶ��ԣ������ۼ����飬��ֵ��¼���Ƕ�Ӧ�±꣬Ҳ����ԭʼ���ݵ�ֵ�������������������λ�á�ǰ���ǵ������ԭʼ���顣
	public static void main(String[] args) {
		int[] arr = new int[]{2,6,4,7,9,6,5,4,3,7,9,2,8,1,0,0,0};
		System.out.println(Arrays.toString(arr));
		sort(arr);
	}
	//���������������������Ҫ�Ż���
	//1.��ԭʼ���鲻��0~9������4~6����ô��Ȼcount����ֿռ��˷�
	//2.���ڵ������ǲ��ȶ��ģ��ڴ�count��ȡ����newarr��ʱ����û��˳�����ġ�
	public static void sort1(int[] arr){
		int[] newarr = new int[arr.length];

		int[] count = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++ ;
		}
		System.out.println(Arrays.toString(count));
		int index = 0;
		for (int i = 0; i < count.length; i++) {
			while(count[i]>0){
				
				newarr[index++] = i;
				count[i]--;
			}
		}
		System.out.println(Arrays.toString(newarr));
	}
	//�Ľ���
	public static void sort(int[] arr){
		int[] newarr = new int[arr.length];
		
		int min = findMin(arr);
		int max = findMax(arr);
		int[] count = new int[max-min+1];
		
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]-min]++ ;
		}
		System.out.println(Arrays.toString(count));
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i-1]+count[i];
		}
		System.out.println(Arrays.toString(count));
		for (int i = arr.length-1; i >= 0; i--) {
			//�ҵ�arr[i]���ź�����������е�λ�ã��ٸ�ֵ��
			newarr[--count[arr[i]]]= arr[i];
		}
		System.out.println(Arrays.toString(newarr));
		
	}
	
	public static int findMin(int[] arr){
		int min = 0;
		for (int i = 1; i < arr.length; i++,min++) {
			if(arr[min]<arr[i]){
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
		return arr[arr.length -1];
	}
	public static int findMax(int[] arr){
		int max = 0;
		for (int i = 1; i < arr.length; i++,max++) {
			if(arr[max]>arr[i]){
				int temp = arr[max];
				arr[max] = arr[i];
				arr[i] = temp;
			}
		}
		return arr[arr.length -1];
	}
}
