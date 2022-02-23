package mz.RunTest;

import mz.DataStructures.HashTable.ChainingHashTable;
public class chainingHashTableTest {

	public static void main(String[] args) {
		ChainingHashTable hashTable = new ChainingHashTable();
		
		hashTable.insert(1);
		hashTable.insert(3);
		hashTable.insert(2);
		hashTable.insert(1);
		hashTable.insert(4);
		hashTable.remove(5);
		hashTable.insert(11);
		hashTable.insert(44);
		
		System.out.println("Printing as Chaining Hash Table:");
		hashTable.printHashTable();
	}

}
