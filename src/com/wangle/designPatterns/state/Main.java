package com.wangle.designPatterns.state;

public class Main {
	//状态模式
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//如果现在需要增加一个新的状态，那就很麻烦，需要改动每个方法的代码，所以我们的把每个状态的一套动作给封装起来，来一个新的我直接在新建一套
	//怎么实现呢，看Main2
	static class MM{
		private String name;
		private enum MMState { HAPPY,SAD};
		MMState state;
		public void smile(){//方法会根据state做出不同的动作
			//switch case
		}
		public void cry(){
			
		}
		public void say(){
			
		}
	}

}
