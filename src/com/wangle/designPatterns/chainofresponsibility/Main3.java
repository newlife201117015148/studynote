package com.wangle.designPatterns.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class Main3 {
	//背景介绍：在论坛发表文章，后台系统需要经过信息处理或者进入到数据库。如：敏感词汇
	public static void main(String[] args) {
		
		Msg msg = new Msg();
		msg.setMsg("大家好：），<script>，欢迎访问mashibing.com,大家都是996！");
		Msg msg2 = new Msg();
		msg.setMsg("大家好：），<script>，欢迎访问mashibing.com,大家都是996！");
		
		//模拟java中过滤器filter的处理方式，请求request来了，过滤器1,2,3分别按顺序处理，处理完后返回，这时候通过过滤器要按照3,2，1的顺序处理
		//思考：怎么实现
		FilterChain filters = new FilterChain();
		filters.add(new HTMLFilter())
					.add(new SensitiveFilter());
		
		FilterChain filters1 = new FilterChain();
		filters1.add(new FaceFilter())
					.add(new UrlFilter());
		
		filters.add(filters1);
		filters.doFilter(msg,msg2,filters);
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
		boolean doFilter(Msg request,Msg response,FilterChain fc);
	}

	static class HTMLFilter implements Filter{

		@Override
		public boolean doFilter(Msg request,Msg response,FilterChain fc) {
			String str = request.getMsg();
			str = str.replaceAll("<", "[");//别忘了，返回
			str = str.replaceAll(">", "]");
			request.setMsg(str); 
			System.out.println(request.getMsg());
			fc.doFilter(request, response, fc);//关键代码
			
			response.setMsg("----HTMLFilter---");//关键代码，response的处理必须放在调用chain的dofilter后面
			System.out.println(response.getMsg());
			return true;
		}
		
	}

	static class SensitiveFilter implements Filter{

		@Override
		public boolean doFilter(Msg request,Msg response,FilterChain fc) {
			// TODO Auto-generated method stub
			String str = request.getMsg();
			str = str.replace("996", "955");
			request.setMsg(str);
			System.out.println(request.getMsg());
			
			fc.doFilter(request, response, fc);//关键代码
			
			response.setMsg("----SensitiveFilter---");//关键代码，response的处理必须放在调用chain的dofilter后面
			System.out.println(response.getMsg());
			return true;
		}
		
	}
	static class FaceFilter implements Filter{

		@Override
		public boolean doFilter(Msg request,Msg response,FilterChain fc) {
			// TODO Auto-generated method stub
			String str = request.getMsg();
			str = str.replace("：）", "^_^");
			request.setMsg(str);
			System.out.println(request.getMsg());
			fc.flag = false;//可以控制执行在某个filter返回
			fc.doFilter(request, response, fc);//关键代码
			
			response.setMsg("----FaceFilter---");//关键代码，response的处理必须放在调用chain的dofilter后面
			System.out.println(response.getMsg());
			return true;
		}
		
	}
	static class UrlFilter implements Filter{

		@Override
		public boolean doFilter(Msg request,Msg response,FilterChain fc) {
			// TODO Auto-generated method stub
			String str = request.getMsg();
			str = str.replace("mashibing.com", "www.mashibing.com");
			request.setMsg(str);
			System.out.println(request.getMsg());
			fc.doFilter(request, response, fc);//关键代码
			
			response.setMsg("----UrlFilter---");//关键代码，response的处理必须放在调用chain的dofilter后面
			System.out.println(response.getMsg());
			return false;
		}
		
	}
	static class FilterChain implements Filter{
		List<Filter> filters = new ArrayList<Filter>();
		public FilterChain add(Filter f) {
			if(f instanceof FilterChain){//目的是保证放进list中的都是实际处理的filter，而不是chain
				for (Filter filter : ((FilterChain) f).filters) {
					filters.add(filter);
				}
			}else{
				filters.add(f);
			}
			return  this;
		}
		int index = 0;//移动指针
		boolean flag = true;
		public boolean doFilter(Msg request,Msg response,FilterChain fc){
			if(index == this.filters.size()) return true;
			if(flag == false) return false;
			Filter f = this.filters.get(index);
			index++;//每调用一次就加一。
			f.doFilter(request, response, fc);//调用实际的处理filter，然后处理filter又调用chain的dofilter，说到底就是利用递归
			return flag;
		}
	}
}








