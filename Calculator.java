package calculator;
import static org.hamcrest.Matchers.*;
import  ch.lambdaj.function.convert.Converter;
import static ch.lambdaj.Lambda.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			List<Integer> negatives = filter(lessThan(0), numbers);
			
			if(negatives.size()>0) {
				throw new RuntimeException("Negatives not allowed: " + join(negatives));
			}
			return sum(numbers).intValue();
		}
		
	}
	
	
	
	
	private static String []  tokenize(String text) {
		if(usesCustomDelimiterSyntax(text)) {
			return splitUsingCustomDelimiterSyntax( text);
		}
		else
		{
			return splitUsingNewlinesAndCommas( text);
		}
	}
	
	private static boolean usesCustomDelimiterSyntax(String text) {
		return text.startsWith("//");
	}
	
	private static String[] splitUsingNewlinesAndCommas(String text) {
		String [] tokens =text.split(",|\n");
		return tokens;
	}
	private static String [] splitUsingCustomDelimiterSyntax(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		m.matches();
		String customDelimiter=m.group(1);
		String numbers=m.group(2);
		
		return numbers.split(Pattern.quote(customDelimiter));
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
