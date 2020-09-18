package calculator;

import  ch.lambdaj.function.convert.Converter;
import static ch.lambdaj.Lambda.*;
import java.util.List;

public class Calculator {

	
	public static int add(String text)
	{
		if(text.isEmpty())
		{
			return 0;
		}
		else {
			String [] tokens=tokenize(text);
			List<Integer> numbers = convert(tokens,toInt());
			
			return sum(numbers).intValue();
		}
		
	}
	
	private static String []  tokenize(String text) {
		String [] tokens =text.split(",");
		return tokens;
	}
	
	private static Converter<String, Integer> toInt(){
		return new Converter<String, Integer>(){
			
			public Integer convert (String from) {
				return toInt(from);
			}
		};
	}
	private static int toInt(String text) throws NumberFormatException{
		return Integer.parseInt(text);
	}
}
