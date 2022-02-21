package mz.OOP.Questions.Winter2018;

public class mainTest {

	public static void main(String[] args) {
		try {
			int[] arr = {5, 0, -5, 2, 4, 2, -1,  3, 9};
			int[] arr2 = {1, 6, -2, -1, 8, -5, 3, 4, 10};
			int[] arr3 = {2, 0, 1, 5, -9, -3};
			
			Matrix X = new Matrix(3, 3);
			X.loadFromArray(arr);
			X.printMatrix();
			System.out.println();
			
			Matrix Y = new Matrix(3, 3);
			Y.loadFromArray(arr2);
			Y.printMatrix();
			System.out.println();
			
			Matrix Z = new Matrix(3, 2);
			Z.loadFromArray(arr3);
			Z.printMatrix();
			System.out.println();
			
			Matrix X2 = X.multiplyBy(2);
			X2.printMatrix();
			System.out.println();
			
			X2.addition(Y);
			X2.printMatrix();

		}catch(Exception e) {
			
		}
	}

}
