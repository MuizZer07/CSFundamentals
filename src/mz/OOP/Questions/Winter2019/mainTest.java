package mz.OOP.Questions.Winter2019;

import java.util.Scanner;

public class mainTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Input: ");
//		String inputString = scanner.nextLine();
		String inputString = "4(2(3)(1))(6(5))";
//		String inputString = "4(2)(3)";
		
		System.out.println(inputString);
		bTree btree = new bTree();
		btree.insertData(inputString);
		btree.printRootToleaf();
		
	}

}
