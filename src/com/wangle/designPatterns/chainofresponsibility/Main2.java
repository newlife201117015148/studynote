package com.wangle.designPatterns.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
	//�������ܣ�����̳�������£���̨ϵͳ��Ҫ������Ϣ������߽��뵽���ݿ⡣�磺���дʻ�
	public static void main(String[] args) {
		
		Msg msg = new Msg();
		msg.setMsg("��Һã�����<script>����ӭ����mashibing.com,��Ҷ���996��");
		
		
		//ʵ��Ӧ���У��ܿ����ڴ���׶Σ���ĳһ�ڵ��ϣ�����ͨ�����Ͳ�����Ҫ�������´����Ͳ��õ��ú���Ľڵ���
		//˼������ôʵ�֣�һ������ͨ������ô����
		FilterChain filters = new FilterChain();
		filters.add(new HTMLFilter())
					.add(new SensitiveFilter());
		
		FilterChain filters1 = new FilterChain();
		filters1.add(new FaceFilter())
					.add(new UrlFilter());
		
		filters.add(filters1);
		filters.doFilter(msg);
		System.out.println(msg.getMsg());
		
	}
	
	
	static class Msg{
		private String name;
		private String msg;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		@Override
		public String toString() {
			return "Msg [name=" + name + ", msg=" + msg + "]";
		}
		
	}

	static interface Filter{
		boolean doFilter(Msg msg);
	}

	static class HTMLFilter implements Filter{

		@Override
		public boolean doFilter(Msg msg) {
			String str = msg.getMsg();
			str = str.replaceAll("<", "[");//�����ˣ�����
			str = str.replaceAll(">", "]");
			msg.setMsg(str); 
			return false;
		}
		
	}

	static class SensitiveFilter implements Filter{

		@Override
		public boolean doFilter(Msg msg) {
			// TODO Auto-generated method stub
			String str = msg.getMsg();
			str = str.replace("996", "955");
			msg.setMsg(str);
			return true;
		}
		
	}
	static class FaceFilter implements Filter{

		@Override
		public boolean doFilter(Msg msg) {
			// TODO Auto-generated method stub
			String str = msg.getMsg();
			str = str.replace("����", "^_^");
			msg.setMsg(str);
			return true;
		}
		
	}
	static class UrlFilter implements Filter{

		@Override
		public boolean doFilter(Msg msg) {
			// TODO Auto-generated method stub
			String str = msg.getMsg();
			str = str.replace("mashibing.com", "www.mashibing.com");
			msg.setMsg(str);
			return true;
		}
		
	}
	static class FilterChain implements Filter{//�ٸĽ����������л����Լ�����
		List<Filter> filters = new ArrayList<Filter>();
		public FilterChain add(Filter f) {
			filters.add(f);
			return  this;
		}
		
		public boolean doFilter(Msg msg){
			boolean flag = true;
			for (Filter filter : filters) {
				flag = filter.doFilter(msg);
				if(flag==false) break;
			}
			return flag;
		}
	}
}








