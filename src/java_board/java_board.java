package java_board;

import java.util.Scanner;
import java.util.ArrayList;

public class java_board {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<String> titles = new ArrayList<>();
		ArrayList<String> bodies = new ArrayList<>();
		
		//int count_title = -1;
		//int count_body = -1;

		while (true) {
			System.out.print("명령어 입력 : ");
			String cmd = sc.next();
			if (cmd.equals("exit")) {
				System.out.println("종료");
				break;
			}
			if (cmd.equals("add")) {

				System.out.println("게시물 제목을 입력해주세요 :");
				titles.add(sc.next());
				//count_title++;
				
				System.out.println("게시물 내용을 입력해주세요 :");
				bodies.add(sc.next());
				//count_body++;
				System.out.println("게시물이 등록되었습니다.");

			}
			if (cmd.equals("list")) {
				for (int i = 0; i < titles.size(); i++) {
					System.out.println("제목 : " + titles.get(i));
					System.out.println("내용 : " + bodies.get(i));
					System.out.println("======================");
				}
			}
			if (cmd.equals("update"))
			{
				System.out.println("업데이트 할 게시물을 선택해 주세요.");
				String update;
				update = sc.next();
				
				for(int i = 0; i < titles.size(); i++)
				{
					if(titles.get(i).equals(update))
					{
						titles.remove(i);
						bodies.remove(i);
						
						System.out.println("업데이트 제목을 입력해 주세요");
						titles.add(sc.next());
						
						System.out.println("업데이트 내용을 입력해 주세요.");
						bodies.add(sc.next());
						
						System.out.println("업데이트가 완료 되었습니다.");
						break;
					}
					
				}
				
				System.out.println();
				
			}
		}

	}
}