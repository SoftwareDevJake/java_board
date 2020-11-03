package java_board;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class test_class {
	public static void main(String[] args)
	{
		LocalDate now = LocalDate.now();
		System.out.println(now);
		
		LocalDateTime now2 = LocalDateTime.now();
		System.out.println(now2);
		
		String name = "what do you know about me?";
		
		System.out.println(name.contains("do you know"));
		System.out.println("about");
		System.out.println("hello");
		
		System.out.println(name);
		
		int a = Integer.parseInt("123"); // *문자로된 숫자를 완벽한 숫자로 바꿈*
		
		System.out.println(a+10);
		
	}
}
