package com.wangle.designPatterns.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class Main3 {
	//�������ܣ�����̳�������£���̨ϵͳ��Ҫ������Ϣ������߽��뵽���ݿ⡣�磺���дʻ�
	public static void main(String[] args) {
		
		Msg msg = new Msg();
		msg.setMsg("��Һã�����<script>����ӭ����mashibing.com,��Ҷ���996��");
		Msg msg2 = new Msg();
		msg.setMsg("��Һã�����<script>����ӭ����mashibing.com,��Ҷ���996��");
		
		//ģ��java�й�����filter�Ĵ���ʽ������request���ˣ�������1,2,3�ֱ�˳����������󷵻أ���ʱ��ͨ��������Ҫ����3,2��1��˳����
		//˼������ôʵ��
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
			str = str.replaceAll("<", "[");//�����ˣ�����
			str = str.replaceAll(">", "]");
			request.setMsg(str); 
			System.out.println(request.getMsg());
			fc.doFilter(request, response, fc);//�ؼ�����
			
			response.setMsg("----HTMLFilter---");//�ؼ����룬response�Ĵ��������ڵ���chain��dofilter����
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
			
			fc.doFilter(request, response, fc);//�ؼ�����
			
			response.setMsg("----SensitiveFilter---");//�ؼ����룬response�Ĵ��������ڵ���chain��dofilter����
			System.out.println(response.getMsg());
			return true;
		}
		
	}
	static class FaceFilter implements Filter{

		@Override
		public boolean doFilter(Msg request,Msg response,FilterChain fc) {
			// TODO Auto-generated method stub
			String str = request.getMsg();
			str = str.replace("����", "^_^");
			request.setMsg(str);
			System.out.println(request.getMsg());
			fc.flag = false;//���Կ���ִ����ĳ��filter����
			fc.doFilter(request, response, fc);//�ؼ�����
			
			response.setMsg("----FaceFilter---");//�ؼ����룬response�Ĵ��������ڵ���chain��dofilter����
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
			fc.doFilter(request, response, fc);//�ؼ�����
			
			response.setMsg("----UrlFilter---");//�ؼ����룬response�Ĵ��������ڵ���chain��dofilter����
			System.out.println(response.getMsg());
			return false;
		}
		
	}
	static class FilterChain implements Filter{
		List<Filter> filters = new ArrayList<Filter>();
		public FilterChain add(Filter f) {
			if(f instanceof FilterChain){//Ŀ���Ǳ�֤�Ž�list�еĶ���ʵ�ʴ����filter��������chain
				for (Filter filter : ((FilterChain) f).filters) {
					filters.add(filter);
				}
			}else{
				filters.add(f);
			}
			return  this;
		}
		int index = 0;//�ƶ�ָ��
		boolean flag = true;
		public boolean doFilter(Msg request,Msg response,FilterChain fc){
			if(index == this.filters.size()) return true;
			if(flag == false) return false;
			Filter f = this.filters.get(index);
			index++;//ÿ����һ�ξͼ�һ��
			f.doFilter(request, response, fc);//����ʵ�ʵĴ���filter��Ȼ����filter�ֵ���chain��dofilter��˵���׾������õݹ�
			return flag;
		}
	}
}








