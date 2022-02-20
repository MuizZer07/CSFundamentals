package mz.DataStructures.Lists;

public class QueueLinkedList {
	
	DoublyLinkedList myList;
	
	public QueueLinkedList() {
		myList = new DoublyLinkedList();
	}
	
	public void enqueue(int value) {
		myList.add(value, -1);
	}
	
	public int dequeue() {
		return myList.removeAtIndex(0);
	}
	
	public void printQueue() {
		myList.printList();
	}
}
