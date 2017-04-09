package com.anubhav.dataStructures.Models;

public class TreeNode {
	int data;
	TreeNode left=null;
	TreeNode right=null;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public TreeNode(int data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode(){}
	public TreeNode(int data){
		this.data=data;
		
	}
	

}
