package com.wangle.sort.shellSort;

public class ShellSort {
	//希尔排序
	//思路：1.取一个间隔Gap，以这个间隔距离为基准从第一个元素开始挨个从数组里取出一个个数，组成一个新的子数组，然后对这个子数组进行排序
	//    2.再从第二个元素开始取出一个子数组，进行排序。以此类推，最后从第gap-1个元素取出数组，排序。
	//    3.然后再以gap-1，或者小于gap的数对数组进行取数排序。最后以1取数，排序，整个排序就完成了。
	public static void main(String[] args) {
		int[] arr = {2,4,7,1,3,5,9,8,6};
		System.out.print("原始数据：");
		print(arr);
		sort(arr);
		System.out.print("排好序之后：");
		print(arr);
	}
	public static void sort(int[] arr){
		int index = 1;
		for (int i = arr.length/4; i > 0; i/=2) {
			sortByGap(arr,i);
			System.out.print("第"+index+"遍之后：");
			print(arr);
			index ++;
		}
	}
	public static void sortByGap(int[] arr,int gap){//将最大的数依次往后排
		int temp = 0;
		while(temp<gap){
			for ( int i= temp; i < arr.length-gap; i=i+gap) {
				if(arr[i]>arr[i+gap])
					swap(arr,i,i+gap);
			}
			temp++;
		}
		
	}
	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void print(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
	}


}
