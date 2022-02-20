package mz.OOP.Questions.Winter2020;

public class strCell implements Cell{

	String value;
	
	public strCell() {}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public float getFloatValue() {
		try {
			return Float.valueOf(this.value);
		}catch(Exception e) {
			System.out.println(e.toString());
			return Float.MIN_VALUE;
		}
	};
	

}
