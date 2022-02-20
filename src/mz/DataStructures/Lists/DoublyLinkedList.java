package mz.DataStructures.Lists;
import mz.Utils.Console;

public class DoublyLinkedList {

	Node head;
	Node tail;
	int currentSize;
	
	public static class Node{
		Node prev;
		Node next;
		int value;
		
		Node(int val){
			value = val;
			prev = null;
			next = null;
		}
	}
	
	public DoublyLinkedList(){
		this.head = null;
		this.tail = null;
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
		
		if(this.head != null) {
			newNode.next = this.head;
			this.head.prev = newNode;
		}else {
			this.tail = newNode;
		}
		
		this.head = newNode;
	}
	
	private void addInTheEnd(int value) {
		Node newNode = new Node(value);
		
		Node node = this.head.next;
		Node prevNode = null;
		
		while(node != null) {
			prevNode = node;
			node = node.next;
		}
	
		if(prevNode != null) {
			prevNode.next = newNode;
			newNode.prev = prevNode;
		}else {
			this.head.next = newNode;
		}
		
		this.tail = newNode;
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
			newNode.prev = prevNode;
			
			if(node != null) {
				newNode.next = node;
				node.prev = newNode;
			}else {
				newNode.next = null;
				this.tail = newNode;
			}
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
			
			if(prevNode != null) {
				prevNode.next = node.next;
			}else{
				this.head = node.next;
			}
		}
		
		if(node.next != null) {
			node.next.prev = prevNode;
		}
		
		if(this.currentSize == index) {
			this.tail = node;
		}
		
		this.currentSize--;
		return value;
	}
	
	public void remove(int value) {
		Node node = this.head;

		while(node != null) {
			if(node.value == value) {
				this.currentSize--;
				break;
			}
			
			node = node.next;
		}
	
		if(node != null) {
			Node tempNode = node;
			node = node.next;
			
			if(node != null) {
				if(tempNode.prev != null) {
					node.prev = tempNode.prev;
					tempNode.prev.next = node;
				}else {
					this.head = node;
				}
			}else {
				if(tempNode.prev != null) {
					tempNode.prev.next = null;
					this.tail = tempNode.prev;
				}else {
					this.deleteList();
				}
			}
		}
	}
	
	public void deleteList() {
		this.head = null;
		this.tail = null;
	}
	
	public void printReverseList() {
		Node node = this.tail;
		String str = "";
		
		while(node != null) {
			str += node.value + " ";
			node = node.prev;
		}
		
		Console.printLine(str);
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
