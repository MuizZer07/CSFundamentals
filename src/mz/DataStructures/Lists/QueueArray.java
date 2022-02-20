package mz.DataStructures.Lists;

public class QueueArray {
	int[] queueArr;
	int size;
	int currentSize;
	int frontIndex;
	
	public QueueArray(int size){
		this.size = size;
		this.queueArr = new int[size];
		this.currentSize = 0;
		this.frontIndex = 0;
	}
	
	public void enqueue(int value) {
		if(!this.isFull())
			this.queueArr[this.currentSize++] = value;
	}
	
	public int dequeue() {
		int value = -1;
		if(!this.isEmpty()) {
			value = this.queueArr[this.frontIndex];
			this.queueArr[this.frontIndex++] = 0;	
			
			if(frontIndex == currentSize) {
				frontIndex = 0;
			}
		}
		
		return value;
	}
	
	public boolean isFull() {
		return size == currentSize-1;
	}
	
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	public int[] getQueueArray() {
		int[] newArr = new int[this.currentSize-this.frontIndex];
		int newIndex = 0;
		
		for(int i=frontIndex; i< this.currentSize; i++) {
			newArr[newIndex++] = this.queueArr[i];
		}
		return newArr;
	}
}
