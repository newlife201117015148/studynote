package com.wangle.designPatterns.builder.builder1;

public class ComplexBuilder implements IComplexBuilder{

	Builder builder = new Builder();

	@Override
	public ComplexBuilder buildPart1() {
		builder.setPart1(new BuilderPart1("a","ÄĞ"));
		return this;
	}

	@Override
	public ComplexBuilder buildPart2() {
		builder.setPart2(new BuilderPart2("b","ÄĞ"));
		return this;
	}

	@Override
	public ComplexBuilder buildPart3() {
		builder.setPart3(new BuilderPart3("c","ÄĞ"));
		return this;
	}

	@Override
	public Builder build() {
		return builder;
	}

	

}
