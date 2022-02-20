package mz.RunTest;

import mz.DataStructures.Lists.QueueArray;
import mz.DataStructures.Lists.QueueLinkedList;
import mz.Utils.Console;

public class QueueTest {

	public static void main(String[] args) {
//		QueueArray q = new QueueArray(5);
		QueueLinkedList q = new QueueLinkedList();

		q.enqueue(10);
		q.enqueue(1);
		q.enqueue(4);
		
//		Console.printArray(q.getQueueArray(), " ");
		q.printQueue();
		
		q.enqueue(4);
		q.enqueue(30);
		q.dequeue();
		
//		Console.printArray(q.getQueueArray(), " ");
		q.printQueue();
//		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
//		Console.printArray(q.getQueueArray(), " ");
		q.printQueue();
	
		q.dequeue();
	}

}
