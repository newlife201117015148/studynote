package com.wangle.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
   * @�� ���� Test007
   * @���������� �ҿ�˹�����㷨�����������Ȩͼ�����·������Դ��Ȩͼ
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��10��19������5:33:43
   * @�޸ı�ע��
 */
public class Test007 {

	public static void main(String[] args) {
		System.out.println("example1��");
		example1();
		System.out.println("---------------------------------");
		System.out.println("example2��");
		example2();
		System.out.println("---------------------------------");
		System.out.println("example3��");
		example3();
		
	}
	
	
	public static void example3(){
		//׼��һ��Graphͼ
				Map<String,Node[]> graph = new HashMap<String,Node[]>();
				graph.put("A", new Node[]{new Node("C",20)});
				graph.put("B", new Node[]{new Node("A",1)});
				graph.put("C",new Node[]{new Node("B",1),new Node("final",30)});
				graph.put("final", new Node[]{});
				//׼��һ����¼ÿ���ڵ㿪���ļ���
				HashMap<String,Node> costs = new HashMap<String,Node>();
				costs.put("A", new Node("A",10));
				costs.put("B", new Node("B",Integer.MAX_VALUE));
				costs.put("C", new Node("C",Integer.MAX_VALUE));
				costs.put("final",new Node("final",Integer.MAX_VALUE));
				
				//׼��һ�����游�ڵ��ɢ�б�
				HashMap<String,String> parents = new HashMap<String,String>();
				parents.put("A", "start");
				parents.put("B", "");
				parents.put("C", "");
				parents.put("final", "");
				
				Node node = find_lowest_cost_node(costs);//�ҵ�������С�Ľڵ�
				dijkstra(node,graph,costs,parents);
				
				for (Entry<String,Node> entry : costs.entrySet()) {
					System.out.println(entry.getValue().getName()+"\t:  "+entry.getValue().getCost());
				}
				
				HashMap<String,String> parentscopy =parents;
				System.out.println("node \t-----  parents   ");
				for (Entry<String, String> entry : parents.entrySet()) {
					
					System.out.println(entry.getKey()+"\t-----  "+entry.getValue()+"   ");
					
					
				}
	}
	public static void example2(){
		//׼��һ��Graphͼ
		Map<String,Node[]> graph = new HashMap<String,Node[]>();
		graph.put("A", new Node[]{new Node("D",4),new Node("C",2)});
		graph.put("B", new Node[]{new Node("A",8),new Node("C",7)});
		graph.put("C",new Node[]{new Node("final",1)});
		graph.put("D",new Node[]{new Node("C",6),new Node("final",3)});
		graph.put("final", new Node[]{});
		//׼��һ����¼ÿ���ڵ㿪���ļ���
		HashMap<String,Node> costs = new HashMap<String,Node>();
		costs.put("A", new Node("A",5));
		costs.put("B", new Node("B",2));
		costs.put("C", new Node("C",Integer.MAX_VALUE));
		costs.put("D", new Node("D",Integer.MAX_VALUE));
		costs.put("final",new Node("final",Integer.MAX_VALUE));
		
		//׼��һ�����游�ڵ��ɢ�б�
		HashMap<String,String> parents = new HashMap<String,String>();
		parents.put("A", "start");
		parents.put("B", "start");
		parents.put("C", "");
		parents.put("D", "");
		parents.put("final", "");
		
		Node node = find_lowest_cost_node(costs);//�ҵ�������С�Ľڵ�
		dijkstra(node,graph,costs,parents);
		
		for (Entry<String,Node> entry : costs.entrySet()) {
			System.out.println(entry.getValue().getName()+"\t:  "+entry.getValue().getCost());
		}
		
		HashMap<String,String> parentscopy =parents;
		System.out.println("node \t-----  parents   ");
		for (Entry<String, String> entry : parents.entrySet()) {
			
			System.out.println(entry.getKey()+"\t-----  "+entry.getValue()+"   ");
			
			
		}
//		sortPrint("start",parentscopy);
		System.out.println();
	}
	public static void example1(){
		//׼��һ��Graphͼ
				Map<String,Node[]> graph = new HashMap<String,Node[]>();
				graph.put("start", new Node[]{new Node("A",6),new Node("B",2)});
				
				graph.put("A", new Node[]{new Node("final",1)});
				
				graph.put("B", new Node[]{new Node("A",3),new Node("final",5)});
				
				graph.put("final", new Node[0]);
				
				
				//׼��һ����¼ÿ���ڵ㿪���ļ���
				HashMap<String,Node> costs = new HashMap<String,Node>();
				costs.put("A", new Node("A",6));
				costs.put("B",new Node("B",2));
				costs.put("final",new Node("final",Integer.MAX_VALUE));
				
				//׼��һ�����游�ڵ��ɢ�б�
				HashMap<String,String> parents = new HashMap<String,String>();
				parents.put("A", "start");
				parents.put("B", "start");
				parents.put("final","");//Ŀǰ��֪���丸�ڵ�
				
				Node node = find_lowest_cost_node(costs);//�ҵ�������С�Ľڵ�
				dijkstra(node,graph,costs,parents);
				
				for (Entry<String,Node> entry : costs.entrySet()) {
					System.out.println(entry.getValue().getName()+"\t:  "+entry.getValue().getCost());
				}
				
				HashMap<String,String> parentscopy =parents;
				sortPrint("start",parentscopy);
				System.out.println();
	}
	//����ʹ����A-----D   C-----final   start-----A   start-----B   A-----C����������д��Ľ�
	public static void sortPrint(String node,HashMap<String,String> parents){
		if(parents.isEmpty()) {
			System.out.print("final"); 
			return;
		}
		for (Iterator<Entry<String, String>> iterator = parents.entrySet().iterator();iterator.hasNext();) {
			Entry<String, String> entry = iterator.next();
			if(entry.getValue().equals(node)){
				System.out.print(node+"--->");
				node = entry.getKey();
				iterator.remove();
			}
		}
		sortPrint(node,parents);
	}
	//dijkstra
	public static void dijkstra(Node node,Map<String,Node[]> graph,HashMap<String,Node> costs,HashMap<String,String> parents){
		if(node ==null) return;
		int cost = node.getCost();//�ýڵ���costs�еĿ���
		Node[] nodes = graph.get(node.getName());//��ȡ�ýڵ�������ھӽڵ�
		for (int i = 0; i < nodes.length; i++) {//�����ھӽڵ�
			int new_cost = cost + nodes[i].getCost();
			if(new_cost<costs.get(nodes[i].getName()).getCost()){//�ȽϾ���node�ڵ㵽�ھӽڵ�Ŀ������ھӽڵ��Լ�ԭ���Ŀ�����С
				costs.get(nodes[i].getName()).setCost(new_cost);//С�Ļ��������ھӽڵ�Ŀ���
				parents.put(nodes[i].getName(),node.getName());
			}
		}
		costs.get(node.getName()).setState(true);
		
		node = find_lowest_cost_node(costs);//�ҵ�������С�Ľڵ�
		dijkstra(node,graph,costs,parents);
	}
	public static Node find_lowest_cost_node(HashMap<String,Node> costs){
		int lowest_cost = Integer.MAX_VALUE;
		Node lowest_cost_node = null;
		for (Entry<String, Node> entry : costs.entrySet()) {
			boolean isProcessed = entry.getValue().isState();
			if(entry.getValue().getCost()<lowest_cost&&!isProcessed){
				lowest_cost = entry.getValue().getCost();
				lowest_cost_node = entry.getValue();
			}
		}
		return lowest_cost_node;
	}
	static class Node{
		private String name;
		private int cost;
		private boolean state;//node״̬�������Ϊtrue��û�����Ϊfalse��Ĭ��Ϊfalse

		public Node() {
			// TODO Auto-generated constructor stub
		}
		
		public Node(String name,int cost){
			this.name = name;
			this.cost = cost;
		}
		public boolean isState() {
			return state;
		}

		public void setState(boolean state) {
			this.state = state;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCost() {
			return cost;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}
		
		
	}
	

}
