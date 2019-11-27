package com.wangle.designPatterns.strategy.strategy03;

public class CatHeightComparetor implements Comparetor<Cat>{

	@Override
	public int compare(Cat o1, Cat o2) {
		return o1.getHeight()>o2.getHeight()?1:o1.getHeight()==o2.getHeight()?0:-1;
	}


}
