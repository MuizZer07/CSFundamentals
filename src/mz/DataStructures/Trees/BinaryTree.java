package mz.DataStructures.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	Node root;

	public class Node{
		int value;
		Node leftChild;
		Node rightChild;
		
		public Node(int val) {
			this.value = val;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	
	public BinaryTree() {
		this.root = null;
	}
	
	public void insert(int value) {
		Queue<Node> syblingQueue = new LinkedList<Node>();
		this.insertNode(value, this.root, syblingQueue);
	}
	
	public void insertNode(int value, Node node, Queue<Node> syblingQueue) {
		Node newNode = new Node(value);
		
		if(this.root == null) {
			this.root = newNode;
			return;
		}
		
		if(node == null) {
			node = newNode;
		}else {
			
			if(node.leftChild != null) {
				
				if(node.rightChild != null) {
					syblingQueue.add(node.leftChild);
					syblingQueue.add(node.rightChild);
				}else {
					node.rightChild = newNode;
					return;
				}
			}else {
				node.leftChild = newNode;
				return;
			}
			
			if(!syblingQueue.isEmpty()) {
				Node nextNode = syblingQueue.poll();
				this.insertNode(value, nextNode, syblingQueue);
			}
		}
	}
	
	public void levelWiseTraversal() {
		Queue<Node> syblingQueue = new LinkedList<Node>();
		this.printLevelWise(this.root, syblingQueue);
	}
	
	private void printLevelWise(Node node, Queue<Node> syblingQueue) {
		if(node == null)
			return;
		
		System.out.print(node.value + " ");
		if(node.leftChild != null) {
			syblingQueue.add(node.leftChild);
		}
		
		if(node.rightChild != null) {
			syblingQueue.add(node.rightChild);
		}
		
		if(!syblingQueue.isEmpty()) {
			Node nextNode = syblingQueue.poll();
			this.printLevelWise(nextNode, syblingQueue);
		}
	}
	
	public void preOrderTraversal() {
		this.printPreOrder(this.root);
	}
	
	private void printPreOrder(Node node) {
		if(node == null)
			return;
		
		System.out.print(node.value + " ");
		printPreOrder(node.leftChild);
		printPreOrder(node.rightChild);
	}
}
