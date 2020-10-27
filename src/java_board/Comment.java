package java_board;

import java.util.ArrayList;

public class Comment {
	
	private int id;
	private String comment;
	private String writer;
	private Object date;
	
	public Comment()
	{
		
	}

	public Comment(int id, String comment, String writer, Object date)
	{
		this.id = id;
		this.comment = comment;
		this.writer = writer;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Object getDate() {
		return date;
	}

	public void setDate(Object date) {
		this.date = date;
	}
	

	
}
