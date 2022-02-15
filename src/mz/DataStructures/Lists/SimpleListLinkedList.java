package mz.DataStructures.Lists;

public class SimpleListLinkedList {
	
	private Node head;
	private SimpleListLinkedList thisList;
	private int currentSize;
	
	static class Node{
		private int value;
		private Node next;
		
		public Node(int val){
			value = val;
			next = null;
		}
	}
	
	public SimpleListLinkedList() {
		this.head = null;
		this.currentSize = 0;
	}
	
	public static void add(int value) {
		
	}

}
