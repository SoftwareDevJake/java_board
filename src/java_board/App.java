package java_board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {
	
	SignupDao s_dao = new SignupDao();
	CommentDao c_dao = new CommentDao();
	ArticleDao dao = new ArticleDao();
	LikesDao l_dao = new LikesDao();
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		Signup s = new Signup();
		ArrayList<Signup> login = new ArrayList<>();
		int find_user = -1;
		Article a = new Article();
		
		while (true) {
//			Signup s = new Signup();
			login = s_dao.getSignup();
			
			if (find_user >= 0) {
				System.out.println("명령어 입력 [" + s_dao.getSignup().get(find_user).getId() + "("
						+ s_dao.getSignup().get(find_user).getNickname() + ")] : ");
			} else {
				System.out.print("명령어 입력 : ");
			}
			String cmd = sc.nextLine();

			if (cmd.equals("exit")) {
				System.out.println("종료");
				break;
			}

			if (cmd.equals("article add")) {

				if (find_user >= 0) 
				{
//					Article a = new Article();

					System.out.println("게시물 제목을 입력해주세요 :");
					String title = sc.nextLine();

					a.setTitle(title);

					System.out.println("게시물 내용을 입력해주세요 :");
					String body = sc.nextLine();
//					sc.nextLine();

					a.setBody(body);

					a.setWriter(s_dao.getSignup().get(find_user).getId());

					dao.insertArticle(a);

					System.out.println("게시물이 등록되었습니다.");
				}
				else
				{
					System.out.println("로그인 후 사용 가능합니다.");
				}

			}

			if (cmd.equals("article list")) {
				ArrayList<Article> articles = dao.getArticles();

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					System.out.println("번호 : " + article.getId());
					System.out.println("제목 : " + article.getTitle());
					System.out.println("작성자 : " + article.getWriter());
					System.out.println("등록날짜 : " + article.getDate());
					System.out.println("조회수 : " + article.getView());
					int likeCount = l_dao.getLikeCount(article.getId());
					System.out.println("좋아요 : " + likeCount);
//					System.out.println("내용 : " + article.getBody());
					System.out.println("====================");
				}
			}

			if (cmd.equals("article update")) {

//				Article ver.
				System.out.println("수정할 게시물 선택 : ");
				int targetId = Integer.parseInt(sc.nextLine());
				Article target = dao.getArticleById(targetId);

				if (target == null) {
					System.out.println("없는 게시물입니다.");
				}

				else {
					System.out.println("게시물 제목을 입력해주세요 :");
					String newTitle = sc.nextLine();

					System.out.println("게시물 내용을 입력해주세요 :");
					String newBody = sc.nextLine();

					target.setTitle(newTitle);
					target.setBody(newBody);

				}

			}

			if (cmd.equals("article delete")) {
//				ArrayList<Article> articles = dao.getArticles();

				System.out.println("삭제할 게시물 선택 : ");
				int targetId = Integer.parseInt(sc.nextLine());
				Article target = dao.getArticleById(targetId);

				if (target == null) {
					System.out.println(targetId + "번 게시물이 삭제되었습니다.");
				}

				else {
					dao.removeArticle(target);
				}

			}

			if (cmd.equals("article read")) {

				System.out.println("몇번 째 게시물을 보시겠습니까?");
				int targetId = Integer.parseInt(sc.nextLine());

				Article target = dao.getArticleById(targetId);
				ArrayList<Comment> commentArray = c_dao.getComments();
				if (target == null) {
					System.out.println("게시물이 존재하지 않습니다.");
				}

				else {
					target.setView(target.getView() + 1);
					ArrayList<Comment> cm = c_dao.getCommentsByParentId(targetId);

					dao.displayAnArticle(target,l_dao);
					c_dao.displayComments(cm);

					while (true) {
						System.out.println("상세보기 기능을 선택해주세요");
						System.out.println("1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 뒤로가기");
						
						int choice = Integer.parseInt(sc.nextLine());
						Comment c = new Comment();
	
						if (choice == 1) // 댓글 등록
						{
							if(s_dao.checkIfLogin(find_user))
							{
								
								System.out.println("댓글 내용을 입력해주세요 : ");
								
								String comment = sc.nextLine();
								
								c.setParentId(targetId);
								c.setComment(comment);
								c.setWriter(s_dao.getSignup().get(find_user).getId());
	
								c_dao.insertComment(c);
	
								System.out.println("댓글이 등록 되었습니다.");
	
								dao.displayAnArticle(target,l_dao);
								c_dao.displayComments(commentArray);
							}
						}

						else if (choice == 2) // 좋아요
						{
//							Likes like = new Likes(target.getWriter(), login.get(find_user).getId());
							
							Likes rst = l_dao.getLikeByArticleIdAndMemberId(target.getId(), login.get(find_user).getId());
							
							if(rst == null)
							{
								Likes like = new Likes(target.getId(), login.get(find_user).getId());
								l_dao.insertLikes(like);
								
								System.out.println("해당 게시물을 좋아요 했습니다.");
								dao.displayAnArticle(target, l_dao);
							}
							
							else
							{
								//해제 - 삭제
								l_dao.removeLikes(rst);
								System.out.println("해당 게시물 좋아요를 해제했습니다.");
								dao.displayAnArticle(target, l_dao);
							}
							
						}

						else if (choice == 3) // 수정
						{
							
							System.out.println("회원 아이디 : " + s.getId());
							System.out.println("작성자 아이디 : " + target.getWriter());
							
							if(s.getId().equals(target.getWriter()))
							{
								System.out.println("수정할 제목을 입력해주세요");
								String newTitle = sc.nextLine();
								System.out.println("수정할 내용을 입력해주세요");
								String newBody = sc.nextLine();
	
								target.setTitle(newTitle);
								target.setBody(newBody);
								
								System.out.println("수정되었습니다.");
								dao.displayAnArticle(target,l_dao);
								c_dao.displayComments(commentArray);
							}
							
							else
							{
								System.out.println("자신의 게시물만 수정, 삭제 할 수 있습니다.");
							}
						}

						else if (choice == 4) // 삭제
						{
							if(s.getId().equals(target.getWriter()))
							{
								dao.removeArticle(target);
								System.out.println("삭제되었습니다.");
								break;
							}
							else
							{
								System.out.println("자신의 게시물만 수정, 삭제 할 수 있습니다.");
							}
						}

						else if (choice == 5) // 뒤로가기
						{
							break;
						}

						else {

						}

					}
				}
			}

			if (cmd.equals("article search")) {

				System.out.println("검색 항목을 선택해주세요");
				System.out.println("1. 제목, 2. 내용, 3. 제목 + 내용, 4. 작성자");
				int choice = Integer.parseInt(sc.nextLine());
				ArrayList<Article> searchedArticles;

				if (choice == 1) {
					System.out.println("검색할 제목 키워드를 입력해주세요.");
					String keyword = sc.nextLine();

					searchedArticles = dao.getSearchedArticlesByChoice(choice, keyword);

					dao.displayArticles(searchedArticles);
				}

				if (choice == 2) {
					System.out.println("검색할 내용 키워드를 입력해주세요.");
					String keyword = sc.nextLine();

					searchedArticles = dao.getSearchedArticlesByChoice(choice, keyword);

					dao.displayArticles(searchedArticles);
				}

				if (choice == 3) {
					System.out.println("검색할 제목과 내용 키워드를 입력해주세요");
					String keyword = sc.nextLine();

					searchedArticles = dao.getSearchedArticlesByChoice(choice, keyword);

					dao.displayArticles(searchedArticles);

				}

				if (choice == 4) {
					System.out.println("검색할 작성자 키워드를 입력해주세요");
					String keyword = sc.nextLine();

					searchedArticles = dao.getSearchedArticlesByChoice(choice, keyword);

					dao.displayArticles(searchedArticles);
				}
			}
			
			if (cmd.equals("article sort"))
			{
				// 조회수로 오름차순
				ArrayList<Article> articles = dao.getArticles();
				
				System.out.println("정렬 대상을 선택해주세요. (id : 번호, like : 좋아요, hit : 조회수) : ");
				String sortType = sc.nextLine();
				
				System.out.println("정렬 방법을 선택해주세요. (asc : 오름차순, desc : 내림차순) : ");
				String sortWay = sc.nextLine();
				
				MyComparator comp = new MyComparator();
				comp.sortWay = sortWay;
			
				Collections.sort(articles, comp);
				dao.displayArticles(articles);
				
				
				
				
				
//				if(sortType.equals("id"))
//				{
					
//					
					
//				}
//				
//				else if(sortType.equals("like"))
//				{
//					
//				}
				
				
				
				
			}

			if (cmd.equals("member signup")) {
//				Signup s = new Signup();
				System.out.println("==== 회원 가입을 진행합니다 ====");
				System.out.println("아이디를 입력해주세요 : ");
				String id = sc.nextLine();
				s.setId(id);

				System.out.println("비밀번호를 입력해주세요 : ");
				String password = sc.nextLine();
				s.setPassword(password);

				System.out.println("닉네임을 입력해주세요 : ");
				String nickname = sc.nextLine();
				s.setNickname(nickname);

				s_dao.insertSignup(s);

				System.out.println("==== 회원가입이 완료되었습니다 ====");
			}

			if (cmd.equals("member signin")) {
//				Signup s = new Signup();
//				login = s_dao.getSignup();

				System.out.println("아이디를 입력해주세요 : ");
				String id = sc.nextLine();

				System.out.println("비밀번호를 입력해주세요 :");
				String password = sc.nextLine();
				
				for (int i = 0; i < login.size(); i++) {
					if (id.equals(s_dao.getSignup().get(i).getId())
							&& password.equals(s_dao.getSignup().get(i).getPassword())) {
						find_user = i;
					}
				}

				if(find_user == -1)
				{
					System.out.println("아이디와 비밀번호를 다시한번 확인해 주십시오.");
				}
				
				else if (id.equals(s_dao.getSignup().get(find_user).getId())
						&& password.equals(s_dao.getSignup().get(find_user).getPassword())) 
				{
					System.out.println(s_dao.getSignup().get(find_user).getNickname() + "님 환영합니다!");
					s.setId(s_dao.getSignup().get(find_user).getId());
				} 
			}
			
			if(cmd.equals("member logout"))
			{
				if(s_dao.checkIfLogin(find_user))
				{
					find_user = -1;
				}
			}
			
			if(cmd.equals("member myinfo"))
			{
				if(s_dao.checkIfLogin(find_user))
				{
					System.out.println("아이디 : " + s_dao.getSignup().get(find_user).getId());
					System.out.println("닉네임 : " + s_dao.getSignup().get(find_user).getNickname());
				}
			}

			if (cmd.equals("help")) {
				System.out.println("article [add : 게시물 추가 / list : 게시물 목록 조회 / read : 게시물 조회 / search : 검색]");
				System.out.println(
						"member [signup : 회원가입 / signin : 로그인 / findpass : 비밀번호 찾기 /\n findid : 아이디 찾기 / logout : 로그아웃 / myinfo : 나의 정보 확인 및 수정]");

			}
		
		}
	}
	
	
}
