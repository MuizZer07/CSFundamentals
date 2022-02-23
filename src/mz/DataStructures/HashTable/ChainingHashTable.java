package mz.DataStructures.HashTable;

import mz.DataStructures.Lists.DoublyLinkedList;
import mz.DataStructures.Lists.DoublyLinkedList.Node;

public class ChainingHashTable {
	private static final int DEFAULT_TABLE_SIZE = 10;
	private int size;
	private DoublyLinkedList[] chainingList;
	private int currentSize;

	public ChainingHashTable() {
		this(DEFAULT_TABLE_SIZE);
	}

	public ChainingHashTable(int x) {
		this.size = x;
		this.currentSize = 0;
		
		this.chainingList  = new DoublyLinkedList[this.size];
		for(int i=0; i<this.size; i++) {
			this.chainingList[i] = new DoublyLinkedList();
		}
	}
	
	private int hashFunction(int x) {
		return x % this.size;
	}
	
	public boolean contains(int x) {
		int hashCode = this.hashFunction(x);
		Node node =  this.chainingList[hashCode].findNode(x);
		
		if(node != null)
			return true;
		
		return false;
	}
	
	public void insert(int x) {
		int hashCode = this.hashFunction(x);
		this.chainingList[hashCode].add(x, -1);
		this.currentSize++;
	}
	
	public void remove(int x) {
		int hashCode = this.hashFunction(x);
		Node node =  this.chainingList[hashCode].findNode(x);
		
		if(node != null) {
			this.chainingList[hashCode].remove(x);
			this.currentSize--;
		}
			
	}
	
	public void makeEmpty() {
		this.currentSize = 0;
		for(int i=0; i<this.size; i++) {
			this.chainingList[i] = new DoublyLinkedList();
		}
	}
	
	public void printHashTable() {
		for(int i=0; i < this.size; i++) {
			this.chainingList[i].printList();
		}
	}

}
