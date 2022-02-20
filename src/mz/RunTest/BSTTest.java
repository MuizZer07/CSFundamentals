package mz.RunTest;

import mz.DataStructures.Trees.BinarySearchTree;
import mz.Utils.Console;

public class BSTTest {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(1);
		bst.insert(7);
		bst.insert(5);
		bst.insert(4);
		bst.insert(5);
		bst.insert(2);
		bst.insert(3);
		bst.insert(6);
		bst.printTree("post");
		Console.printLine("");
		
		bst.printTree("in");
		Console.printLine("");
		
		bst.remove(1);
		bst.remove(4);
		bst.printTree("pre");
		Console.printLine("");
		
		Console.printLine(bst.getValue(bst.findMax()) + "");
	}

}
