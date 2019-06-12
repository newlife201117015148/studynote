package com.wangle.javaIO;

public class Ä¨²è  extends Naicha{
	Naicha n = null;
	public Ä¨²è(Naicha n){
		this.n = n;
	}
	@Override
	public String getZhizuo() {
		return n.getZhizuo()+"+Ä¨²è";
	}

	@Override
	public String getName() {
		return "Ä¨²è"+n.getName();
	}

	@Override
	public float getJiage() {
		return n.getJiage()+1f;
	}
	

}
