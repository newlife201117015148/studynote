package com.wangle;
/**
 * 
   * @�� ���� Test5
   * @���������� forѭ����Ӧ��
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��4��1������8:22:15
   * @�޸ı�ע��
 */
public class Test5 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			for (int j = 1; j < 10-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i+1; j++) {
//				if(j%2!=0){
//					System.out.print("*");
//				}else{
//					System.out.print(" ");
//				}
				if(j==0||j== 2*i){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
				
//				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*(10-i)-1; j++) {
//				if(j%2!=0){
//					System.out.print("*");
//				}else{
//					System.out.print(" ");
//				}
				
				if(j==0||j== 2*(10-i)-2){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
				
//				System.out.print("*");
			}
			System.out.println();
		}
	}
}
