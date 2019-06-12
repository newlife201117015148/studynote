package com.wangle.javaIO;

public class ÁñÁ«  extends Naicha{
	Naicha n = null;
	public ÁñÁ«(Naicha n){
		this.n = n;
	}
	@Override
	public String getZhizuo() {
		return n.getZhizuo()+"+ÁñÁ«";
	}

	@Override
	public String getName() {
		return "ÁñÁ«"+n.getName();
	}

	@Override
	public float getJiage() {
		return n.getJiage()+2f;
	}
	

}
