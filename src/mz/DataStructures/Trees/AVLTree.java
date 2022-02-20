package mz.DataStructures.Trees;

public class AVLTree {
	
	private Node root;
	private static final int ALLOWED_BALANCE = 1;
	
	public static class Node{
		int value;
		int height;
		Node leftChild;
		Node rightChild;
		
		public Node(int val) {
			value = val;
			height = 0;
			leftChild = null;
			rightChild = null;
		}
	}
	
	public AVLTree() {
		this.root = null;
	}
	
	private Node insertNode(int val, Node node) {
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
		
		return balance(node);
	}
	
	private Node balance(Node node) {
		if(node == null)
			return node;
		
		if(this.getHeight(node.leftChild) - this.getHeight(node.rightChild) > ALLOWED_BALANCE) {
			if(this.getHeight(node.leftChild.leftChild) >= this.getHeight(node.leftChild.rightChild)) {
				this.rotateWithLeftChild(node);
			}else {
				this.doubleRotateWithLeftChild(node);
			}
		}else if(this.getHeight(node.rightChild) - this.getHeight(node.leftChild) > ALLOWED_BALANCE) {
			if(this.getHeight(node.rightChild.rightChild) >= this.getHeight(node.rightChild.leftChild)) {
				this.rotateWithRightChild(node);
			}else {
				this.doubleRotateWithRightChild(node);
			}
		}
		
		node.height = Math.max(this.getHeight(node.leftChild), this.getHeight(node.rightChild)) + 1;
		
		return node;
	}
	
	private Node rotateWithLeftChild(Node node) {
		Node newNode = node.leftChild;
		node.leftChild = newNode.rightChild;
		newNode.leftChild = node.rightChild;
		node.height = Math.max(this.getHeight(node.leftChild), this.getHeight(node.rightChild)) + 1;
		newNode.height = Math.max(this.getHeight(newNode.leftChild), this.getHeight(node)) + 1;
		return newNode;
	}
	
	private Node doubleRotateWithLeftChild(Node node) {
		node.leftChild = this.rotateWithRightChild(node);
		return this.rotateWithLeftChild(node);
	}
	
	private Node rotateWithRightChild(Node node) {
		Node newNode = node.rightChild;
		node.rightChild = newNode.leftChild;
		newNode.rightChild = node.leftChild;
		node.height = Math.max(this.getHeight(node.leftChild), this.getHeight(node.rightChild)) + 1;
		newNode.height = Math.max(this.getHeight(newNode.rightChild), this.getHeight(node)) + 1;
		return newNode;
	}
	
	private Node doubleRotateWithRightChild(Node node) {
		node.rightChild = this.rotateWithLeftChild(node);
		return this.rotateWithRightChild(node);
	}
	
	public int getHeight(Node node) {
		if(node == null) {
			return -1;
		}else {
			return node.height;
		}
	}
	
	public void insert(int val) {
		this.insertNode(val, this.root);
	}
	
	public void remove(int val) {
		this.removeNode(val, this.root);
	}
	
	private Node removeNode(int val, Node node) {
		if(node == null)
			return node;
		
		if(val > node.value) {
			node.rightChild = this.removeNode(val, node.rightChild);
		}else if(val < node.value) {
			node.leftChild = this.removeNode(val, node.leftChild);
		}else if(node.leftChild != null && node.rightChild != null) {
			node.value = this.findMinimum(node.rightChild).value;
			node.rightChild = this.removeNode(node.value, node.rightChild);
		}else {
			if(node.leftChild != null) {
				node = node.leftChild;
			}else {
				node = node.rightChild;
			}
		}
		
		return balance(node);
	}
	
	public Node findMin() {
		return this.findMinimum(this.root);
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
}
