package com.wangle.designPatterns.bridge;

public class Main {
	//�Ž�ģʽ
	//���������׷��ü��Ҫ����������кܶ���࣬����Java��˵����һ���������࣬�����п�Ұ���͵ģ��������͵ģ��������͵ģ�Ҳ����������滹�з���
	//Ȼ����һЩʵ���ഩ�������У�����һ�����߰������״�ṹ����ô��չ��ȥ�����ܳ����౬ը��
	//˼������û��ʲô�������Է�ֹ�౬ը��
	//�����������Ϊ�������ʵ�ֻ��࣬��ʵ�ֻ���ۺϵ��������У�ʵ���Ž�.
	//�Žӵ��ŵ㣺����ļ̳е�ȱ�㣬ʵ�ֲ��ܳ����Լ���������ٰ���һ���̶��ĳ������ϡ�
	public static void main(String[] args) {
		GG boy = new GG();
		boy.chase(new MM("С����ʦ"),new WarmGift(new Flower("flower")));
		boy.chase(new MM("С����ʦ"),new ColdGift(new Book("book")));
	}
	static class GG{
		public void chase(MM mm ,Gift gift){
			give(mm,gift);
		}
		
		public void give(MM mm,Gift gift){
			System.out.println(mm.getName()+"�յ���"+gift.getImpl().getName());
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
	
	static abstract class Gift{//�����࣬һ���ǳ�����,ְ�𣺶����������Ϊ���ͱ���һ��ʵ�ֻ���ɫ������
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
			String name = "��ů��"+Impl_.getName();
			super.Impl.setName(name);
			
		}
	}
	static class ColdGift extends Gift{

		public ColdGift(GiftImpl Impl_) {
			super(Impl_);
			String name = "����"+Impl_.getName();
			super.Impl.setName(name);
		}
		
	}
	static abstract class GiftImpl{//ʵ�ֻ���ɫ��һ���ǳ�������߽ӿڣ������ɫ�������Ϊ������
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
