package mz.OOP.Questions.Winter2020;

public class SpreadSheet {

	private int rows;
	private int columns;
	private Cell[][] spreadSheetMatrix;
	private static final char MIN_CHAR_VAL = 'A';
	public enum val_type {FLOAT, INT, STR};
	
	public SpreadSheet(int rows, int cols) {
		this.rows = rows;
		this.columns = cols;
		this.spreadSheetMatrix = new Cell[this.rows+1][this.columns];
	}
	
	private int convertStringColumnToInt(String column) {
		return (((column.length()-1) * 26) + (column.charAt(column.length()-1) - MIN_CHAR_VAL));
	}
	
	public boolean isEmpty(int row, String column) {
		int col = this.convertStringColumnToInt(column);
		return this.spreadSheetMatrix[row][col] == null;
	}
	
	public float getFloatValue(int row, String column) {
		int col = this.convertStringColumnToInt(column);
		return this.spreadSheetMatrix[row][col].getFloatValue();
	}
	
	public boolean setCellValue(int row, String column, String value, val_type ValueType) {
		int col = this.convertStringColumnToInt(column);
	
		try {
			switch(ValueType) {
				case INT:
					this.spreadSheetMatrix[row][col] = new IntCell();
					break;
				case FLOAT:
					this.spreadSheetMatrix[row][col] = new FloatCell();
					break;
				case STR:
					this.spreadSheetMatrix[row][col] = new strCell();
			}
			
			this.spreadSheetMatrix[row][col].setValue(value);
			return true;
		}catch(ArrayIndexOutOfBoundsException e) {
			String str = "(" + row + ", " + column + ") is out of bounds";
			System.out.println(str);
			return false;
		}catch(Exception e) {
			return false;
		}
	}
	
	public float[] getRange(int topLeftRow, String topLeftCol, int botRightRow, String botRightCol){
		int topLeftColIndex = this.convertStringColumnToInt(topLeftCol);
		int botRightColIndex = this.convertStringColumnToInt(botRightCol);
		int numOfRows = (botRightRow - topLeftRow) + 1;
		int numOfcolumns = (botRightColIndex - topLeftColIndex) + 1;
		
		float[] arr = new float[numOfRows * numOfcolumns];
		int newIndex = 0;
		
		for(int i=topLeftRow; i<=numOfRows; i++) {
			for(int j=topLeftColIndex; j<=numOfcolumns; j++) {
				if(this.spreadSheetMatrix[i][j] != null) {
					arr[newIndex++] = this.spreadSheetMatrix[i][j].getFloatValue();
				}
			}
		}
		
		float[] arr2 = new float[newIndex];
		for(int i=0; i<newIndex; i++) {
			arr2[i] = arr[i];
		}
		
		return arr2;
	}
	
	public void insertColumn(String column) {
		int col = this.convertStringColumnToInt(column);
		Cell[][] newMatrix = new Cell[this.rows+1][this.columns+1];
		int newColumnIndex = 0;
		
		for(int i=0; i<this.rows+1; i++) {
			newColumnIndex = 0;
			for(int j=0; j < this.columns; j++) {
				if(col!=j) {
					newMatrix[i][j] = this.spreadSheetMatrix[i][newColumnIndex++];
				}
			}
		}
		
		this.columns++;
		this.spreadSheetMatrix = newMatrix;
	}
	
	public void printShreadSheet() {
		for(int i = 0; i < this.spreadSheetMatrix.length; i++) {
			for(int j = 0; j < this.spreadSheetMatrix[i].length; j++) {
				if(this.spreadSheetMatrix[i][j] != null)
					System.out.print(this.spreadSheetMatrix[i][j].getFloatValue() + " ");
				else
					System.out.print(this.spreadSheetMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
