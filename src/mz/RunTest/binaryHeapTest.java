package mz.RunTest;

import mz.DataStructures.Heaps.MinHeap;
import mz.Utils.Console;

public class binaryHeapTest {

	public static void main(String[] args) {
		
		MinHeap minHeap = new MinHeap(10);
		
		minHeap.insert(24);
		minHeap.insert(65);
		minHeap.insert(21);
		minHeap.insert(26);
		minHeap.insert(13);
		minHeap.insert(16);
		minHeap.insert(19);
		minHeap.insert(32);
		minHeap.insert(31);
		
		minHeap.remove();
		
		Console.printArray(minHeap.getHeap(), " ");
	}

}
