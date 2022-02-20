package mz.RunTest;
import mz.DataStructures.Lists.SimpleListLinkedList;
import mz.DataStructures.Lists.DoublyLinkedList;
import mz.Utils.Console;

public class LinkedListTest {

	public static void main(String[] args) {
		SimpleListLinkedList myList = new SimpleListLinkedList();
//		DoublyLinkedList myList = new DoublyLinkedList();
		 
//		Console.printLine("Is list empty? : " + myList.isEmpty());
//		myList.add(3, 0);
//		myList.printList();
		
//		myList.add(3, 0);
//		myList.printList();
		
//		myList.add(1, 0);
//		myList.printList();
		
//		Console.printLine("Is list empty? : " + myList.isEmpty());
		myList.add(9, -1);
		myList.printList();
		
		myList.add(4, -1);
		myList.printList();
		
		myList.add(7, 2);
//		myList.printList();
		
		myList.add(0, 4);
		myList.printList();
		
//		myList.remove(4);
//		myList.printList();		
//
//		myList.remove(1);
//		myList.printList();
//
//		myList.remove(9);
//		myList.printList();
//
//		myList.remove(3);
//		myList.printList();
		
//		myList.removeAtIndex(6);
//		myList.removeAtIndex(0);
//		myList.printList();
//		
//		myList.remove(30);
//		myList.printReverseList();
	}

}
