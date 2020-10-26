package java_board;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArticleDao {
	// Data Access Object

	private static ArrayList<Article> articles;
	private int no = 4;

	public ArticleDao() {
		articles = new ArrayList<>();

		Article a1 = new Article(1, "안녕하세요.", "내용1", "익명", 0, getCurrentDate());
		Article a2 = new Article(2, "반갑습니다.", "내용2", "익명", 0, getCurrentDate());
		Article a3 = new Article(3, "안녕", "내용3", "익명", 0, getCurrentDate());

		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
	}
	
	public void insertArticle(Article a) {
		a.setId(no);
		no++;
		a.setDate(getCurrentDate());

		articles.add(a);

	}
	
	public void removeArticle(Article a) 
	{
		articles.remove(a);
	}
	
	private static Object getCurrentDate() {
		LocalDate date = LocalDate.now();

		return date;
	}

	// Article ver.
	public static Article getArticleById(int targetId) {
		for (int i = 0; i < articles.size(); i++) {
			int id = articles.get(i).getId();
			if (id == targetId) {
				return articles.get(i);
			}
		}
		return null;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}
	
	public ArrayList<Article> getSearchedArticlesByTitle(String keyword)
	{
		ArrayList<Article> searchedArticles = new ArrayList<>();
		for(int i = 0; i < articles.size(); i++)
		{
			Article article = articles.get(i);
			String str = article.getTitle(); // 각 게시물 제목
			if (str.contains(keyword))
			{
				searchedArticles.add(article);
			}
		}
		
		return searchedArticles;
	}
	
	public ArrayList<Article> getSearchedArticlesByBody(String keyword)
	{
		ArrayList<Article> searchedArticles = new ArrayList<>();
		for(int i = 0; i < articles.size(); i++)
		{
			Article article = articles.get(i);
			String str = article.getBody(); // 각 게시물 내용
			if( str.contains(keyword))
			{
				searchedArticles.add(article);
			}
		}
		return searchedArticles;
	}
	
	public ArrayList<Article> getSearchedArticlesByTitleAndBody(String keyword)
	{
		ArrayList<Article> searchedArticles = new ArrayList<>();
		
		for(int i = 0; i < articles.size(); i++)
		{
			Article article = articles.get(i);
			String title = article.getTitle();
			String body = article.getBody();
			if(title.contains(keyword) || body.contains(keyword))
			{
				searchedArticles.add(article);
			}
		}
		
		return searchedArticles;
	}
	
	public ArrayList<Article> getSearchedByWriter(String keyword)
	{
		ArrayList<Article> searchedArticles = new ArrayList<>();
		
		for(int i = 0; i < articles.size(); i++)
		{
			Article article = articles.get(i);
			String Writer = article.getWriter();
			if(Writer.contains(keyword))
			{
				searchedArticles.add(article);
			}
		}
		
		return searchedArticles;
	}
	
	
}

	