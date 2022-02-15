package mz.DataStructures.Lists;

public class SimpleListArray {
	
	private int size;
	private int currentSize;
	private int[] itemArray;

	public SimpleListArray(int size){
		this.size = size;
		this.currentSize = 0;
		this.itemArray = new int[this.size];
	}
	
	public SimpleListArray(){
		this.size = 0;
		this.currentSize = 0;
		this.itemArray = new int[this.size];
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getcurrentSize() {
		return this.currentSize;
	}
	
	public int[] getItemArray() {
		return this.getItemsByIndex(0, this.currentSize-1);
	}
	
	public void emptyList() {
		this.currentSize = 0;
		this.itemArray = new int[this.size];
	}
	
	public boolean isEmpty() {
		return this.currentSize == 0;
	}
	
	public boolean isFull() {
		return this.currentSize == this.size;
	}
	
	public boolean add(int item) {
		if(!this.isFull()) {
			this.itemArray[currentSize++] = item;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean remove(int item) {
		if(!this.isEmpty()) {
			int itemIndex = this.getIndex(item);
					
			if(itemIndex > -1) {
				for(int i=itemIndex; i<currentSize-1; i++) {
					this.itemArray[i] = this.itemArray[i+1];
				}
				
				currentSize--;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean removeByIndex(int index) {
		if(!this.isEmpty()) {
			int itemIndex = this.getItemByIndex(index);
			
			if(itemIndex > -1) {
				for(int i=itemIndex; i<currentSize-1; i++) {
					this.itemArray[i] = this.itemArray[i+1];
				}
				
				currentSize--;
				return true;
			}
		}
		
		return false;
	}
	
	public int getItemByIndex(int index) {
		if(index-1 < this.currentSize) {
			return this.itemArray[index];
		}
		return -1;
	}
	
	public int[] getItemsByIndex(int startIndex, int endIndex) {
		int newSize = (endIndex - startIndex) + 1;
		int[] newArray = new int[newSize];
		int newIndex = 0;
		
		for(int i=startIndex; i<endIndex; i++) {
			newArray[newIndex] = this.itemArray[i];
		}
		
		return newArray;
	}
	
	public int getIndex(int value) {
		for(int i=0; i<this.currentSize; i++) {
			if(this.itemArray[i] == value) {
				return i;
			}
		}
		
		return -1;
	}
	
	public String toString() {
		return "List with Array Size: " + this.size + "\nCurrent Size: " + this.currentSize;
	}
}
