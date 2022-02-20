package mz.DataStructures.Trees;

import mz.Utils.Console;

public class BinarySearchTree {
	Node root;

	public static class Node{
		int value;
		Node leftChild;
		Node rightChild;
		
		public Node(int val) {
			value = val;
			leftChild = null;
			rightChild = null;
		}
	}
	
	public void makeEmpty() {
		this.root = null;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public int getValue(Node node) {
		return node.value;
	}
	
	private boolean nodeContains(int value, Node node) {
		
		if(node == null)
			return false;
		
		if(value > node.value) {
			return this.nodeContains(value, node.rightChild);
		}else if(value < node.value) {
			return this.nodeContains(value, node.leftChild);
		}
		else {
			return true;
		}
	}

	public boolean contains(int val) {
		return this.nodeContains(val, this.root);
	}
	
	private Node findMinimum(Node node) {
		if(node == null){
			return node;
		}
		
		if(node.leftChild != null) {
			return this.findMinimum(node.leftChild);
		}else {
			return node;
		}
	}
	
	public Node findMin() {
		return this.findMinimum(this.root);
	}
	
	private Node findMaximum(Node node) {
		if(node == null){
			return node;
		}
		
		if(node.rightChild != null) {
			return this.findMaximum(node.rightChild);
		}else {
			return node;
		}
	}
	
	public Node findMax() {
		return this.findMaximum(this.root);
	}
	
	public Node insertNode(int val, Node node) {
		Node newNode = new Node(val);
		
		if(this.root == null) {
			this.root = newNode;
			return newNode;
		}
		
		if(node == null) {
			return newNode;
		}else {
			if(val > node.value) {
				node.rightChild = this.insertNode(val, node.rightChild);
			}else {
				node.leftChild = this.insertNode(val, node.leftChild);
			}
		}
		
		return node;
	}
	
	public void insert(int val) {
		this.insertNode(val, this.root);
	}
	
	private Node removeNode(int val, Node node) {
		
		if(node == null) {
			return node;
		}else {
			if(val > node.value) {
				node.rightChild = this.removeNode(val, node.rightChild);
			}else if(val < node.value){
				node.leftChild = this.removeNode(val, node.leftChild);
			}else if(val == node.value) {
				if(node.leftChild == null && node.rightChild == null) {
					node = null;
				}else if(node.leftChild == null && node.rightChild != null) {
					if(this.root == node)
						this.root = node.rightChild;
					
					node = node.rightChild;
				}else if(node.leftChild != null && node.rightChild == null) {
					if(this.root == node)
						this.root = node.leftChild;
					
					node = node.leftChild;
				}else if(node.leftChild != null && node.rightChild != null) {
					Node minFromRightSubtree = this.findMinimum(node.rightChild);
					node.value = minFromRightSubtree.value;
					node.rightChild = this.removeNode(minFromRightSubtree.value, node.rightChild);
				}
			}
		}
		
		return node;
	}
	
	public void remove(int val) {
		boolean ifContains = this.contains(val);

		if(ifContains) {
			this.removeNode(val, this.root);
		}
	}
	
	public void printTree(String order) {
		switch(order) {
		case "pre":
			this.preOrderTraversal();
			break;
		case "in":
			this.inOrderTraversal();
			break;
		case "post":
			this.postOrderTraversal();
			break;
		}
	}
	
	private void preOrderTraverseNode(Node node) {
		if(node == null) {
			return;
		}else {
			Console.print(node.value + " ");
			if(node.leftChild != null) {
				this.preOrderTraverseNode(node.leftChild);
			}
			
			if(node.rightChild != null){
				this.preOrderTraverseNode(node.rightChild);
			}
		}
	}
	
	public void preOrderTraversal() {
		this.preOrderTraverseNode(this.root);
	}
	
	private void inOrderTraverseNode(Node node) {
		if(node == null) {
			return;
		}else {
			if(node.leftChild != null) {
				this.inOrderTraverseNode(node.leftChild);
			}
			
			Console.print(node.value + " ");
			
			if(node.rightChild != null){
				this.inOrderTraverseNode(node.rightChild);
			}
		}
	}
	
	public void inOrderTraversal() {
		this.inOrderTraverseNode(this.root);
	}
	
	private void postOrderTraverseNode(Node node) {
		if(node == null) {
			return;
		}else {
			if(node.leftChild != null) {
				this.postOrderTraverseNode(node.leftChild);
			}
			
			if(node.rightChild != null){
				this.postOrderTraverseNode(node.rightChild);
			}
			
			Console.print(node.value + " ");
		}
	}
	
	public void postOrderTraversal() {
		this.postOrderTraverseNode(this.root);
	}
}
