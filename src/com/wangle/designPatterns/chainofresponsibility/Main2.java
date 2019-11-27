package com.wangle.designPatterns.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
	//背景介绍：在论坛发表文章，后台系统需要经过信息处理或者进入到数据库。如：敏感词汇
	public static void main(String[] args) {
		
		Msg msg = new Msg();
		msg.setMsg("大家好：），<script>，欢迎访问mashibing.com,大家都是996！");
		
		
		//实际应用中，很可能在处理阶段，在某一节点上，处理不通过，就不再需要继续往下处理，就不用调用后面的节点了
		//思考：怎么实现，一旦处理不通过，怎么结束
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
			str = str.replaceAll("<", "[");//别忘了，返回
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
			str = str.replace("：）", "^_^");
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
	static class FilterChain implements Filter{//再改进，让链条中还可以加链条
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








