package com.wangle.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Test012 {
	/**
	 * 
	   * @Title : main 
	   * @功能描述: 克隆图
	   * @设定文件：@param args 
	   * @返回类型：void 
	   * @throws ：
	 */
	public static void main(String[] args) {
		
		UndirectedGraphNode a = new UndirectedGraphNode("a0");
		UndirectedGraphNode b = new UndirectedGraphNode("b1");
		UndirectedGraphNode c = new UndirectedGraphNode("c2");
		UndirectedGraphNode d = new UndirectedGraphNode("d3");
		UndirectedGraphNode e = new UndirectedGraphNode("e4");
		
		
		a.addEdge(b);
		b.addEdge(c);
		b.addEdge(e);
		b.addEdge(d);
		c.addEdge(b);
		d.addEdge(e);
		d.addEdge(b);
		e.addEdge(a);
		/*
		 * 上面图关系可以邻接表表示成：
		 * 0---->1
		 * 1---->2---->4---->3
		 * 2---->1
		 * 3---->4---->1
		 * 4---->0
		 * 
		 */
		BFS3(d);//表示从d节点开始搜索
		
	}
	//广度优先搜索（breadth First Search）
	public static UndirectedGraphNode BFS(UndirectedGraphNode anynode){
		//储存访问过得节点(储存原始节点）
		HashSet<UndirectedGraphNode> visited = new HashSet<>();
		//储存访问过得节点(储存复制节点）
		HashSet<UndirectedGraphNode> visited2 = new HashSet<>();
		//输出队列
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		
		//将当前节点作为起始节点
		queue.add(anynode);
		visited.add(anynode);
		//copy
		UndirectedGraphNode copyRootNode = new UndirectedGraphNode(anynode.label);
		visited2.add(copyRootNode);
		//循环遍历队列
		while(queue.size()!=0){
			//重队列前端弹出一个节点，并打印
			UndirectedGraphNode temp = queue.poll();
			//copy
			UndirectedGraphNode copytemp = null;
			if(temp.label.equals(copyRootNode.label)){
				copytemp = copyRootNode;
			}else{
				for (Iterator<UndirectedGraphNode> iter = visited2.iterator();iter.hasNext();) {
					UndirectedGraphNode next = iter.next();
					if(next.label.equals(temp.label)){
						copytemp = next;
					}
				}
			}
			
			System.out.print(temp.label+" ");
			//获得弹出节点的邻居节点
			ArrayList<UndirectedGraphNode> neighbors = temp.adj;
			for (UndirectedGraphNode node : neighbors) {
				//过滤掉已经访问的节点
				if(!visited.contains(node)){
					queue.add(node);
					visited.add(node);
					UndirectedGraphNode newcopynode = new UndirectedGraphNode(node.label);
					visited2.add(newcopynode);
					copytemp.adj.add(newcopynode);
				}else{
					for (Iterator<UndirectedGraphNode> iter = visited2.iterator();iter.hasNext();) {
						UndirectedGraphNode next = iter.next();
						if(next.label.equals(node.label)){
							copytemp.adj.add(next);
						}
					}
				}
				
			}
		}
		
		return copyRootNode;
	}
	//广度优先搜索（改进），理由：hashset做取值操作时麻烦，换成hashmap
	public static UndirectedGraphNode BFS2(UndirectedGraphNode anynode){
		//储存访问过得节点(储存原始节点）换成hashmap
		HashMap<String,UndirectedGraphNode> visited = new HashMap<>();
		//储存访问过得节点(储存复制节点）换成hashmap
		HashMap<String,UndirectedGraphNode> visited2 = new HashMap<>();
		//输出队列
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		
		//将当前节点作为起始节点
		queue.add(anynode);
		visited.put(anynode.label,anynode);
		//copy
		UndirectedGraphNode copyRootNode = new UndirectedGraphNode(anynode.label);
		visited2.put(copyRootNode.label,copyRootNode);
		//循环遍历队列
		while(queue.size()!=0){
			//重队列前端弹出一个节点，并打印
			UndirectedGraphNode temp = queue.poll();
			System.out.print(temp.label+" ");
			//copy
			UndirectedGraphNode copytemp = visited2.get(temp.label);
			
			//获得弹出节点的邻居节点
			ArrayList<UndirectedGraphNode> neighbors = temp.adj;
			for (UndirectedGraphNode node : neighbors) {
				//过滤掉已经访问的节点
				if(!visited.containsValue(node)){
					queue.add(node);
					visited.put(node.label,node);
					UndirectedGraphNode newcopynode = new UndirectedGraphNode(node.label);
					visited2.put(newcopynode.label,newcopynode);
					copytemp.adj.add(newcopynode);
				}else{
					copytemp.adj.add(visited2.get(node.label));
				}
				
			}
		}
		
		return copyRootNode;
	}
	//广度优先搜索（第二次改进），理由：用了两次hashmap，有点空间浪费，可以考虑合成一个Hashmap
	public static UndirectedGraphNode BFS3(UndirectedGraphNode anynode){
		//储存访问过得节点(储存原始节点）两个hashmap合二为一，key值保存原始值，value保存copy值
		HashMap<UndirectedGraphNode,UndirectedGraphNode> visited = new HashMap<>();
		//输出队列
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		
		//copy
		UndirectedGraphNode copyRootNode = new UndirectedGraphNode(anynode.label);
		//将当前节点作为起始节点
		queue.add(anynode);
		visited.put(anynode,copyRootNode);
		
		//循环遍历队列
		while(queue.size()!=0){
			//重队列前端弹出一个节点，并打印
			UndirectedGraphNode temp = queue.poll();
			System.out.print(temp.label+" ");
			//copy
			UndirectedGraphNode copytemp = visited.get(temp);
			
			//获得弹出节点的邻居节点
			ArrayList<UndirectedGraphNode> neighbors = temp.adj;
			for (UndirectedGraphNode node : neighbors) {
				//过滤掉已经访问的节点
				if(!visited.containsKey(node)){
					UndirectedGraphNode newcopynode = new UndirectedGraphNode(node.label);
					
					queue.add(node);
					visited.put(node,newcopynode);
					
					copytemp.adj.add(newcopynode);//加入copy中
				}else{
					copytemp.adj.add(visited.get(node));
				}
				
			}
		}
		
		return copyRootNode;
	}
	/*
	 * label:表示节点的名称，代号
	 * adj:表示相邻的节点集合
	 * 
	 */
	static class UndirectedGraphNode{
		//用邻接表表示一个图
		private String label;
		private ArrayList<UndirectedGraphNode> adj;
		//用于初始化的构造器
		public UndirectedGraphNode(String label) {
			this.label = label;
			adj = new ArrayList<UndirectedGraphNode>();//不要让ajd为null
		}
		//添加边
		public void addEdge(UndirectedGraphNode node){
			this.adj.add(node);
		}
	}
}
