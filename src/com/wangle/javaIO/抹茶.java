package com.wangle.javaIO;

public class Ĩ��  extends Naicha{
	Naicha n = null;
	public Ĩ��(Naicha n){
		this.n = n;
	}
	@Override
	public String getZhizuo() {
		return n.getZhizuo()+"+Ĩ��";
	}

	@Override
	public String getName() {
		return "Ĩ��"+n.getName();
	}

	@Override
	public float getJiage() {
		return n.getJiage()+1f;
	}
	

}
