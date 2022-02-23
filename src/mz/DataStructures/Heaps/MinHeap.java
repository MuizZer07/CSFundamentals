package mz.DataStructures.Heaps;


public class MinHeap extends BinaryHeap{

	public MinHeap(int size) {
		super(size);
	}
	
	@Override
	public void insert(int x) {
		if(this.isFull())
			this.ensureCapacity();
		
		this.heapArray[++this.currentSize] = x;

		while(this.hasParent(x)) {
			int parent = this.getParent(x);

			if(x < parent) {
				this.swap(parent, x);
			}
			
			x = parent;
		}
	}
	
	
	@Override
	public void remove() {
		if(!this.isEmpty()) {
			this.heapArray[1] = this.heapArray[this.currentSize--];
			int x = this.heapArray[1];
			
			while(this.hasChild(x)) {
				int rightChild = this.getRightChild(x);
				int leftChild = this.getLeftChild(x);
				
				if(leftChild > x)
					this.heapArray[1] = leftChild;
				else if(rightChild > x)
					this.heapArray[1] = rightChild;
				else
					break;

				x = this.heapArray[1];
			}
		}
	}
	
}
