package com.wangle.designPatterns.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class Main {
	//背景介绍：在论坛发表文章，后台系统需要经过信息处理或者进入到数据库。如：敏感词汇
	public static void main(String[] args) {
		
		Msg msg = new Msg();
		msg.setMsg("大家好：），<script>，欢迎访问mashibing.com,大家都是996！");
		//处理文字
		//最简单的方式，来一个filter就new一个，简单粗暴
//		new HTMLFilter().doFilter(msg);
//		new SensitiveFilter().doFilter(msg);
		
		//思考：如果又来一个filter呢，有没有更好的写法
//		List<Filter> filters = new ArrayList<Filter>();
//		filters.add(new HTMLFilter());
//		filters.add(new SensitiveFilter());
//		for (Filter filter : filters) {
//			filter.doFilter(msg);
//		}
		
		//其实可以再进行封装一下
//		FilterChain1 filters2 = new FilterChain1();
//		filters2.add(new HTMLFilter());
//		filters2.add(new SensitiveFilter());
//		filters2.doFilter(msg);
		
		//用改进版的filterchain，实现链式编程
//		FilterChain2 filters3 = new FilterChain2();
//		filters3.add(new HTMLFilter())
//					.add(new SensitiveFilter());
//		filters3.doFilter(msg);
		
		
//		//再改进：链条中加链条
		FilterChain3 filters4 = new FilterChain3();//链条一
		filters4.add(new HTMLFilter())
					.add(new SensitiveFilter());
		
		FilterChain3 filters5 = new FilterChain3();//链条二
		filters5.add(new FaceFilter())
					.add(new UrlFilter());
		
		filters4.add(filters5);
		filters4.doFilter(msg);
		System.out.println(msg.getMsg());
		
	}
}

class Msg{
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

interface Filter{
	void doFilter(Msg msg);
}

class HTMLFilter implements Filter{

	@Override
	public void doFilter(Msg msg) {
		String str = msg.getMsg();
		str = str.replaceAll("<", "[");//别忘了，返回
		str = str.replaceAll(">", "]");
		msg.setMsg(str); 
	}
	
}

class SensitiveFilter implements Filter{

	@Override
	public void doFilter(Msg msg) {
		// TODO Auto-generated method stub
		String str = msg.getMsg();
		str = str.replace("996", "955");
		msg.setMsg(str);
		
	}
	
}
class FaceFilter implements Filter{

	@Override
	public void doFilter(Msg msg) {
		// TODO Auto-generated method stub
		String str = msg.getMsg();
		str = str.replace("：）", "^_^");
		msg.setMsg(str);
		
	}
	
}
class UrlFilter implements Filter{

	@Override
	public void doFilter(Msg msg) {
		// TODO Auto-generated method stub
		String str = msg.getMsg();
		str = str.replace("mashibing.com", "www.mashibing.com");
		msg.setMsg(str);
		
	}
	
}
class FilterChain1{//这个版本不太好，看下面的改进版
	List<Filter> filters = new ArrayList<Filter>();
	public void add(Filter f) {
		filters.add(f);
	}
	
	public void doFilter(Msg msg){
		for (Filter filter : filters) {
			filter.doFilter(msg);
		}
	}
}
class FilterChain2{//改进版
	List<Filter> filters = new ArrayList<Filter>();
	public FilterChain2 add(Filter f) {
		filters.add(f);
		return  this;
	}
	
	public void doFilter(Msg msg){
		for (Filter filter : filters) {
			filter.doFilter(msg);
		}
	}
}
class FilterChain3 implements Filter{//再改进，让链条中还可以加链条
	List<Filter> filters = new ArrayList<Filter>();
	public FilterChain3 add(Filter f) {
		filters.add(f);
		return  this;
	}
	
	public void doFilter(Msg msg){
		for (Filter filter : filters) {
			filter.doFilter(msg);
		}
	}
}







