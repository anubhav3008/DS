package src.com.anubhav.dataStructures;

import java.util.HashMap;
import java.util.Map;

public class TrieNodeTest {

}
class TrieNode{
	boolean isLeaf=false;
	char data;
	Map<Character, TrieNode> children= new HashMap<>();
	
	public TrieNode() {}
	
	public TrieNode(char c) {
		this.data=c;
	}
	
}

class Trie{
	TrieNode root= new TrieNode();
	public void insert(String s) {
		Map<Character, TrieNode> children = root.children;
		for(int i=0;i<s.length();i++) {
			TrieNode node;
			if(children.containsKey(s.charAt(i))) {
				node =children.get(s.charAt(i));
			}
			else {
				 node=  new TrieNode(s.charAt(i));
				 children.put(s.charAt(i), node);
			}
			children= node.children;
			if(i==s.length()-1)
				node.isLeaf=true;
		}
	}
	
	public boolean search(String s) {
		TrieNode l= searchNode(s);
		if(l!=null && l.isLeaf)
			return true;
		
	     return false;	
	}
	
	public boolean startsWith(String s) {
		
		if(searchNode(s)==null)
			return false;
		return true;
	}
	
	public TrieNode searchNode(String s){
		
		
		Map<Character, TrieNode> children= root.children;
		TrieNode t = null;
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(children.containsKey(c)) {
				t=children.get(c);
				children=children.get(c).children;
			}
			else
				return null;
		}
		return t;
	
	}
	
}
