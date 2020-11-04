package java_board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//public class test_class {
//	public static void main(String[] args)
//	{
//		LocalDate now = LocalDate.now();
//		System.out.println(now);
//		
//		LocalDateTime now2 = LocalDateTime.now();
//		System.out.println(now2);
//		
//		String name = "what do you know about me?";
//		
//		System.out.println(name.contains("do you know"));
//		System.out.println("about");
//		System.out.println("hello");
//		
//		System.out.println(name);
//		
//		int a = Integer.parseInt("123"); // *문자로된 숫자를 완벽한 숫자로 바꿈*
//		
//		System.out.println(a+10);
//		
//	}
//}

public class test_class {
    public static void main(String[] args) {

		int[] intArr = {3,1,4,5,2};
    	
    	ArrayList<Integer> intList = new ArrayList<>();
    	
    	intList.add(3);
    	intList.add(1);
    	intList.add(4);
    	intList.add(5);
    	intList.add(2);
    	
    	Arrays.sort(intArr);
    	Collections.sort(intList);
    	
    	for(int i = 0; i < intArr.length; i++)
    	{
    		System.out.println(intArr[i]);
    	}
    	
    	for(int i = 0; i < intList.size(); i++)
    	{
    		System.out.println(intList.get(i));
    	}
    
    }
}

