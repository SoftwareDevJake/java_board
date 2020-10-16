package java_board;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		Add a = new Add();
		
		while(loop)
		{
			System.out.print("명령어 입력 : ");
			
			String s = sc.next(); // 입력
			
			
			if(s.equals("add"))
			{
				a.add();
			}
			
			else if(s.equals("list"))
			{
				System.out.println("제목 : " + a.title);
				System.out.println("내용 : " + a.body);
			}
			
			else if(s.equals("exit"))
			{
				Exit e = new Exit();
				loop = e.exit(s, loop); // 종료
			}
			
		}
		
		
		
		
	}

}

class Exit {
	boolean exit (String s, boolean loop)
	{
		if(s.equals("exit"))
		{
			System.out.println("종료");
			loop = false;
		}
		return loop;
	}
}

class Add {
	String title;
	String body;
	Scanner sc2 = new Scanner(System.in);
	
	void add ()
	{
		System.out.print("게시물 제목을 입력해주세요 : ");
		title = sc2.next();
		
		System.out.print("게시물 내용을 입력해주세요 : ");
		body = sc2.next();
		
		System.out.println("게시물이 등록 되었습니다.");
	}
}

class List {
	ArrayList list = new ArrayList();
	
	void show_list()
	{
		
	}
}