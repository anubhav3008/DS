package com.anubhav.problems.tree;

import java.util.Stack;

import com.anubhav.dataStructures.Tree;
import com.anubhav.dataStructures.Models.TreeNode;
import com.anubhav.dataStructures.constants.Constants;

public class ZigZag {

	public static void main(String args[]){
		TreeNode node =Tree.getCompleteTree();
		boolean ltr=false;
		for(int i=0;i<Constants.level;i++){

			TraverseZigZag(node, i,ltr);
			ltr=!ltr;

		}
		System.out.println();
		
		TraverseZigZag(Tree.getCompleteTree());


	}
	/*
	 * 
	 * 
	 * Recursive : exponential : bad solution
	 */
	public static void TraverseZigZag(TreeNode node, int level, boolean ltr){
		if(level==0)
			System.out.print(node.getData()+"\t");
		else
		{
			if(ltr){
				TraverseZigZag(node.getLeft(), level-1, ltr);
				TraverseZigZag(node.getRight(), level-1, ltr);
			}
			else
			{
				TraverseZigZag(node.getRight(), level-1, ltr);
				TraverseZigZag(node.getLeft(), level-1, ltr);

			}
		}
	}
/*
 * 
 * 
 * Iterative : use two stacks
 */

	public static void TraverseZigZag(TreeNode node){
		Stack<TreeNode> rightToLeft=new Stack<TreeNode>();
		Stack<TreeNode> leftToRight=new Stack<TreeNode>();

		leftToRight.push(node);
		while(!leftToRight.isEmpty() || !rightToLeft.isEmpty()){
			while(!leftToRight.isEmpty()){
				TreeNode popped=leftToRight.pop();
				if(popped!=null){
					System.out.print(popped.getData()+"\t");
					if(popped.getRight()!=null)rightToLeft.push(popped.getRight());
					if(popped.getLeft()!=null)rightToLeft.push(popped.getLeft());
				}
			}
			while(!rightToLeft.empty()){
				TreeNode popped=rightToLeft.pop();
				if(popped!=null){
					System.out.print(popped.getData()+"\t");
					if(popped.getLeft()!=null)leftToRight.push(popped.getLeft());
					if(popped.getRight()!=null)leftToRight.push(popped.getRight());
				}
			}
		}

	}

}
