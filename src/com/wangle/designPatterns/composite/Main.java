package com.wangle.designPatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Main {
	//组合模式
	public static void main(String[] args) {
		
		BranchNode root = new BranchNode("root");
		BranchNode branch1 = new BranchNode("branch1");
		Node b11 = new LeafNode("b11");
		Node b12 = new LeafNode("b12");
		BranchNode branch2 = new BranchNode("branch2");
		Node b21 = new LeafNode("b21");
		Node b22 = new LeafNode("b22");
		
		
		root.add(branch1);
		root.add(branch2);
		
		branch1.add(b11);
		branch1.add(b12);
		
		branch2.add(b21);
		branch2.add(b22);
		
		tree(root,level);
		
	}
	static int level = 0;
	public static void tree(Node node,int level){
		for (int i = 0; i < level; i++) {
			System.out.print("   ");
		}
		node.print();
		if(node instanceof BranchNode){
			for (Node n : ((BranchNode) node).getNodes()) {
				tree(n,level+1);
			}
		}
	}
	
}
abstract class Node{
	abstract void print();
}


class BranchNode extends Node{
	private String name;
	private List<Node> nodes = new ArrayList<Node>();
	
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public void add(Node node){
		nodes.add(node);
	}
	public BranchNode(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	@Override
	void print() {
		// TODO Auto-generated method stub
		System.out.println(this);
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

class LeafNode extends Node{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public LeafNode(String name) {
		// TODO Auto-generated constructor stub
		
		this.name = name;
	}
	@Override
	public String toString() {
		return name ;
	}

	@Override
	void print() {
		// TODO Auto-generated method stub
		System.out.println(this);
	}
	
}