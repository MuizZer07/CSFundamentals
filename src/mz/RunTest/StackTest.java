package mz.RunTest;

import mz.DataStructures.Lists.StackArray;
import mz.DataStructures.Lists.StackLinkedList;
import mz.Utils.Console;

public class StackTest {

	public static void main(String[] args) {
//		StackArray s = new StackArray(5);
		StackLinkedList s = new StackLinkedList();
		
		s.push(1);
		s.push(2);
		s.push(32);
		s.push(4);
		s.push(2);

//		Console.printArray(s.getStackArray(), " ");
		s.printStack();

		Console.printLine(s.pop() + " Popped!");
		Console.printLine(s.pop() + " Popped!");
		
//		Console.printArray(s.getStackArray(), " ");
		s.printStack();
	}

}
