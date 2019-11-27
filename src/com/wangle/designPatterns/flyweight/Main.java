package com.wangle.designPatterns.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Main {
	//��Ԫģʽ���ظ����ö��󣩹���Ԫ����
	//����java���ַ����Ĵ���ʽһ�����ַ����������е���ֱ�Ӹ��������ģ�û�вŻ����new һ��
	//�����ͱ�������Դ�˷�
	public static void main(String[] args) {
		BulletPool pool = new BulletPool();
		Bullet b1 = pool.getBullet();
		Bullet b2 = pool.getBullet();
		Bullet b3 = pool.getBullet();
		Bullet b4 = pool.getBullet();
		Bullet b5 = pool.getBullet();
		pool.back(b5);
		Bullet b6 = pool.getBullet();
		Bullet b7 = pool.getBullet();
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(b5);
		System.out.println(b6);
		System.out.println(b7);
	}
	
	
}

class Bullet {
	private int name ;
	private boolean living = true;
	public Bullet(int name){
		this.name = name;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public boolean isLiving() {
		return living;
	}
	public void setLiving(boolean living) {
		this.living = living;
	}
	@Override
	public String toString() {
		return "Bullet [name=" + name + ", living=" + living + "]";
	}
	
	
}

class BulletPool{
	List<Bullet> bullets = new ArrayList<>();
	
	public BulletPool(){
		for (int i = 0; i < 5; i++) {
			bullets.add(new Bullet(i));
		}
	}
	public void back(Bullet b){
		b.setLiving(true);
	}
	public Bullet getBullet(){
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			if(bullet.isLiving()){
				bullet.setLiving(false);
				return bullet;
			} 
		}
		Bullet b = new Bullet(99);
		this.bullets.add(b);
		return b;
	}
}
