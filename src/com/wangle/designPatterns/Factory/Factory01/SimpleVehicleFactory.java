package com.wangle.designPatterns.Factory.Factory01;
//��ͨ���ߵļ򵥹���
public class SimpleVehicleFactory {
//�κ��ܲ�������ķ��������࣬�����Գ�֮Ϊ����������Ҳ��һ�ֹ�����
	
	//�򵥹�����һ���׶ˣ�������չ�Բ��ã���ΪһҪ��һ���࣬��ͱ������һ��createXXX()����
	public Car createCar(){
		//������new��ʱ����һЩ�������������־
		System.out.println("car ��������");
		return new Car();
	}
	public Plane createPlane(){
		return new Plane();
	}
	public Broom createBroom(){
		return new Broom();
	}
}
