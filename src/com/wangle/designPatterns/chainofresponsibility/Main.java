package com.wangle.designPatterns.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class Main {
	//�������ܣ�����̳�������£���̨ϵͳ��Ҫ������Ϣ������߽��뵽���ݿ⡣�磺���дʻ�
	public static void main(String[] args) {
		
		Msg msg = new Msg();
		msg.setMsg("��Һã�����<script>����ӭ����mashibing.com,��Ҷ���996��");
		//��������
		//��򵥵ķ�ʽ����һ��filter��newһ�����򵥴ֱ�
//		new HTMLFilter().doFilter(msg);
//		new SensitiveFilter().doFilter(msg);
		
		//˼�����������һ��filter�أ���û�и��õ�д��
//		List<Filter> filters = new ArrayList<Filter>();
//		filters.add(new HTMLFilter());
//		filters.add(new SensitiveFilter());
//		for (Filter filter : filters) {
//			filter.doFilter(msg);
//		}
		
		//��ʵ�����ٽ��з�װһ��
//		FilterChain1 filters2 = new FilterChain1();
//		filters2.add(new HTMLFilter());
//		filters2.add(new SensitiveFilter());
//		filters2.doFilter(msg);
		
		//�øĽ����filterchain��ʵ����ʽ���
//		FilterChain2 filters3 = new FilterChain2();
//		filters3.add(new HTMLFilter())
//					.add(new SensitiveFilter());
//		filters3.doFilter(msg);
		
		
//		//�ٸĽ��������м�����
		FilterChain3 filters4 = new FilterChain3();//����һ
		filters4.add(new HTMLFilter())
					.add(new SensitiveFilter());
		
		FilterChain3 filters5 = new FilterChain3();//������
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
		str = str.replaceAll("<", "[");//�����ˣ�����
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
		str = str.replace("����", "^_^");
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
class FilterChain1{//����汾��̫�ã�������ĸĽ���
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
class FilterChain2{//�Ľ���
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
class FilterChain3 implements Filter{//�ٸĽ����������л����Լ�����
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







