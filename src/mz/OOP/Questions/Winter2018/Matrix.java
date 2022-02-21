package mz.OOP.Questions.Winter2018;

public class Matrix {

	int[][] matrix;
	int rows;
	int cols;
	
	public Matrix(int rows, int cols) throws Exception {
		if(rows > 1 && cols > 1) {
			this.rows = rows;
			this.cols = cols;
			this.matrix = new int[this.rows][this.cols];
		}else {
			throw new Exception("Invalid argument");
		}
	}
	
	public int getNumberOfRows() {
		return this.rows;
	}
	
	public int getNumberOfColumns(){
		return this.cols;
	}
	
	public int getValueAt(int r, int c) {
		return this.matrix[r][c];
	}
	
	public void setValueAt(int value, int r, int c) {
		this.matrix[r][c] = value;
	}
	
	public boolean loadFromArray(int[] arr) {
		int newIndex = 0;
		
		try {
			for(int i=0; i<this.rows; i++) {
				for(int j=0; j<this.cols; j++) {
					this.matrix[i][j] = arr[newIndex++];
				}
			}
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean checkDimensions(Matrix A, Matrix B) {
		return (A.getNumberOfRows() == B.getNumberOfRows() && A.getNumberOfColumns() == B.getNumberOfColumns());
	}
	
	public Matrix addition(Matrix B) {
		Matrix newMatrix = this;
		if(this.checkDimensions(this, B)) {
			for(int i=0; i<this.rows; i++) {
				for(int j=0; j<this.cols; j++) {
					int existingValue = newMatrix.getValueAt(i, j);
					existingValue += B.getValueAt(i, j);
					newMatrix.setValueAt(existingValue, i, j);
				}
			}
		}
		
		return newMatrix;
	}
	
	public Matrix subtraction(Matrix B) {
		Matrix newMatrix = this;
		if(this.checkDimensions(this, B)) {
			for(int i=0; i<this.rows; i++) {
				for(int j=0; j<this.cols; j++) {
					int existingValue = newMatrix.getValueAt(i, j);
					existingValue -= B.getValueAt(i, j);
					newMatrix.setValueAt(existingValue, i, j);
				}
			}
		}
		
		return newMatrix;
	}
	
	public Matrix getTranspose(Matrix B) {
		Matrix newMatrix = null;
		int newRows = B.getNumberOfColumns();
		int newCols = B.getNumberOfRows();
		
		try {
			newMatrix = new Matrix(newRows, newCols);
		}catch(Exception e) {
			
		}
		
		for(int j=0; j<newRows; j++) {
			for(int i=0; i < newCols; i++) {
				newMatrix.setValueAt(this.matrix[i][j], j, i);
			}
		}
		
		return newMatrix;
	}
	
	public Matrix getTranspose() {
		return this.getTranspose(this);
	}
	
	public Matrix multiplyBy(int scalar) {
		Matrix newMatrix = this;
		for(int i=0; i<this.rows; i++) {
			for(int j=0; j<this.cols; j++) {
				int existingValue = newMatrix.getValueAt(i, j);
				existingValue *= scalar;
				newMatrix.setValueAt(existingValue, i, j);
			}
		}
		
		return newMatrix;
	}
	
	public Matrix multiplyBy(Matrix B) {
		Matrix newMatrix = null;
		
		try {
			newMatrix = new Matrix(this.cols, this.rows);
		}catch(Exception e) {
			
		}
		
		if(this.rows == B.cols && this.cols == B.rows) {
			Matrix BT = this.getTranspose(B);
			return this.addition(BT);
		}
		
		return newMatrix;
	}
	
	public void printMatrix() {
		for(int i=0; i<this.rows; i++) {
			for(int j=0; j<this.cols; j++) {
				System.out.print(this.matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
