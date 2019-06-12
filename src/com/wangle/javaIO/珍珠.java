package com.wangle.javaIO;

public class ÕäÖé extends Naicha{
	Naicha n = null;
	public ÕäÖé(Naicha n){
		this.n = n;
	}
	@Override
	public String getZhizuo() {
		return n.getZhizuo()+"+ÕäÖé";
	}

	@Override
	public String getName() {
		return "ÕäÖé"+n.getName();
	}

	@Override
	public float getJiage() {
		return n.getJiage()+1.5f;
	}
	

}
