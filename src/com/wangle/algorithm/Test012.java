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
	   * @��������: ��¡ͼ
	   * @�趨�ļ���@param args 
	   * @�������ͣ�void 
	   * @throws ��
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
		 * ����ͼ��ϵ�����ڽӱ��ʾ�ɣ�
		 * 0---->1
		 * 1---->2---->4---->3
		 * 2---->1
		 * 3---->4---->1
		 * 4---->0
		 * 
		 */
		BFS3(d);//��ʾ��d�ڵ㿪ʼ����
		
	}
	//�������������breadth First Search��
	public static UndirectedGraphNode BFS(UndirectedGraphNode anynode){
		//������ʹ��ýڵ�(����ԭʼ�ڵ㣩
		HashSet<UndirectedGraphNode> visited = new HashSet<>();
		//������ʹ��ýڵ�(���渴�ƽڵ㣩
		HashSet<UndirectedGraphNode> visited2 = new HashSet<>();
		//�������
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		
		//����ǰ�ڵ���Ϊ��ʼ�ڵ�
		queue.add(anynode);
		visited.add(anynode);
		//copy
		UndirectedGraphNode copyRootNode = new UndirectedGraphNode(anynode.label);
		visited2.add(copyRootNode);
		//ѭ����������
		while(queue.size()!=0){
			//�ض���ǰ�˵���һ���ڵ㣬����ӡ
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
			//��õ����ڵ���ھӽڵ�
			ArrayList<UndirectedGraphNode> neighbors = temp.adj;
			for (UndirectedGraphNode node : neighbors) {
				//���˵��Ѿ����ʵĽڵ�
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
	//��������������Ľ��������ɣ�hashset��ȡֵ����ʱ�鷳������hashmap
	public static UndirectedGraphNode BFS2(UndirectedGraphNode anynode){
		//������ʹ��ýڵ�(����ԭʼ�ڵ㣩����hashmap
		HashMap<String,UndirectedGraphNode> visited = new HashMap<>();
		//������ʹ��ýڵ�(���渴�ƽڵ㣩����hashmap
		HashMap<String,UndirectedGraphNode> visited2 = new HashMap<>();
		//�������
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		
		//����ǰ�ڵ���Ϊ��ʼ�ڵ�
		queue.add(anynode);
		visited.put(anynode.label,anynode);
		//copy
		UndirectedGraphNode copyRootNode = new UndirectedGraphNode(anynode.label);
		visited2.put(copyRootNode.label,copyRootNode);
		//ѭ����������
		while(queue.size()!=0){
			//�ض���ǰ�˵���һ���ڵ㣬����ӡ
			UndirectedGraphNode temp = queue.poll();
			System.out.print(temp.label+" ");
			//copy
			UndirectedGraphNode copytemp = visited2.get(temp.label);
			
			//��õ����ڵ���ھӽڵ�
			ArrayList<UndirectedGraphNode> neighbors = temp.adj;
			for (UndirectedGraphNode node : neighbors) {
				//���˵��Ѿ����ʵĽڵ�
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
	//��������������ڶ��θĽ��������ɣ���������hashmap���е�ռ��˷ѣ����Կ��Ǻϳ�һ��Hashmap
	public static UndirectedGraphNode BFS3(UndirectedGraphNode anynode){
		//������ʹ��ýڵ�(����ԭʼ�ڵ㣩����hashmap�϶�Ϊһ��keyֵ����ԭʼֵ��value����copyֵ
		HashMap<UndirectedGraphNode,UndirectedGraphNode> visited = new HashMap<>();
		//�������
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		
		//copy
		UndirectedGraphNode copyRootNode = new UndirectedGraphNode(anynode.label);
		//����ǰ�ڵ���Ϊ��ʼ�ڵ�
		queue.add(anynode);
		visited.put(anynode,copyRootNode);
		
		//ѭ����������
		while(queue.size()!=0){
			//�ض���ǰ�˵���һ���ڵ㣬����ӡ
			UndirectedGraphNode temp = queue.poll();
			System.out.print(temp.label+" ");
			//copy
			UndirectedGraphNode copytemp = visited.get(temp);
			
			//��õ����ڵ���ھӽڵ�
			ArrayList<UndirectedGraphNode> neighbors = temp.adj;
			for (UndirectedGraphNode node : neighbors) {
				//���˵��Ѿ����ʵĽڵ�
				if(!visited.containsKey(node)){
					UndirectedGraphNode newcopynode = new UndirectedGraphNode(node.label);
					
					queue.add(node);
					visited.put(node,newcopynode);
					
					copytemp.adj.add(newcopynode);//����copy��
				}else{
					copytemp.adj.add(visited.get(node));
				}
				
			}
		}
		
		return copyRootNode;
	}
	/*
	 * label:��ʾ�ڵ�����ƣ�����
	 * adj:��ʾ���ڵĽڵ㼯��
	 * 
	 */
	static class UndirectedGraphNode{
		//���ڽӱ��ʾһ��ͼ
		private String label;
		private ArrayList<UndirectedGraphNode> adj;
		//���ڳ�ʼ���Ĺ�����
		public UndirectedGraphNode(String label) {
			this.label = label;
			adj = new ArrayList<UndirectedGraphNode>();//��Ҫ��ajdΪnull
		}
		//��ӱ�
		public void addEdge(UndirectedGraphNode node){
			this.adj.add(node);
		}
	}
}
