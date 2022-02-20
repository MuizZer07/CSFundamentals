package mz.DataStructures.Lists;

public class StackArray {

	int[] stackArr;
	int size;
	int currentSize;
	
	public StackArray(int size) {
		this.size = size;
		this.currentSize = 0;
		this.stackArr = new int[size];
	}
	
	public void push(int value) {
		this.stackArr[currentSize++] = value;
	}
	
	public int pop() {
		int value = -1;
		
		if(!this.isEmpty()) {
			value = this.stackArr[--currentSize];
			this.stackArr[currentSize] = 0;	
		}
		
		return value;
	}
	
	public boolean isFull() {
		return size == currentSize-1;
	}
	
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	public int[] getStackArray() {
		int[] newArr = new int[this.currentSize];
		int newIndex = 0;
		
		for(int i = this.currentSize-1; i>=0; i--) {
			newArr[newIndex++] = this.stackArr[i];
		}
		return newArr;
	}
}
