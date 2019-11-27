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
	   * @��������: ����������������Ľ��棩
	   * @�趨�ļ���@param args 
	   * @�������ͣ�void 
	   * @throws ��
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
		 * ����ͼ��ϵ�����ڽӱ��ʾ�ɣ�
		 * 0---->1
		 * 1---->2---->4---->3
		 * 2---->1
		 * 3---->4---->1
		 * 4---->0
		 * 
		 */
		d.BFS();//��ʾ��d�ڵ㿪ʼ����
		
	}
	
	/*
	 * label:��ʾ�ڵ�����ƣ�����
	 * adj:��ʾ���ڵĽڵ㼯��
	 * 
	 */
	static class GraphNode{
		//���ڽӱ��ʾһ��ͼ
		private String label;
		private ArrayList<GraphNode> adj;
		//���ڳ�ʼ���Ĺ�����
		public GraphNode(String label) {
			this.label = label;
			adj = new ArrayList<GraphNode>();//��Ҫ��ajdΪnull
		}
		//��ӱ�
		public void addEdge(GraphNode node){
			this.adj.add(node);
		}
		//�������������breadth First Search��
		void BFS(){
			//������ʹ��ýڵ�
			HashSet<GraphNode> visited = new HashSet<>();
			//�������
			LinkedList<GraphNode> queue = new LinkedList<>();
			//parents
			Map<GraphNode,GraphNode> parents = new HashMap<>();
			
			//����ǰ�ڵ���Ϊ��ʼ�ڵ�
			queue.add(this);
			visited.add(this);
			//��ʼ�ڵ�ĸ��ڵ���start��
			parents.put(this,new GraphNode("start"));
			
			//ѭ����������
			while(queue.size()!=0){
				//�ض���ǰ�˵���һ���ڵ㣬����ӡ
				GraphNode temp = queue.poll();
				System.out.print(temp.label+":"+parents.get(temp).label+" ");
				//��õ����ڵ���ھӽڵ�
				ArrayList<GraphNode> neighbors = temp.adj;
				for (GraphNode graphnode : neighbors) {
					//���˵��Ѿ����ʵĽڵ�
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
