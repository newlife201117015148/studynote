package com.wangle.algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test010 {
	/**
	 * 
	   * @Title : main 
	   * @功能描述: 广度优先搜索法
	   * @设定文件：@param args 
	   * @返回类型：void 
	   * @throws ：
	 */
	public static void main(String[] args) {
		
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);//数字表示第几个节点。这里表示将数组中第二个节点关联上第一个节点，第一个节点指向第二个节点
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(1, 3);
		graph.addEdge(2, 1);
		graph.addEdge(3, 4);
		graph.addEdge(3, 1);
		graph.addEdge(4, 0);
		/*
		 * 上面图关系可以邻接表表示成：
		 * 0---->1
		 * 1---->2---->4---->3
		 * 2---->1
		 * 3---->4---->1
		 * 4---->0
		 * 
		 */
		graph.BFS(3);
		
	}
	
	/*
	 * index：表示节点数，同时也确定了链表数组的大小
	 * 
	 * adj：表示节点类型，这里节点类型是一个LinkedList表
	 */
	static class Graph{
		//用邻接表表示一个图
		int index;
		LinkedList<Integer>[] adj;
		
		public Graph(int vertices) {
			this.index = vertices;
			this.adj = new LinkedList[vertices];
			for (int i = 0; i < adj.length; i++) {
				adj[i]	= new LinkedList<Integer>();
			}
		}
		//添加边
		public void addEdge(int v,int u){
			adj[v].add(u);
		}
		
		void BFS(int start){
			boolean[] notInQueue = new boolean[index];
			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.add(start);
			notInQueue[start]=true;
			while(queue.size()!=0){
				Integer poll = queue.poll();
				System.out.print(poll+" ");
				LinkedList<Integer> neighbors = adj[poll];
				for (Integer neighbor : neighbors) {
					if(!notInQueue[neighbor]){
						queue.add(neighbor);
						notInQueue[neighbor]=true;
					}
				}
			}
		}
	}
}
