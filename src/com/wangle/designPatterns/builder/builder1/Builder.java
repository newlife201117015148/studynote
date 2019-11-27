package com.wangle.designPatterns.builder.builder1;

public class Builder {
	private BuilderPart1 part1;
	private BuilderPart2 part2;
	private BuilderPart3 part3;
	
	
	
	public BuilderPart1 getPart1() {
		return part1;
	}
	public void setPart1(BuilderPart1 part1) {
		this.part1 = part1;
	}
	public BuilderPart2 getPart2() {
		return part2;
	}
	public void setPart2(BuilderPart2 part2) {
		this.part2 = part2;
	}
	public BuilderPart3 getPart3() {
		return part3;
	}
	public void setPart3(BuilderPart3 part3) {
		this.part3 = part3;
	}
	@Override
	public String toString() {
		return "Builder [part1=" + part1 + ", part2=" + part2 + ", part3=" + part3 + "]";
	}
	
}
class BuilderPart1{
	private String name;
	private String sex;
	
	public BuilderPart1(String name,String sex) {
		this.name = name;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "BuilderPart1 [name=" + name + ", sex=" + sex + "]";
	}
	
}
class BuilderPart2{
	private String name;
	private String sex;
	
	public BuilderPart2(String name,String sex) {
		this.name = name;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "BuilderPart2 [name=" + name + ", sex=" + sex + "]";
	}

}
class BuilderPart3{
	private String name;
	private String sex;
	
	public BuilderPart3(String name,String sex) {
		this.name = name;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "BuilderPart3 [name=" + name + ", sex=" + sex + "]";
	}
	
}