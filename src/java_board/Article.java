package java_board;

import java.util.ArrayList;

public class Article {

	private int id;
	private String title;
	private String body;
	private String writer;
	private int view;
	private Object date;
	

	public Article()
	{
		
	}
	
	public Article(int id, String title, String body, String writer, int view, Object date)
	{
		this.id = id;
		this.title = title;
		this.body = body;
		this.writer = writer;
		this.view = view;
		this.date = date;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Object getDate() {
		return date;
	}

	public void setDate(Object date) {
		this.date = date;
	}

	public boolean contains(String keyword) {
		return title.contains(keyword);
	}
	
	public String getPropertiesByChoice(int choice) {
		String str = "";
		if(choice == 1)
		{
			str = this.getTitle();
		}
		
		if(choice == 2)
		{
			str = this.getBody();
		}
		
		if(choice == 3)
		{
			str = this.getTitle() + this.getBody();
			
		}
		
		if(choice == 4)
		{
			str = this.getWriter();
		}
		
		return str;
	}
}
