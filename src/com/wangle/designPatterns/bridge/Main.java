package com.wangle.designPatterns.bridge;

public class Main {
	//桥接模式
	//场景：哥哥追美眉需要送礼物，礼物有很多分类，对于Java来说就是一个个抽象类，比如有狂野类型的，温柔类型的，整蛊类型的，也许抽象类下面还有分类
	//然后还有一些实现类穿插在其中，构成一个乱七八糟的网状结构，这么发展下去，可能出现类爆炸。
	//思考：有没有什么方法可以防止类爆炸？
	//解决方案：分为抽象化类和实现化类，将实现化类聚合到抽象化类中，实现桥接.
	//桥接的优点：解决的继承的缺点，实现不受抽象的约束，不用再绑定在一个固定的抽象层次上。
	public static void main(String[] args) {
		GG boy = new GG();
		boy.chase(new MM("小花老师"),new WarmGift(new Flower("flower")));
		boy.chase(new MM("小花老师"),new ColdGift(new Book("book")));
	}
	static class GG{
		public void chase(MM mm ,Gift gift){
			give(mm,gift);
		}
		
		public void give(MM mm,Gift gift){
			System.out.println(mm.getName()+"收到了"+gift.getImpl().getName());
		}
	}
	
	static class MM{
		private String name;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public MM(String name) {
			super();
			this.name = name;
		}
		
		@Override
		public String toString() {
			return "MM [name=" + name + "]";
		}
		
	}
	
	static abstract class Gift{//抽象化类，一般是抽象类,职责：定义子类的行为，和保存一个实现化角色的引用
		GiftImpl Impl;
		public Gift(GiftImpl Impl_) {
			this.Impl = Impl_;
		}
		public GiftImpl getImpl(){
			return Impl;
		}
	}
	static class WarmGift extends Gift{
		public WarmGift(GiftImpl Impl_) {
			super(Impl_);
			String name = "温暖的"+Impl_.getName();
			super.Impl.setName(name);
			
		}
	}
	static class ColdGift extends Gift{

		public ColdGift(GiftImpl Impl_) {
			super(Impl_);
			String name = "冷酷的"+Impl_.getName();
			super.Impl.setName(name);
		}
		
	}
	static abstract class GiftImpl{//实现化角色，一般是抽象类或者接口，定义角色必需的行为和属性
		protected String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	static class Flower extends GiftImpl{
		

		public Flower(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Flower [name=" + name + "]";
		}
		
	}
	static class Book extends GiftImpl{
		public Book(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Book [name=" + name + "]";
		}
	}
	
	
}
