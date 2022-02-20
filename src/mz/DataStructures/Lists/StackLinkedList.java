package mz.DataStructures.Lists;

public class StackLinkedList {

	DoublyLinkedList myList;
	
	public StackLinkedList() {
		myList = new DoublyLinkedList();
	}
	
	public void push(int value) {
		myList.add(value, 0);
	}
	
	public int pop() {
		return myList.removeAtIndex(0);
	}
	
	public void printStack() {
		myList.printList();
	}
}
