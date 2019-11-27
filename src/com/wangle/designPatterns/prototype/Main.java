package com.wangle.designPatterns.prototype;

public class Main {
	//原型模式/也叫克隆模式
	//相当于java中object.clone()
	public static void main(String[] args) throws Exception {
		Location loc = new Location("china");
		Person p = new Person("GAI",123,new int[]{1,2,3},loc);
		
		Person  pc = (Person)p.clone();
		
		System.out.println(pc.getLoc() == p.getLoc());
		loc.addr = "America";
		p.scores[0] = 2;
		System.out.println(pc.getLoc().getAddr());
		System.out.println(pc.getScores()[0]);
	}
	
	static class Person implements Cloneable{//必须实现标记性接口Cloneable
		private String name;
		private int id;
		private int[] scores;
		private Location loc;
		public Person(String name, int id, int[] scores, Location loc) {
			super();
			this.name = name;
			this.id = id;
			this.scores = scores;
			this.loc = loc;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int[] getScores() {
			return scores;
		}
		public void setScores(int[] scores) {
			this.scores = scores;
		}
		public Location getLoc() {
			return loc;
		}
		public void setLoc(Location loc) {
			this.loc = loc;
		}
		
		@Override
		public Object clone() throws CloneNotSupportedException {//protected--->public
			Person p = (Person) super.clone();
			
			p.setLoc((Location)p.loc.clone());
			int[] sc = p.getScores();
			int[] copy = new  int[sc.length];
			System.arraycopy(sc, 0, copy, 0, sc.length);
			p.setScores(copy);
			return p;
		}
		
	}

	
	static class Location implements Cloneable{
		private String addr;

		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public Location(String addr) {
			super();
			this.addr = addr;
		}
		@Override
		public Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}
	}
}
