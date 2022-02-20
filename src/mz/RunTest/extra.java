package mz.RunTest;

import mz.OOP.Questions.Winter2020.SpreadSheet;
import mz.OOP.Questions.Winter2020.SpreadSheet.val_type;

public class extra {

	public static void main(String[] args) {
		SpreadSheet sp = new SpreadSheet(5, 5);
		sp.setCellValue(1, "A", "9", val_type.INT);
		sp.setCellValue(1, "B", "1", val_type.INT);
		sp.setCellValue(1, "C", "3", val_type.INT);
		sp.setCellValue(1, "D", "4", val_type.INT);
		sp.setCellValue(1, "E", "5", val_type.INT);
		sp.setCellValue(2, "C", "1", val_type.STR);
		sp.setCellValue(4, "C", "3", val_type.INT);
		sp.setCellValue(4, "D", "4", val_type.INT);
		sp.setCellValue(3, "E", "5", val_type.INT);
		sp.setCellValue(5, "A", "5", val_type.INT);
		
		sp.printShreadSheet();
		System.out.println();
		
		float[] valueRange = sp.getRange(1, "B", 3, "D");
		for(int i=0; i<valueRange.length; i++) {
			System.out.print(valueRange[i] + " ");
		}
		
	}

}
