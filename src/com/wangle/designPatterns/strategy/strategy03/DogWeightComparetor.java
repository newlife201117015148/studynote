package com.wangle.designPatterns.strategy.strategy03;

public class DogWeightComparetor implements Comparetor<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {

		if(o1.getWeight()<o2.getWeight()) return -1;
		else if(o1.getWeight()>o2.getWeight()) return 1;
		else return 0;
	}


}
