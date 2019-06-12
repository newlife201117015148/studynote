package com.wangle;
/**
 * 
   * @类 名： Test7
   * @功能描述： 运行多态的经典例题详解
   * @作者信息： wangle
   * @创建时间： 2019年4月2日上午11:56:02
   * @修改备注：
 */
public class Test7 {
//    面向对象编程有三大特性：封装、继承、多态。
//
//    封装隐藏了类的内部实现机制，可以在不影响使用的情况下改变类的内部结构，同时也保护了数据。对外界而已它的内部细节是隐藏的，
//    暴露给外界的只是它的访问方法。
//
//    继承是为了重用父类代码。两个类若存在IS-A的关系就可以使用继承。，同时继承也为实现多态做了铺垫。
//
//    所谓多态就是指程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时并不确定，而是在程序运行期间才确定，
//    即一个引用变量倒底会指向哪个类的实例对象，该引用变量发出的方法调用到底是哪个类中实现的方法，必须在由程序运行期间才能决定。
//    因为在程序运行时才确定具体的类，这样，不用修改源程序代码，就可以让引用变量绑定到各种不同的类实现上，从而导致该引用调用的具体方法随之改变，
//    即不修改程序代码就可以改变程序运行时所绑定的具体代码，让程序可以选择多个运行状态，这就是多态性。
	
	
//	    指向子类的父类引用由于向上转型了，它只能访问父类中拥有的方法和属性，而对于子类中存在而父类中不存在的方法，该引用是不能使用的，
//	    尽管是重载该方法。若子类重写了父类中的某些方法，在调用该些方法的时候，必定是使用子类中定义的这些方法（动态连接、动态调用）。
//
//    对于面向对象而已，多态分为编译时多态和运行时多态。其中编译时多态是静态的，主要是指方法的重载，它是根据参数列表的不同来区分不同的函数，
//    通过编辑之后会变成两个不同的函数，在运行时谈不上多态。而运行时多态是动态的，它是通过动态绑定来实现的，也就是我们所说的多态性
	
//	多态的实现机制遵循一个原则：当超类对象引用变量引用子类对象时，被引用对象的类型而不是引用变量的类型决定了调用谁的成员方法，
//	但是这个被调用的方法必须是在超类中定义过的，也就是说被子类覆盖的方法。
	
//	     在Java中有两种形式可以实现多态。继承和接口。
	
//	其实在继承链中对象方法的调用存在一个优先级：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。
//	this代表的是引用变量，super代表的是引用变量的父类。(super)O是指O的父类。
	public class A {
		    public String show(D obj) {
		        return ("A and D");
		    }

		    public String show(A obj) {
		        return ("A and A");
		    } 
		    
		    public String show(C obj){
				return ("A and C");
			}
		}

		public class B extends A{
		    public String show(B obj){
		        return ("B and B");
		    }
		    
		    public String show(A obj){
		        return ("B and A");
		    } 
		}

		public class C extends B{
			public String show(B obj){
				return ("C and B");
			}
			
			public String show(C obj){
				return ("C and C");
			}
		}

		public class D extends B{

		}

		    public static void main(String[] args) {
		    	Test7 t = new Test7();
		        A a1 = t.new A();
		        A a2 = t.new B();
		        B b = t.new B();
		        C c = t.new C();
		        B c1 = t.new C();
		        D d = t.new D();
		        B d1 = t.new D();
		        //引用变量类型和引用对象类型都是A类
		        System.out.println("1--" + a1.show(b));//this.show(obj)，A类中show(B b)没有-->super.show(obj);A父类中没有show(B b)-->this.show((super)O),(super)O为A类，所以show(A a);
		        System.out.println("2--" + a1.show(c));//A类中show(C c)没有-->C的父类B，show(B b)没有-->B的父类A，show(A a);
		        System.out.println("3--" + a1.show(d));//A类中show(D d);
		        //引用变量类型是A类，引用对象类型是B类
		        System.out.println("4--" + a2.show(b));//this.show(obj);A类中show(B b)没有-->super.show(obj);A父类中没有show(B b)-->this.show((super)O),(super)O为A类;A类中show(A a);发现被子类重写，所以调用B类中的show(A a);
		        System.out.println("5--" + a2.show(c));//this.show(obj);A类中show(B b)没有-->super.show(obj);A父类中没有show(B b)-->this.show((super)O),(super)O为B类、A类;A类中show(A a);发现被子类重写，所以调用B类中的show(A a);
		        System.out.println("6--" + a2.show(d));//this.show(obj);A类中show(D d);
		        //引用变量类型是B类，引用对象类型是B类
		        System.out.println("7--" + b.show(b));//B类中，show(B b)
		        System.out.println("8--" + b.show(c));//B类中，show(C c)没有-->super.show(obj);A类.show(C c)没有-->this.show((super)O),B类.show(B b);
		        System.out.println("9--" + b.show(d));//B类中，show(D d)没有-->super.show(obj);A类.show(D d);
		        
		        System.out.println("10--"+ c.show(a1));
		        System.out.println("11--"+ c1.show(c));
		        System.out.println("12--"+ d1.show(c));
		        
		        String aa= "abcd";
		        String bb = "ab";
		        String cc = bb + "cd";
		        String dd = "ab" + "cd";
		        System.out.println(aa==cc);
		        System.out.println(aa==dd);
		        System.out.println(cc==dd);
		    
		    }
		    //总结：如果 父类（接口）   p = new 子类();称为A类型，类  L = new 类();称为B类型；不管哪种类型都是遵循：
		    //this.show(O)、super(...一直向上找).show(O)、this.show((super(...一直向上找))O)、super(...一直向上找).show((super(...一直向上找))O)规则，但在A类型时，
		    //如果通过规则判断出调用的是超类的方法，同时该方法被引用对象类型所重写了，那么最终调用的是引用对象类型中的方法。如果该方法没有被引用对象类型重写，即便是被继承同一超类的其他类重写了，
		    //最终还是调用超类中的方法。
	
}
