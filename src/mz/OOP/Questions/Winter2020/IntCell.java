package mz.OOP.Questions.Winter2020;

public class IntCell implements Cell{

	private int value;
	
	public IntCell() {};
	
	@Override
	public void setValue(String value) {
		try {
			this.value = Integer.parseInt(value);
		}catch(Exception e) {
			String str = "cant't convert " + value + " to integer";
			System.out.println(str);
		}
	}
	
	@Override
	public float getFloatValue() {
		try {
			return Float.valueOf(this.value);
		}catch(Exception e) {
			System.out.println(e.toString());
			return Float.MIN_VALUE;
		}
	}
}
