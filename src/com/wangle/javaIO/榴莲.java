package com.wangle.javaIO;

public class ����  extends Naicha{
	Naicha n = null;
	public ����(Naicha n){
		this.n = n;
	}
	@Override
	public String getZhizuo() {
		return n.getZhizuo()+"+����";
	}

	@Override
	public String getName() {
		return "����"+n.getName();
	}

	@Override
	public float getJiage() {
		return n.getJiage()+2f;
	}
	

}
