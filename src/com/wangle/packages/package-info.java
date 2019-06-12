/** 
   * @工程名 : test1
   * @文件名 : package-info.java
   * @工具包名：com.wangle.annotations
   * @功能描述: package-info.java 不能通过创建类的方式被创建，只能通过文件的方式，因为有特殊字符“-”，也可以在建包的时候勾选，确认需要创建package-info.java   * @创建人 ：wangle
   * @创建时间：2019年5月10日 下午3:23:27
   * @版本信息：V1.0 
   */
/**
   * @类 名： package-info
   * @功能描述：     1、为在包上标注Annotation提供便利；
				2、声明友好类和包常量；
				3、提供包的整体注释说明。
   * @作者信息： wangle
   * @创建时间： 2019年5月10日下午3:23:27
   * @修改备注：
   */
@Day
package com.wangle.packages;
//默认是友好类，不能用public和private等修饰符
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
//接口和类是一样都只是默认为友好型 
interface PackageInfoInterfaces {
	void test();
}
//定义包级别的常量
class PackageInfoConst {
	public static final String MESSAGE="Annotation Study";
}
