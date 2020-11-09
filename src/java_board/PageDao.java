package java_board;

import java.util.ArrayList;

public class PageDao {
	
	private ArrayList<Page> pages;
	private int no = 5;
	Page page = new Page();
	
	
	public void pageList()
	{
		for(int i = 0; i < no; i++)
		{
			
			System.out.println("1 2 3 4 5");
//			System.out.print("[" + pages.get(i) + "] ");
			
		}
		
	}
	
	public void insertPage(Page p, ArrayList<Article> articles)
	{
		
		if(articles.size() > 3)
		{
			p.setPage(no);
			insertPage(p, articles);
			no++;
			pages.add(p);
		}
		
	}
	
	public void getCurrentPage(Page p)
	{
		int currentPage = p.getCurrentPage();
		if(p.getCurrentPage() == 1)
		{
			System.out.println("[" + currentPage + "]");
		}
	}
}
