package com.wangle.dynamicProxy;

public class BirdLogProxy implements Flyable {
	private Flyable flyable;
	 
    public BirdLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

	@Override
	public String  fly() {
		System.out.println("Bird fly start...");
		 
        flyable.fly();
 
        System.out.println("Bird fly end...");

        return null;
	}

}
