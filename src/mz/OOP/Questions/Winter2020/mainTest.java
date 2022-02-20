package mz.OOP.Questions.Winter2020;
import mz.OOP.Questions.Winter2020.SpreadSheet.*;

public class mainTest {

	public static void main(String[] args) {
		SpreadSheet ss = new SpreadSheet(10, 10);
		
		ss.setCellValue(11, "A", "5", val_type.INT);
		ss.setCellValue(1, "A", "1", val_type.INT);
		ss.setCellValue(2, "A", "3", val_type.INT);
		
		ss.setCellValue(1, "B", "4.0", val_type.FLOAT);
		ss.setCellValue(2, "B", "a", val_type.INT);
		ss.setCellValue(2, "B", "6", val_type.INT);
		
		System.out.println();
		ss.printShreadSheet();
		
		System.out.println();
		ss.insertColumn("B");
		
		ss.printShreadSheet();
		System.out.println();
		
		float[] valueRange = ss.getRange(1, "A", 2, "C");
		for(int i=0; i<valueRange.length; i++) {
			System.out.print(valueRange[i] + " ");
		}
	}

}
