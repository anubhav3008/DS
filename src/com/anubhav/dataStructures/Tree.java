package com.anubhav.dataStructures;

import static com.anubhav.dataStructures.utils.Random.getRandom;

import java.util.LinkedList;
import java.util.Queue;

import com.anubhav.dataStructures.Models.TreeNode;
import com.anubhav.dataStructures.constants.Constants;

public class Tree implements Constants{
	
	public static void main(String args[]){
		
		TreeNode root=getCompleteTree();
		inOrder(root);
		
	}
	
	public static TreeNode getCompleteTree(){
		TreeNode root=new TreeNode(0);
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		
		queue.add(root);
		int i=1;
		while(!queue.isEmpty() && i<Math.pow(2, level) -1){
			TreeNode node=queue.poll();
			TreeNode left=new TreeNode(i++);
			TreeNode right =new TreeNode(i++);
			node.setLeft(left);
			node.setRight(right);
			queue.add(left);
			queue.add(right);
		}
		return root;
	}
	
	
	public static void inOrder (TreeNode node){
		if(node!=null)
		{
		inOrder(node.getLeft());
		System.out.print(node.getData()+ "\t");
		inOrder(node.getRight());
		}
		
	}

}
