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
   * @类 名： Test007
   * @功能描述： 狄克斯特拉算法：解决正数加权图的最短路径。单源正权图
   * @作者信息： wangle
   * @创建时间： 2019年10月19日下午5:33:43
   * @修改备注：
 */
public class Test007 {

	public static void main(String[] args) {
		System.out.println("example1：");
		example1();
		System.out.println("---------------------------------");
		System.out.println("example2：");
		example2();
		System.out.println("---------------------------------");
		System.out.println("example3：");
		example3();
		
	}
	
	
	public static void example3(){
		//准备一个Graph图
				Map<String,Node[]> graph = new HashMap<String,Node[]>();
				graph.put("A", new Node[]{new Node("C",20)});
				graph.put("B", new Node[]{new Node("A",1)});
				graph.put("C",new Node[]{new Node("B",1),new Node("final",30)});
				graph.put("final", new Node[]{});
				//准备一个记录每个节点开销的集合
				HashMap<String,Node> costs = new HashMap<String,Node>();
				costs.put("A", new Node("A",10));
				costs.put("B", new Node("B",Integer.MAX_VALUE));
				costs.put("C", new Node("C",Integer.MAX_VALUE));
				costs.put("final",new Node("final",Integer.MAX_VALUE));
				
				//准备一个储存父节点的散列表
				HashMap<String,String> parents = new HashMap<String,String>();
				parents.put("A", "start");
				parents.put("B", "");
				parents.put("C", "");
				parents.put("final", "");
				
				Node node = find_lowest_cost_node(costs);//找到开销最小的节点
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
		//准备一个Graph图
		Map<String,Node[]> graph = new HashMap<String,Node[]>();
		graph.put("A", new Node[]{new Node("D",4),new Node("C",2)});
		graph.put("B", new Node[]{new Node("A",8),new Node("C",7)});
		graph.put("C",new Node[]{new Node("final",1)});
		graph.put("D",new Node[]{new Node("C",6),new Node("final",3)});
		graph.put("final", new Node[]{});
		//准备一个记录每个节点开销的集合
		HashMap<String,Node> costs = new HashMap<String,Node>();
		costs.put("A", new Node("A",5));
		costs.put("B", new Node("B",2));
		costs.put("C", new Node("C",Integer.MAX_VALUE));
		costs.put("D", new Node("D",Integer.MAX_VALUE));
		costs.put("final",new Node("final",Integer.MAX_VALUE));
		
		//准备一个储存父节点的散列表
		HashMap<String,String> parents = new HashMap<String,String>();
		parents.put("A", "start");
		parents.put("B", "start");
		parents.put("C", "");
		parents.put("D", "");
		parents.put("final", "");
		
		Node node = find_lowest_cost_node(costs);//找到开销最小的节点
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
		//准备一个Graph图
				Map<String,Node[]> graph = new HashMap<String,Node[]>();
				graph.put("start", new Node[]{new Node("A",6),new Node("B",2)});
				
				graph.put("A", new Node[]{new Node("final",1)});
				
				graph.put("B", new Node[]{new Node("A",3),new Node("final",5)});
				
				graph.put("final", new Node[0]);
				
				
				//准备一个记录每个节点开销的集合
				HashMap<String,Node> costs = new HashMap<String,Node>();
				costs.put("A", new Node("A",6));
				costs.put("B",new Node("B",2));
				costs.put("final",new Node("final",Integer.MAX_VALUE));
				
				//准备一个储存父节点的散列表
				HashMap<String,String> parents = new HashMap<String,String>();
				parents.put("A", "start");
				parents.put("B", "start");
				parents.put("final","");//目前不知道其父节点
				
				Node node = find_lowest_cost_node(costs);//找到开销最小的节点
				dijkstra(node,graph,costs,parents);
				
				for (Entry<String,Node> entry : costs.entrySet()) {
					System.out.println(entry.getValue().getName()+"\t:  "+entry.getValue().getCost());
				}
				
				HashMap<String,String> parentscopy =parents;
				sortPrint("start",parentscopy);
				System.out.println();
	}
	//不能使用在A-----D   C-----final   start-----A   start-----B   A-----C这种情况，有待改进
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
		int cost = node.getCost();//该节点在costs中的开销
		Node[] nodes = graph.get(node.getName());//获取该节点的所有邻居节点
		for (int i = 0; i < nodes.length; i++) {//遍历邻居节点
			int new_cost = cost + nodes[i].getCost();
			if(new_cost<costs.get(nodes[i].getName()).getCost()){//比较经由node节点到邻居节点的开销和邻居节点自己原来的开销大小
				costs.get(nodes[i].getName()).setCost(new_cost);//小的话，更新邻居节点的开销
				parents.put(nodes[i].getName(),node.getName());
			}
		}
		costs.get(node.getName()).setState(true);
		
		node = find_lowest_cost_node(costs);//找到开销最小的节点
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
		private boolean state;//node状态，计算过为true，没计算过为false，默认为false

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
