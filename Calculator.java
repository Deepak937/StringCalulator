package calculator;

public class Calculator {

	
	public static int add(String text)
	{
		if(text.isEmpty())
		{
			return 0;
		}
		else if(text.contains(",")) {
			String [] tokens=text.split(",");
			return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
		}
		else {
			return Integer.parseInt(text);
		}
	}
}
