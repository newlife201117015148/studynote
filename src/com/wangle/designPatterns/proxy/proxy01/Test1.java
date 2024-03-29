package com.wangle.designPatterns.proxy.proxy01;

/**
 * 
 * @类 名： Test1 @功能描述： 代理概念 @作者信息： wangle @创建时间： 2019年5月9日下午2:26:09 @修改备注：
 */
public class Test1 {
	public static void main(String[] args) {
		Bird bird = new Bird();
		BirdTimeProxy p1 = new BirdTimeProxy(new Airplane());
		BirdLogProxy p2 = new BirdLogProxy(p1);

		p2.fly();
	}

	// 1.代理是什么意思？
	// 答：从字面意思来看，代理比较好理解，无非就是代为处理的意思。举个例子，你在上大学的时候，总是喜欢逃课。因此，你拜托你的同学帮你答到，而自己却窝在宿舍玩游戏...
	// 你的这个同学恰好就充当了代理的作用，代替你去上课。
	// 2：为什么需要代理？用途在哪里？
	// 答：有些时候我们有这样的需求,需要在一些接口或者方法前后做一些不影响原有业务逻辑的操作,如添加日志,过滤信息,完成后发短信等等.举个很简单的一个例子，用一个随机睡眠时间模拟
	// 小鸟在空中的飞行时间。接下来问题来了，如果我要知道小鸟在天空中飞行了多久，怎么办？有人说，很简单，在Bird->fly()方法的开头记录起始时间，在方法结束记录完成时间，两个时
	// 间相减就得到了飞行时间。但是如果这个类是原先设计好的，改了怕影响以前的代码，怎么办？也许有人说可以在调用的地方前后记录时间，但是这样的时间可能不准确，因为方法在被调用的
	// 时候，需要开辟一个栈内存，压栈，出栈的操作，这个时间不容忽视.那该怎么实现呢?请看下题:
	// 3.怎么实现代理？
	// 答:到底怎么实现呢?也许有人会想到继承,的确,继承可以实现,就是在新建一个类继承自原先的类,重写该方法,并在方法的前后加入想要代码,中间调用父类的原始方法.但是这样有缺陷,如果我的
	// 需求不只一个呢,不仅要加日志还要加其他过滤条件呢,如果通过再继承,就是来一个需求我就继承上一个这种方式的话,一旦我不需要某个需求了,或者需要换一下需求执行顺序,这种方式就显得
	// 有点的招架不住了.另外一种解决方案就是使用聚合，更准确的说是装饰模式：如/test1/src/com/wangle/dynamicProxy/Test1.java中那样。
	// 4.动态代理和静态代理的区别？
	// 答：简单的说，静态代理是在编码时就确定了代理类，而动态代理是在代码运行时确定了代理类。如前面的例子中生成的BirdLogProxy和BirdTimeProxy，都是Bird的代理类。他们在编码时就确定谁
	// 时代理类，属于静态代理。静态代理虽然在一定程度上已经完美的解决了我们的问题，但是他也有一定的局限性，比如加日志，如果一个类中的多个方法都需要加日志，甚至多个类的方法需要加日志，有没有
	// 可能只需要 一个代理类，就可以帮我们完成任意对象任意个需求呢？动态代理
	// 5.动态代理怎么实现？
	// 答：实现原理详见动态代理.png，具体步骤：准备工作，首先被代理类（委托类）需要实现一个接口，接口里面放你需要处理的方法。然后创建一个实现了invocationHandler的类，将委托类注入
	// 到该类中，形成聚合关系。然后重写invoke()方法，在这里调用委托类方法，在方法前后可以添加处理代码。实际应用的步骤：new出委托类对象，new出自定义的invocationHandler对象传入委托类
	// 对象，然后用proxy的newproxyIntance()方法获取代理类对象，再通过代理类对象调用方法。
	// 6.动态代理有什么应用？
	// 答：Spring中的AOP面向切面编程，Spring
	// AOP的核心实现原理就是采用的动态代理，根据被代理对象是否实现了所要被代理的接口这个条件，动态代理会选择不同的实现方案。
	// JdkDynamicAopProxy和CglibAopProxy。
	// 7.动态代理有哪些实现方式？
	// 答：JDK Proxy 和cglib，cglib通过创建目标类子类的方式来实现代理,因为是子类可以近似调用被使用者的效果。

}
