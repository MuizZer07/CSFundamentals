package mz.OOP.Questions.Winter2020;

public class FloatCell implements Cell{

	float value;
	
	public FloatCell() {}

	@Override
	public void setValue(String value) {
		try {
			this.value = Float.parseFloat(value);
		}catch(Exception e) {
			String str = "cant't convert " + value + " to float";
			System.out.println(str);
		}
		
	}

	@Override
	public float getFloatValue() {
		return value;
	};
}
