package mz.OOP.Questions.Winter2021;

public class mainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		uGraph ugraph = new uGraph(2);
		
		ugraph.addEdge(0, 1);

		ugraph.addEdge(0, 0);

//		ugraph.addEdge(1, 0);
		
		ugraph.addEdge(1, 1);
		
		ugraph.printGraph();
		
		System.out.println(ugraph.allEven() + " ");
		
	}
}
