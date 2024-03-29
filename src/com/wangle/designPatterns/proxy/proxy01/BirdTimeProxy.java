package com.wangle.designPatterns.proxy.proxy01;

public class BirdTimeProxy implements Flyable {
	private Flyable flyable;
	 
    public BirdTimeProxy(Flyable flyable) {
        this.flyable = flyable;
    }

	@Override
	public String fly() {
		long start = System.currentTimeMillis();
		 
        flyable.fly();
 
        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));

        return null;

	}

}
