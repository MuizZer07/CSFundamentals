package mz.RunTest;
import mz.DataStructures.Lists.SimpleListArray;
import mz.Utils.Console;

public class SimpleListArrayTest {

	public static void main(String[] args) {
		SimpleListArray myList = new SimpleListArray(2);
		
		Console.printLine("List Initiated.");
		Console.printLine(myList.toString());
		Console.printSameLines(1, "******************");
		Console.printEmptyLines(2);
		
		Console.printLine("Q: Is list empty? : " + myList.isEmpty());
		
		Console.printLine("Print List: ");
		Console.printArray(myList.getItemArray(), " ");
		Console.printSameLines(1, "******************");
		Console.printEmptyLines(2);
		
		boolean res = myList.add(100);
		Console.printLine("add 100: " + res);
		
		res =  myList.add(101);
		Console.printLine("add 101: " + res);
		
		Console.printLine("Print List: ");
		Console.printArray(myList.getItemArray(), " ");
		
		Console.printSameLines(1, "******************");
		Console.printEmptyLines(2);
		Console.printLine("Q: Is list full? : " +  myList.isFull());
		res = myList.remove(100);
		Console.printLine("remove 100: " + res);
	
		res = myList.removeByIndex(0);
		Console.printLine("remove by index: " + res);
		
		Console.printLine("Print toString():");
		Console.printLine(myList.toString());
		Console.printSameLines(1, "******************");
		Console.printEmptyLines(2);
	}

}
