package java_board;

import java.util.ArrayList;

public class PageDao {
	
	private ArrayList<Page> pages;
	private int no = 5;
	
	public void pageList(Page page)
	{
		for(int i = page.getStartPageNumberInBlock(); i <= page.getEndPageNumberInBlock(); i++)
		{
			
			if(i == page.getCurrentPage())
			{
				System.out.print("[" + i + "] ");
			}
			else
			{
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
	
	public void insertPage(Page p, ArrayList<Article> articles)
	{
		
		if(articles.size() > 3)
		{
			p.setCurrentPage(no);
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
