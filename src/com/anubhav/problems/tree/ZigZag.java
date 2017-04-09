package com.anubhav.problems.tree;

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
		
		
	}
	/*
	 * 
	 * 
	 * Recursive : exponential : bad solution
	 */
	public static void TraverseZigZag(TreeNode node, int level, boolean ltr){
		if(level==0)
			System.out.print(node.getData());
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

}
