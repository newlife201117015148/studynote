package com.wangle.packages;

public class Test {

	public static void main(String[] args) {
		PackageInfo packageInfo = new PackageInfo();
		packageInfo.say();
		
		PackageInfoGeneric<Exception> generic = new PackageInfoGeneric<Exception>();
		generic.setObj(new RuntimeException(" is Error"));
		generic.say();
		
		
		a a = new a ();
		a.test();
		
		System.out.println(PackageInfoConst.MESSAGE);
	}
	

}
class a implements PackageInfoInterfaces{

	@Override
	public void test() {
		System.out.println("interface test");
		
	}
	
} 