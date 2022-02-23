package mz.DataStructures.Heaps;

public abstract class BinaryHeap {
	protected int size;
	protected int currentSize;
	protected int[] heapArray;

	public BinaryHeap(int size) {
		this.size = size;
		this.heapArray = new int[this.size];
		this.currentSize = 0;
	}
	
	public abstract void insert(int x);

	public abstract void remove();
	
	public int[] getHeap() {
		int[] newArr = new int[this.currentSize];
		
		for(int i=0; i<this.currentSize; i++) {
			newArr[i] = this.heapArray[i];
		}
		
		return newArr;
	}
	
	public boolean isEmpty() {
		return this.currentSize == 0;
	}
	
	public boolean isFull() {
		return this.currentSize-1 == this.size;
	}
	
	protected boolean hasChild(int value) {
		int index = this.getIndex(value);
		return (index*2) < this.currentSize;
	}
	
	protected boolean hasParent(int value) {
		int index = this.getIndex(value);
		
		if(index == 1)
			return false;
		
		return (index/2)+1 > 0;
	}
	
	protected int getLeftChild(int value) {
		int index = this.getIndex(value);
		
		if(this.hasChild(index))
			return this.heapArray[2*index];
		
		return 0;
	}
	
	protected int getRightChild(int value) {
		int index = this.getIndex(value);
		
		if(this.hasChild(index))
			return this.heapArray[(2*index) +1];
		
		return 0;
	}
	
	protected int getParent(int value) {
		int index = this.getIndex(value);
		if(this.hasParent(index))
			return this.heapArray[index/2];
		
		return 0;
	}
	
	protected int getIndex(int val) {
		int index = 0;
		for(int i=0; i <= this.currentSize; i++) {
			if(this.heapArray[i] == val)
				return i;
		}
		return index;
	}
	
	protected void swap(int val1, int val2) {
		int index1 = this.getIndex(val1);
		int index2 = this.getIndex(val2);
		
		int temp = this.heapArray[index1];
		this.heapArray[index1] = this.heapArray[index2];
		this.heapArray[index2] = temp;
	}
	
	protected void ensureCapacity() {
		if(this.isFull()) {
			this.size *= 2;
			int[] newArr = new int[this.size];
			
			for(int i=0; i < this.currentSize; i++) {
				newArr[i] = this.heapArray[i];
			}
			
			this.heapArray = newArr;
		}
	}
}
