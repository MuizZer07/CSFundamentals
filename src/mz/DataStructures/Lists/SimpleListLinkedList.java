package mz.DataStructures.Lists;

import mz.DataStructures.Lists.DoublyLinkedList.Node;
import mz.Utils.Console;

public class SimpleListLinkedList {
	
	private Node head;
	private int currentSize;
	
	public static class Node{
		int value;
		Node next;
		
		public Node(int val){
			value = val;
			next = null;
		}
	}
	
	public SimpleListLinkedList() {
		this.head = null;
		this.currentSize = 0;
	}
	
	public int getCurrentSize() {
		return this.currentSize;
	}
	
	public void add(int value, int position) {
		if(position == 0 || this.head == null) { // add in the beginning of the list
			this.addInTheBeginning(value);
		}else if(position == -1) { // add in the end of the list
			this.addInTheEnd(value);
		}else {
			this.addAtIndex(value, position);
		}
		this.currentSize++;
	}
	
	private void addInTheBeginning(int value) {
		Node newNode = new Node(value);
		
		if(this.head != null)
			newNode.next = this.head;
		
		this.head = newNode;
	}
	
	private void addInTheEnd(int value) {
		Node newNode = new Node(value);
		Node prevNode = null;
		Node node = this.head;
		
		while(node != null) {
			prevNode = node;
			node = node.next;
		}
	
		
		prevNode.next = newNode;
	}
	
	private void addAtIndex(int value, int index) {
		Node newNode = new Node(value);
		Node node = this.head;
		Node prevNode = null;
		
		int i = 0;
		
		while(node != null) {
			prevNode = node;
			node = node.next;
			
			if(++i == index) {
				break;
			}
		}
		
		if(prevNode != null) {
			prevNode.next = newNode;
			
			if(node != null) {
				newNode.next = node;
			}else {
				newNode.next = null;
			}
		}else {
			this.head.next = newNode;
		}
	}
	
	public Node findNode(int value) {
		Node node = this.head;
		
		while(node != null) {
			if(node.value ==  value) {
				return node;
			}
			node = node.next;
		}
		
		return null;
	}
	
	public int removeAtIndex(int index) {
		int value = -111;
		
		if(index >= this.currentSize)
			return value;
		
		Node node = this.head;
		Node prevNode = null;
		
		if(index == 0) {
			value = node.value;
			this.head = node.next;
		}else {
			int i = 0;
			
			while(node != null) {
				prevNode = node;
				node = node.next;
				
				if(++i == index) {
					value = node.value;
					break;
				}
			}
			
			prevNode.next = node.next;
		}
		
		return value;
	}
	
	public void remove(int value) {
		Node prevNode = null;
		Node node = this.head;
		
		while(node != null) {
			prevNode = node;
			node = node.next;
			
			if(node != null && node.value == value) {
				this.currentSize--;
				break;
			}
		}
	
		if(node != null)
			prevNode.next = node.next;
	}
	
	public void deleteList() {
		this.head = null;
	}
	
	public void printReverse(Node tempHead) {
		if(tempHead == null)
			return;
		
		this.printReverse(tempHead.next);
		
		Console.print(tempHead.value + " ");
	}
	
	public void printReverseList() {
		this.printReverse(this.head);
	}
	
	public void printList() {
		Node node = this.head;
		String str = "";
		
		while(node != null) {
			str += node.value + " ";
			node = node.next;
		}
		
		Console.printLine(str);
	}

	public boolean isEmpty() {
		return this.head == null;
	}
}
