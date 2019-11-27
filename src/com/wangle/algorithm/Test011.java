package com.wangle.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

import com.wangle.algorithm.Test010.Graph;

public class Test011 {
	/**
	 * 
	   * @Title : main 
	   * @功能描述: 广度优先搜索法（改进版）
	   * @设定文件：@param args 
	   * @返回类型：void 
	   * @throws ：
	 */
	public static void main(String[] args) {
		
		GraphNode a = new GraphNode("a0");
		GraphNode b = new GraphNode("b1");
		GraphNode c = new GraphNode("c2");
		GraphNode d = new GraphNode("d3");
		GraphNode e = new GraphNode("e4");
		
		
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
		d.BFS();//表示从d节点开始搜索
		
	}
	
	/*
	 * label:表示节点的名称，代号
	 * adj:表示相邻的节点集合
	 * 
	 */
	static class GraphNode{
		//用邻接表表示一个图
		private String label;
		private ArrayList<GraphNode> adj;
		//用于初始化的构造器
		public GraphNode(String label) {
			this.label = label;
			adj = new ArrayList<GraphNode>();//不要让ajd为null
		}
		//添加边
		public void addEdge(GraphNode node){
			this.adj.add(node);
		}
		//广度优先搜索（breadth First Search）
		void BFS(){
			//储存访问过得节点
			HashSet<GraphNode> visited = new HashSet<>();
			//输出队列
			LinkedList<GraphNode> queue = new LinkedList<>();
			//parents
			Map<GraphNode,GraphNode> parents = new HashMap<>();
			
			//将当前节点作为起始节点
			queue.add(this);
			visited.add(this);
			//起始节点的父节点是start；
			parents.put(this,new GraphNode("start"));
			
			//循环遍历队列
			while(queue.size()!=0){
				//重队列前端弹出一个节点，并打印
				GraphNode temp = queue.poll();
				System.out.print(temp.label+":"+parents.get(temp).label+" ");
				//获得弹出节点的邻居节点
				ArrayList<GraphNode> neighbors = temp.adj;
				for (GraphNode graphnode : neighbors) {
					//过滤掉已经访问的节点
					if(!visited.contains(graphnode)){
						queue.add(graphnode);
						visited.add(graphnode);
						parents.put(graphnode, temp);
					}
				}
			}
		}
	}
}
