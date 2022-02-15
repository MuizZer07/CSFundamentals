package mz.Utils;

public class Console {

	
	private Console() {}

	public static void printLine(String str) {
		System.out.println(str);
	}
	
	public static void printEmptyLines(int numLines) {
		printSameLines(numLines, "");
	}

	public static void printSameLines(int numLines, String str) {
		for(int i=0; i<numLines; i++){
			printLine(str);
		}
	}
	
	public static void printArray(int[] arr, String sep) {
		String str = "";
		for(int i=0; i<arr.length; i++) {
			str += arr[i] + sep;
		}
		
		printLine(str);
	}
}
