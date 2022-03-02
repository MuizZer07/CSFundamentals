package mz.OOP.Questions.Winter2021;

public class uGraph {

	private int[][] adjMatrix;
	private static final int DEFAULT_SIZE = 10;
	private int currentVertices = 0;
	
	public uGraph() {
		this(DEFAULT_SIZE);
	}
	
	public uGraph(int numOfVertices) {
		this.currentVertices = numOfVertices;
		this.adjMatrix = new int[this.currentVertices][this.currentVertices];
	}
	
	public void addEdge(int i, int j) {
		if(!this.checkEdge(i, j)) {
			this.adjMatrix[i][j] = 1;
		}
	}
	
	public void removeEdge(int i, int j) {
		if(this.checkEdge(i, j)) {
			this.adjMatrix[i][j] = 0;
		}
	}
	
	public boolean checkEdge(int i, int j) {
		return this.adjMatrix[i][j] == 1;
	}
	
	public boolean allEven() {
		for(int i=0; i<this.currentVertices; i++) {
			int degree = this.countDegree(i);
			
			if(degree % 2 != 0)
				return false;
		}
		return true;
	}
	
	private int countDegree(int vertex) {
		int degree = 0;
		
		for(int i=0; i<this.currentVertices; i++) {
			if(this.adjMatrix[vertex][i] == 1)
				degree++;
		}
		
		return degree;
	}
	
	public void printGraph() {
		for(int i=0; i<this.currentVertices; i++) {
			for(int j=0; j<this.currentVertices; j++) {
				System.out.print(this.adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
