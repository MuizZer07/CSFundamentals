package mz.OOP.Questions.Winter2003;

public class mainTest {

	public static void main(String[] args) {
		IntSet intSet = new IntSet();
		IntSet intSet1 = new IntSet();
		
		intSet.insert(1);
		intSet.insert(10);
		intSet.insert(13);
		
		intSet1.insert(10);
		intSet1.insert(2);
		intSet.insert(11);
		intSet.insert(13);
		
		intSet.deletion(13);
		intSet.insert(1);
		
		intSet.print();
		intSet1.print();
		
		intSet.union(intSet1).print();
		intSet.intersection(intSet1).print();
	}

}
