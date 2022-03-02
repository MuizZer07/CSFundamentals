package mz.DataStructure.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjacencyList {

	Node head;
	ArrayList<ArrayList<Integer>> adjacencyList;
	int numOfVertices;
	
	public class Node{
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	public GraphAdjacencyList(int numOfVertices) {
		this.head = null;
		this.adjacencyList = new ArrayList<ArrayList<Integer>>(numOfVertices);
		this.numOfVertices = numOfVertices;
		
		for(int i=0; i<this.numOfVertices; i++) {
			this.adjacencyList.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int node1, int node2) {
		this.adjacencyList.get(node1).add(node2);
		this.adjacencyList.get(node2).add(node1);
	}
	
	public void printAdjacencyList() {
		for(int i=0; i< this.adjacencyList.size(); i++) {
			System.out.println(i + " - " + this.adjacencyList.get(i));
		}
	}
	
	public void BFS(int source) {
		int[] visitedArr = new int[this.numOfVertices];
		Queue<Integer> queue = new LinkedList<Integer>();
		this.printBFS(source, queue, visitedArr);
	}
	
	public void printBFS(int source, Queue<Integer> queue, int[] visitedArr) {
		System.out.print(source + " ");
		visitedArr[source] = 1;
		
		for(int i=0; i<this.adjacencyList.get(source).size(); i++) {
			int adjacent = this.adjacencyList.get(source).get(i);
			queue.add(adjacent);
		}
		
		while(!queue.isEmpty()) {
			int nextNode = queue.remove();
			
			if(visitedArr[nextNode] != 1) {
				this.printBFS(nextNode, queue, visitedArr);
			}
		}	
	}
	
	public void DFS(int source) {
		int[] visitedArr = new int[this.numOfVertices];
		this.printDFS(source, visitedArr);
	}
	
	public void printDFS(int source, int[] visitedArr) {
		visitedArr[source] = 1;
		System.out.print(source + " ");
		for(int i=0; i<this.adjacencyList.get(source).size(); i++) {
			int newSource = this.adjacencyList.get(source).get(i);
			
			if(visitedArr[newSource] != 1)
				this.printDFS(newSource, visitedArr);
		}
		
	}
}
