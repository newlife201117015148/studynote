package com.wangle.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Test014 {
	private final static int MAX = Integer.MAX_VALUE;
	/**
	 * 
	   * @Title : main 
	   * @��������: �����������㷨�����ڶ�̬�滮
	   * 			���Խ����Ȩͼ�����·�����⣬�����ܽ����Ȩ��·
	   * @�趨�ļ���@param args 
	   * @�������ͣ�void 
	   * @throws ��
	 */
	public static void main(String[] args) {
		/**
         *       4--------5----------6
         *       .     .  .          .    .
         *       .  .     .          .       .
         *       3--------2----------8----------7
         *                .                 .   .
         *                .              .      .
         *                .           .         .
         *                .        .            .
         *                .     .               .
         *                .  .                  .
         *                1---------------------0
         */
		//{{u,v,w}}:u��ʾ�ߵ���㣬v��ʾ�ߵ���һ�ˣ�w��ʾȨ��
		int edges[][] = new int[][] {{ 0, 1 , 4}, { 0, 7 , 8 }, 
        							 { 1, 0 , 4}, { 1, 2 , 8 }, { 1, 7 , 11},
        							 { 2, 1 , 8}, { 2, 3 , 7 }, { 2, 5 , 4 }, { 2, 8 , 2},
        							 { 3, 2 , 7}, { 3, 4 , 9 }, { 3, 5 , 14},
        							 { 4, 3 , 9}, { 4, 5 , 10},
        							 { 5, 2 , 4}, { 5, 3 , 14}, { 5, 4 , 10}, { 5, 6 , 2},
        							 { 6, 5 , 2}, { 6, 7 , 1 }, { 6, 8 , 6 },
        							 { 7, 0 , 8}, { 7, 1 , 11}, { 7, 6 , 11}, { 7, 8 , 7},
        							 { 8, 2 , 2}, { 8, 6 , 6 }, { 8, 7 , 7 }
                                      }; 
         Graph graph = new Graph(9,28,edges);
         
         graph.bellman_ford(edges, 2);

	}
	static class Graph{
		private int V;
		private int E;
		private int[][] edges;
		public Graph(int v,int e,int[][] edges) {
			this.V = v;
			this.E = e;
			this.edges = edges;
		}
		
		public void bellman_ford(int[][] edges,int src){
			int[] dist = new int[V];
			for (int i = 0; i < dist.length; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			dist[src] = 0;
			
			for (int i = 0; i < V-1; i++) {
				for (int j = 0; j < E; j++) {
					if(dist[edges[j][0]]!=Integer.MAX_VALUE&&dist[edges[j][0]]+edges[j][2]<dist[edges[j][1]]){
						dist[edges[j][1]] = dist[edges[j][0]]+edges[j][2];
					}
				}
			}
			
			for (int j = 0; j < E; j++) {
				if(dist[edges[j][0]]!=Integer.MAX_VALUE&&dist[edges[j][0]]+edges[j][2]<dist[edges[j][1]]){
					System.out.println("���и�Ȩ����");
				}
			}
			
			printDist(dist);
		}
		private void printDist(int[] dist){
			for (int i = 0; i < dist.length; i++) {
				System.out.println(i+" "+dist[i]);
			}
		}
		public int getV() {
			return V;
		}

		public void setV(int v) {
			V = v;
		}

		public int getE() {
			return E;
		}

		public void setE(int e) {
			E = e;
		}

		public int[][] getEdges() {
			return edges;
		}

		public void setEdges(int[][] edges) {
			this.edges = edges;
		}
		
		
	}
	
	
	

}
