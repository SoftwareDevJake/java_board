package java_board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyComparator implements Comparator<Article> {

	String sortWay = "asc";
	String sortType = "view";
	
	MyComparator()
	{
		
	}
	
	MyComparator(String sortType)
	{
//		if(sortType.equals("id"))
//		{
//			ArrayList<Article> articleId = new ArrayList<>();
//			articleId = dao.getArticles();
//			
//							
//			Collections.sort(articleId, comp);
//			
//			dao.displayArticles(articleId);
//		}
	}
	
	public int compare(Article o1, Article o2) {
		int c1 = 0;
		int c2 = 0;
		
		if(sortType.equals("view")) // 조회수
		{
			c1 = o1.getView();
			c2 = o2.getView();
		}
		
		else if(sortType.equals("like")) // 좋아요
		{
			c1 = o1.getLikes();
			c2 = o2.getLikes();
		}
		
		if(sortWay.equals("asc"))
		{
			if(c1 > c2) // 오름차순
			{
				return 1;
			}
			return -1; // 양수, 음수, 0 리턴
		}
		
		else
		{
			if(c1 > c2) // 내림차순
			{
				return 1;
			}
			return -1; // 양수, 음수, 0 리턴
		}
		
		
	}	

}
