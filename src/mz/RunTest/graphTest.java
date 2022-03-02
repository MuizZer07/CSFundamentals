package mz.RunTest;

import mz.DataStructure.Graphs.GraphAdjacencyList;

public class graphTest {

	public static void main(String[] args) {
		GraphAdjacencyList graph = new GraphAdjacencyList(7);
		

		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 5);
		graph.addEdge(2, 3);
		graph.addEdge(4, 5);
		graph.addEdge(3, 6);
		graph.addEdge(5, 6);
		
		graph.printAdjacencyList();
		System.out.println();
		
		graph.BFS(0);
		
		System.out.println();
	}

}
