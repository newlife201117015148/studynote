package com.wangle.designPatterns.state;

public class Main2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MM m = new MM();
		m.name = "�绨";
		m.state = MM.MMState.HAPPY;
		switch (m.state) {
		case HAPPY:
			new HappyMMState().smile(m);
			break;

		default:
			break;
		}
	}
	static class MM{
		private String name;
		private enum MMState { HAPPY,SAD};
		MMState state;
	}

	//ʹ��ǰ����:�ӿڷ������ᾭ���䣬��Ϊһ�������仯�����඼���
	static interface MMState{
		void smile(MM mm);
		void cry(MM mm);
		void say(MM mm);
	}
	
	static class HappyMMState implements MMState{

		@Override
		public void smile(MM mm) {
			// TODO Auto-generated method stub
			System.out.println("happy smile");
		}

		@Override
		public void cry(MM mm) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void say(MM mm) {
			// TODO Auto-generated method stub
			
		}
		
	}
	static class SadMMState implements MMState{

		@Override
		public void smile(MM mm) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void cry(MM mm) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void say(MM mm) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
