/** 
   * @������ : test1
   * @�ļ��� : package-info.java
   * @���߰�����com.wangle.annotations
   * @��������: package-info.java ����ͨ��������ķ�ʽ��������ֻ��ͨ���ļ��ķ�ʽ����Ϊ�������ַ���-����Ҳ�����ڽ�����ʱ��ѡ��ȷ����Ҫ����package-info.java   * @������ ��wangle
   * @����ʱ�䣺2019��5��10�� ����3:23:27
   * @�汾��Ϣ��V1.0 
   */
/**
   * @�� ���� package-info
   * @����������     1��Ϊ�ڰ��ϱ�עAnnotation�ṩ������
				2�������Ѻ���Ͱ�������
				3���ṩ��������ע��˵����
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��10������3:23:27
   * @�޸ı�ע��
   */
@Day
package com.wangle.packages;
//Ĭ�����Ѻ��࣬������public��private�����η�
class PackageInfo{
	public void say(){
		System.out.println("hello");
	}
}
 
class PackageInfoGeneric<T extends Throwable>{
	private T obj;
 
	public void setObj(T obj) {
		this.obj = obj;
	}
	public void say(){
		System.out.println("hello "+obj);
	}
}
//�ӿں�����һ����ֻ��Ĭ��Ϊ�Ѻ��� 
interface PackageInfoInterfaces {
	void test();
}
//���������ĳ���
class PackageInfoConst {
	public static final String MESSAGE="Annotation Study";
}
