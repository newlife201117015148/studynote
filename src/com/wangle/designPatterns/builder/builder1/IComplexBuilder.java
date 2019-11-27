package com.wangle.designPatterns.builder.builder1;

public interface IComplexBuilder {

	ComplexBuilder buildPart1();
	ComplexBuilder buildPart2();
	ComplexBuilder buildPart3();
	Builder build();
}
