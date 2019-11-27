package com.wangle.sort.quickSort;

public class QuickSort {
	//��������
	//˼·��1.����˼�룬����������0λ����Ϊbase������left��Ϊ�������ʼָ�룬right��Ϊ�����ĩβָ�롣
	//    2.��֤left<right����£����ұ߿�ʼ���rightλ�õ������ڵ��ڻ�����right++��ֱ��rightλ�õ���С�ڻ�������rightλ���ϵ�������leftλ���ϵ�����
	//    3.��֤left<right����£�Ȼ�����߿�ʼ�����leftλ���ϵ���С�ڵ��ڻ�����left++���������ڻ����������ͽ��串�ǵ�rightλ���ϡ�
	//    4.ֱ��left=right�󣬽�������ֵ��left��right��ϵ�λ���ϡ�
	//    5.Ȼ���Ի�����λ����Ϊ�ָ�㣬������ֳ������֣����õݹ鷽���ظ�����Ĳ��衣
	public static void main(String[] args) {
		int[] arr = {9,1,8,3,6,4,7,2,5};//
		System.out.print("ԭʼ���ݣ�");
		print(arr);
		sort(arr,0,arr.length-1);
		System.out.print("�ź���֮��");
		print(arr);
	}
	public static void sort(int[] arr,int leftBound,int rightBound){
		if(leftBound>=rightBound)return;
		int mid = partition(arr, leftBound, rightBound);
		sort(arr, leftBound, mid-1);
		sort(arr, mid+1, rightBound);
	}
	public static int partition(int[] arr,int left,int right){
		int temp = arr[right];
		while(left<right){//���ܼӵ��ڣ���������while������left>right��,���Ҳ��������÷���ʲôλ����
			//ע��1������������߾ʹ��ұ�ָ�뿪ʼ�Ƚϣ���֮�������ұߣ����ָ�뿪ʼ�ƶ�.
			//ע��2��arr[left]<=temp�еȺŲ���ʡ��
			while(left<right&&arr[left]<=temp){
				left++;
			}
			arr[right] = arr[left];
			while(left<right&&arr[right]>=temp){
				right--;
			} 
			arr[left] = arr[right];
		}
		//whileѭ������������left=right
		arr[right] = temp;
//		print(arr);
		return right;
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
