package mz.OOP.Questions.Winter2003;

public class IntSet {

	int size;
	int currentSize;
	int[] intSetArr;
	
	public IntSet() {
		this.size = 10;
		this.intSetArr = new int[this.size];
		this.currentSize = 0;
	}
	
	public boolean isEmpty() {
		return this.currentSize == 0;
	}
	
	public boolean isFull() {
		return this.currentSize == this.size;
	}
	
	public int getCurrentSize() {
		return this.currentSize;
	}
	
	public int[] getSetArr() {
		return this.intSetArr;
	}
	
	private void ensureCapacity() {
		if(this.isFull()) {
			this.size *= 2;
			int[] newArr = new int[this.size];
			
			for(int i=0; i < this.currentSize; i++) {
				newArr[i] = this.intSetArr[i];
			}
			
			this.intSetArr = newArr;
		}
	}
	
	public int isMember(int val) {
		int isMember = 0;
		
		for(int i=0; i <= this.currentSize; i++) {
			if(this.intSetArr[i] == val)
				return 1;
		}
		
		return isMember;
	}
	
	public int insert(int val) {
		if(this.isFull())
			this.ensureCapacity();
		
		if(this.isMember(val) == 1)
			return 0;
		
		this.intSetArr[currentSize++] = val;
		return 1;
	}
	
	public int deletion(int val) {
		if(this.isEmpty())
			return 0;
		
		if(this.isMember(val) == 0)
			return 0;
		
		currentSize--;
		return 1;
	}
	
	public void print() {
		for(int i=0; i < this.currentSize; i++) {
			 System.out.print(this.intSetArr[i] + " ");
		}
		System.out.println();
	}
	
	public IntSet union(IntSet s) {
		IntSet unionSet = new IntSet();
		int[] newArr = s.getSetArr();
	
		for(int i=0; i < this.currentSize; i++) {
			unionSet.insert(this.intSetArr[i]);
		}
		
		for(int i=0; i < s.getCurrentSize(); i++) {
			unionSet.insert(newArr[i]);
		}
		
		return unionSet;
	}
	
	public IntSet intersection(IntSet s) {
		IntSet intersectionSet = new IntSet();
		int[] newArr = s.getSetArr();
		
		for(int i=0; i < this.currentSize; i++) {
			if(s.isMember(this.intSetArr[i]) == 1)
				intersectionSet.insert(this.intSetArr[i]);
		}
		
		for(int i=0; i < s.getCurrentSize(); i++) {
			if(this.isMember(s.intSetArr[i]) == 1)
				intersectionSet.insert(newArr[i]);
		}
		
		return intersectionSet;
	}
}
