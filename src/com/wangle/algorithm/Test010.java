package com.wangle.algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test010 {
	/**
	 * 
	   * @Title : main 
	   * @��������: �������������
	   * @�趨�ļ���@param args 
	   * @�������ͣ�void 
	   * @throws ��
	 */
	public static void main(String[] args) {
		
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);//���ֱ�ʾ�ڼ����ڵ㡣�����ʾ�������еڶ����ڵ�����ϵ�һ���ڵ㣬��һ���ڵ�ָ��ڶ����ڵ�
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(1, 3);
		graph.addEdge(2, 1);
		graph.addEdge(3, 4);
		graph.addEdge(3, 1);
		graph.addEdge(4, 0);
		/*
		 * ����ͼ��ϵ�����ڽӱ��ʾ�ɣ�
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
	 * index����ʾ�ڵ�����ͬʱҲȷ������������Ĵ�С
	 * 
	 * adj����ʾ�ڵ����ͣ�����ڵ�������һ��LinkedList��
	 */
	static class Graph{
		//���ڽӱ��ʾһ��ͼ
		int index;
		LinkedList<Integer>[] adj;
		
		public Graph(int vertices) {
			this.index = vertices;
			this.adj = new LinkedList[vertices];
			for (int i = 0; i < adj.length; i++) {
				adj[i]	= new LinkedList<Integer>();
			}
		}
		//��ӱ�
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
