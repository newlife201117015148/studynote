package com.wangle.reflect;

/**
 * 
 * @类 名： Test5 @功能描述： 详解运行时类型识别(RTTI, Run-Time Type
 *    Identification)和Class的关系 @作者信息： wangle @创建时间： 2019年5月8日下午5:20:06 @修改备注：
 */
public class Test5 {

	// 运行时类型识别(RTTI, Run-Time Type
	// Identification)是Java中非常有用的机制，在Java运行时，RTTI维护类的相关信息。
	//
	// 多态(polymorphism)是基于RTTI实现的。RTTI的功能主要是由Class类实现的。

	// 运行时类型识别(RTTI, Run-Time Type
	// Information)是Java中非常有用的机制，在java中，有两种RTTI的方式，一种是传统的，
	// 即假设在编译时已经知道了所有的类型；还有一种，是利用反射机制，在运行时再尝试确定类型信息。

	// 问：简单谈谈你对 Java 中 RTTI 与反射的理解？
	//
	// 答：之所以存在 RTTI（Run-Time Type
	// Infomation）运行时类型信息是因为越是优秀的面向对象设计，越强调高内聚低耦合，正如依赖倒转原则所说：“无论是高层模块还是低层模块，都应该针对抽象编程”。
	// 比如说我们有一个抽象父类Shpe.draw(); 方法及三个具体类 Circle.draw(); Square.draw();
	// Triangle.draw();，某些情况下，我们持有 Shape，但却远远不够，
	// 因为我们想要针对它的具体类型进行特殊处理，然而我们的设计完全针对抽象，所以在当前上下文环境中无法判断具体类型。由于 RTTI
	// 的存在，使得我们在不破坏设计的前提下得以达到目的。
	// 事实上，每一个类都持有其对应的 Class 类的对象的引用（Object 类中的 getClass()
	// 能让我们获取到它），其中包含着与类相关的信息。对于每一个类，编译 Java 文件会生成一个二进制 .class 文件，
	// 这个文件中就保存着该类对应的 Class 对象的信息。
	//
	// 在 java 中有两种 RTTI 的方式，一种是传统的，即假设在编译时已经知道了所有的类型；还有一种是利用反射机制在运行时再尝试确定类型信息。
	//
	// 一般大家认为的 RTTI 指的是传统的 RTTI，通过继承和多态来实现，在运行时通过调用超类的方法来实现具体的功能（超类会自动实例化为子类，或使用
	// instanceof）。传统的 RTTI 有 3 种实现方式：
	// 1.向上转型或向下转型（upcasting and downcasting），在 java 中，向下转型（父类转成子类）需要强制类型转换。
	// 2.Class 对象（用了 Class 对象，不代表就是反射，如果只是用 Class 对象 cast成 指定的类，那就还是传统的 RTTI）。
	// 3.对象.instanceof(类) 或 类.isInstance(对象)。
	// 延伸：
	// 对象 instanceof 类
	// obj instanceof class
	// 如果class obj1 = obj成立的话，返回true，否则返回false
	//
	// 类.isInstance(对象)
	// class.isInstance(obj)
	// 如果class obj1 = obj成立的话，返回true，否则返回false
	//
	// 类.class.isAssignableFrom(Class cls)
	// 自身类.class.isAssignableFrom(自身类或子类.class) 返回true
	//
	// 传统的 RTTI 与反射最主要的区别在于 RTTI 在编译期需要 .class 文件，而反射不需要。
	//
	// 传统的 RTTI 使用转型或 Instance 形式实现，但都需要指定要转型的类型，比如 Object obj; Toy toy = (Toy)
	// obj;，其中的 obj 虽然被转型了，但在编译期就需要知道要转成的类型是 Toy，
	// 也就是说编译期间就需要 Toy 的 .class 文件。相对的，反射完全在运行时再通过 Class 类来确定类型，不需要提前加载 Toy 的
	// .class 文件。
	//
	// 所以对于 RTTI 和反射之间的真正区别只在于：
	// 1.RTTI，编译器在编译时打开和检查 .class 文件。
	// 2.反射，运行时打开和检查 .class 文件。
}
