package java_board;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Test {
	static ArrayList<Article> articles;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LocalDate date = LocalDate.now();

		articles = new ArrayList<>();

		Article a1 = new Article(1, "제목1", "내용1", "익명", 0, date);
		Article a2 = new Article(2, "제목2", "내용2", "익명", 0, date);
		Article a3 = new Article(3, "제목3", "내용3", "익명", 0, date);

		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		

		int no = 4;

		while (true) {

			System.out.print("명령어 입력 : ");
			String cmd = sc.next();
			if (cmd.equals("exit")) {
				System.out.println("종료");
				break;
			}

			if (cmd.equals("add")) {

				Article a = new Article();

				a.setId(no);

				no++;

				System.out.println("게시물 제목을 입력해주세요 :");
				String title = sc.next();
				

				a.setTitle(title);
				;
				System.out.println("게시물 내용을 입력해주세요 :");
				String body = sc.next();

				a.setBody(body);

				articles.add(a);
				System.out.println("게시물이 등록되었습니다.");

			}

			if (cmd.equals("list")) {
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					System.out.println("번호 : " + article.getId());
					System.out.println("제목 : " + article.getTitle());
					System.out.println("작성자 : " + article.getWriter());
					System.out.println("등록날짜 : " + article.getDate());
					System.out.println("조회수 : " + article.getView());
//					System.out.println("내용 : " + article.getBody());
					System.out.println("====================");
				}
			}

			if (cmd.equals("update")) {
				// index ver.
//				System.out.println("수정할 게시물 선택 : ");
//				int targetId = sc.nextInt();
//				int index = getArticleIndexById(targetId);
//				
//				if(targetId == -1)
//				{
//					System.out.println("없는 게시물입니다.");
//				}
//				
//
//				else {
//					System.out.println("게시물 제목을 입력해주세요 :");
//					String newTitle = sc.next();
//
//					System.out.println("게시물 내용을 입력해주세요 :");
//					String newBody = sc.next();
//
//					Article newArticle = new Article();
//
//					newArticle.setId(index);
//					newArticle.setTitle(newTitle);
//					newArticle.setBody(newBody);
//
//					articles.set(i, newArticle);
//					break;
//				}
				
//				Article ver.
				System.out.println("수정할 게시물 선택 : ");
				int targetId = sc.nextInt();
				Article target = getArticleById(targetId);
				
				if(target == null)
				{
					System.out.println("없는 게시물입니다.");
				}
				

				else {
					System.out.println("게시물 제목을 입력해주세요 :");
					String newTitle = sc.next();

					System.out.println("게시물 내용을 입력해주세요 :");
					String newBody = sc.next();

					target.setTitle(newTitle);
					target.setBody(newBody);

				}

			}

			if (cmd.equals("delete")) {
				System.out.println("삭제할 게시물 선택 : ");
				int targetId = sc.nextInt();
				Article target = getArticleById(targetId);

				if (target == null) {
					System.out.println(targetId + "번 게시물이 삭제되었습니다.");
				}
				
				else
				{
					articles.remove(target);
				}
				
			}

			if (cmd.equals("read")) {
				
				System.out.println("몇번 째 게시물을 보시겠습니까?");
				int targetId = sc.nextInt();
				Article target = getArticleById(targetId);

				if (target == null) {
					System.out.println("게시물이 존재하지 않습니다.");
				}
				
				else
				{
					target.setView(target.getView()+1);
					
					System.out.println("====" + articles.get(targetId-1).getId() + "번 게시물" + "====");
					System.out.println("번호 : " + articles.get(targetId-1).getId());
					System.out.println("제목 : " + articles.get(targetId-1).getTitle());
					System.out.println("내용 : " + articles.get(targetId-1).getBody());
					System.out.println("==================");
					
				}	
			}
			
			
		}
	}
	// index ver.
	private static int getArticleIndexById(int targetId) {
		for (int i = 0; i < articles.size(); i++) {
			int id = articles.get(i).getId();
			if (id == targetId) {
				return i;
			}
		}
		return -1;
	}

	// Article ver.
	private static Article getArticleById(int targetId) {
		for (int i = 0; i < articles.size(); i++) {
			int id = articles.get(i).getId();
			if (id == targetId) {
				return articles.get(i);
			}
		}
		return null;
	}
}