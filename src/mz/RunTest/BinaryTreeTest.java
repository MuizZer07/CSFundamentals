package mz.RunTest;

import mz.DataStructures.Trees.BinaryTree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		
		binaryTree.insert(1);
		binaryTree.insert(2);
		binaryTree.insert(4);
		binaryTree.insert(14);
		binaryTree.insert(43);
		binaryTree.insert(24);
		binaryTree.insert(42);
		binaryTree.insert(100);
		
		binaryTree.levelWiseTraversal();
		
	}

}
