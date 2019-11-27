package com.wangle.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Test013 {
	private final static int MAX = Integer.MAX_VALUE;
	/**
	 * 
	   * @Title : main 
	   * @功能描述: dijkstra,用邻接矩阵表示图
	   * @设定文件：@param args 
	   * @返回类型：void 
	   * @throws ：
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
        int arr[][] = new int[][] {   { 0, 4 , 0, 0 , 0 , 0 , 0, 8 , 0 }, 
                                      { 4, 0 , 8, 0 , 0 , 0 , 0, 11, 0 }, 
                                      { 0, 8 , 0, 7 , 0 , 4 , 0, 0 , 2 }, 
                                      { 0, 0 , 7, 0 , 9 , 14, 0, 0 , 0 }, 
                                      { 0, 0 , 0, 9 , 0 , 10, 0, 0 , 0 }, 
                                      { 0, 0 , 4, 14, 10, 0 , 2, 0 , 0 }, 
                                      { 0, 0 , 0, 0 , 0 , 2 , 0, 1 , 6 }, 
                                      { 8, 11, 0, 0 , 0 , 0 , 1, 0 , 7 }, 
                                      { 0, 0 , 2, 0 , 0 , 0 , 6, 7 , 0 } }; 
         Graph graph = new Graph(arr);
         graph.dijkstraPro(2);

	}
	static class Graph{
		private int[][] graph;
		public Graph(int[][] arr) {
			this.setGraph(arr);
		}
		public int[][] getGraph() {
			return graph;
		}
		public void setGraph(int[][] graph) {
			this.graph = graph;
		}
		
		//用于统计所有节点的父节点，且路径最短
		private int[] parents ;
		//从from节点到to节点的最短路径
		public void shortestPath(int from,int to){
			dijkstraPro(from);
			System.out.println("从节点"+from+"到节点"+to+"的最短路径：");
			Stack<Integer> path = new Stack<>();
			path.add(to);
			while(from!=-1){
				from = parents[path.peek()];
				if(from != -1) 
				path.add(from);
			}
			while(!path.empty()){
				System.out.print(path.pop());
				if(!path.empty()){
					System.out.print("---->");
				}
			}
			System.out.println();
		}
		//狄克斯特拉方法
		public void dijkstraPro(int src){
			if(src>=graph.length){
				try {
					throw new Exception("out of bound");
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}
			//dijkstra的两个要素：距离表dist，标记表visited
			int[] dist = new int[graph.length];
			boolean[] visited = new boolean[graph.length];
			
			//初始化父节点数组
			parents = new int[graph.length];
			for (int i = 0; i < parents.length; i++) {
				parents[i] = -1;
			}
			//初始化距离表
			for (int i = 0; i < graph.length; i++) {
				dist[i] = MAX;
			}
			//设置开始搜索的rootNode
			dist[src] = 0;
			
			for (int i = 0; i < graph.length; i++) {
				int minDistance = minDistance(dist, visited);
				visited[minDistance] = true;
				for (int j = 0; j < graph[minDistance].length; j++) {
					if(!visited[j]&&graph[minDistance][j]!=0&&(dist[minDistance]+graph[minDistance][j])<dist[j]){
						dist[j] = dist[minDistance]+graph[minDistance][j];
						
						parents[j] = minDistance;
					}
				}
				
			}
			printDist(dist);
			
		}
		
		private void printDist(int[] dist){
			System.out.println("Node \t从起点到该点的最短距离");
			for (int i = 0; i < dist.length; i++) {
				System.out.println(i+" \t"+dist[i]);
			}
		}
		private int minDistance(int[] dist,boolean[] visited){
			int min = MAX;
			int min_index = 0;
			for (int i = 0; i < dist.length; i++) {
				if(dist[i]<min&&!visited[i]){
					min = dist[i];
					min_index = i;
				}
			}
			return min_index;
		}
	}
	
	
	

}
