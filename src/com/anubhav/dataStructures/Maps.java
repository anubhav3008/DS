package com.anubhav.dataStructures;



 class Entry<K, V> {
	   K key;
	   V value;
	   Entry<K,V> next;
	   
	   public Entry(K key, V value, Entry<K,V> next){
	   this.key = key;
	   this.value = value;
	   this.next = next;
	   }
	 }
public class Maps<K, V> {
	
		int SIZE=10;
		Entry[] bucket= new Entry[10];
		
		public void put(K key, V val){
			
			Entry<K,V> entry= new Entry(key, val, null);
			int location = getLocation(key);
			
			if(bucket [location]==null){
				bucket[location] = entry;
			}
			else{
				Entry<K,V> headEntry = bucket[location];
				
				while(headEntry.next!=null){
					if(headEntry.key.equals(key)){
						headEntry.value=val;
						return;
					}
					headEntry=headEntry.next;
				}
				if(headEntry.key.equals(key)){
					headEntry.value=val;
				}
				else
					headEntry.next=entry;
			}
		}
		
		
		public V get(K key){
			int location = getLocation(key);
			if(bucket[location]==null){
				return null;
			}
			else { 
				Entry<K,V> headEntry = bucket[location];
				while(headEntry.next!=null){
					if(headEntry.key.equals(key)){
						return headEntry.value;
					}
					headEntry=headEntry.next;
				}
				if(headEntry.key.equals(key)){
					return headEntry.value;
				}
			}
			return null;
			
		}
		
		private int getLocation(K key){
			return (key.hashCode()%SIZE + SIZE )%SIZE;
		}
		
		 
		@Override
		public String toString(){
			StringBuilder sb=new StringBuilder();
			for(Entry entry : bucket){
				Entry head=entry;
				
				while(head!=null && head.next!=null){
					addVals(sb, entry);
					head=head.next;
				}
				if(head!=null)	addVals(sb, head);
			}
			return sb.toString();
			
		}
		
		private void addVals(StringBuilder sb, Entry entry){
			sb.append(entry.key);
			sb.append("=");
			sb.append(entry.value);
			sb.append(",");
		}
		
		
		
}


