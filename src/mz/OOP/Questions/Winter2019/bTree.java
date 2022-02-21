package mz.OOP.Questions.Winter2019;

import mz.DataStructures.Lists.StackLinkedList;

public class bTree {
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
		
		public void setLeftChild(Node node) {
			leftChild = node;
		}
		
		public void setRightChild(Node node) {
			rightChild = node;
		}
	}
	
	public bTree() {
		this.root = null;
	}
	
	protected void finalize() {
		this.root = null;
	}
	
	private Node insert(int val, Node node, String child) {
		Node newNode = new Node(val);
		
		if(this.root == null) {
			this.root = newNode;
			return newNode;
		}
		
		if(node == null) {
			return newNode;
		}else {
			if(child == "left") {
				if(node.leftChild == null) {
					node.leftChild = newNode;
				}else {
					node.leftChild = this.insert(val, node.leftChild, "left");
				}
			}else if(child == "right") {
				if(node.rightChild == null) {
					node.rightChild = newNode;
				}else {
					node.rightChild = this.insert(val, node.rightChild, "right");
				}
			}
		}
		
		return node;
	}
	
	public void insertData(String str) {
		String number = "";
		Node node = this.root;
		StackLinkedList stack = new StackLinkedList();
		StackLinkedList rootStack = new StackLinkedList();
		int childCount = 0;
		
		for(int i=0; i < str.length(); i ++){
			char curChar = str.charAt(i);
			
			if(curChar == '(') {
				if(!number.equals("")) {
					int val = Integer.parseInt(number);
					node = this.insert(val, node, "left");
					
					if(rootStack.isEmpty() && !stack.isEmpty()) {
//						System.out.println(val + " "+ curChar + " left");
						rootStack.push(val);
					}
					else {
//						System.out.println(val + " "+ curChar + " right");
						rootStack.pop();
					}
							
					number = "";
					stack.push(curChar);
				}
			}else if(curChar == ')') {
				if(!number.equals("")) {
					if(stack.top() == (int) '(') {
						stack.pop();
						childCount++;
					}
					
					int val = Integer.parseInt(number);
					if(childCount == 1) {
						node = this.insert(val, node, "left");
						rootStack.push(val);
//						System.out.println(val + " " + curChar + " left");
					}else if(childCount == 2) {
						node = this.insert(val, node, "right");
						rootStack.pop();
//						System.out.println(val + " " + curChar + " right");
					}
					number = "";
				}
			}else {
				number += str.charAt(i);
			}
			;
			if(stack.isEmpty()) {
				childCount = 0;
			}
		}
	}
	
	public void printRootToleaf() {
		this.rootToLeafPath(this.root);
	}
	
	private void rootToLeafPath(Node node) {
		if(this.root == null)
			return;
		
		if(node == null) {
			return;
		}else {
			System.out.print(node.value + " ");
			
			if(node.leftChild != null) {
				this.rootToLeafPath(node.leftChild);
			}else if(node.rightChild != null) {
				this.rootToLeafPath(node.rightChild);
			}
		}
		
		System.out.println();
	}
}
