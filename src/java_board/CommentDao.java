package java_board;

import java.time.LocalDate;
import java.util.ArrayList;

public class CommentDao {

	private ArrayList<Comment> comments;
	private int no = 1;
	
	public CommentDao()
	{
		comments = new ArrayList<>();
		
	}
	
	public void insertComment(Comment c)
	{
		c.setId(no);
		no++;
		c.setDate(getCurrentDate());
		
		comments.add(c);
	}
	
	public void removeComment(Comment c)
	{
		comments.remove(c);
	}
	
	public static Object getCurrentDate()
	{
		LocalDate date = LocalDate.now();
		
		return date;
	}
	
	public ArrayList<Comment> getComments()
	{
		return comments;
	}
	
	public ArrayList<Comment> getCommentsByParentId(int parentId)
	{
		ArrayList<Comment> searchedComments = new ArrayList<Comment>();
		ArrayList<Comment> searchComments = getComments();
		
		for(int i = 0 ; i < searchComments.size(); i++)
		{
			Comment comment = comments.get(i);
			
			if(comment.getParentId() == parentId)
			{
				searchedComments.add(comment);
			}
		}
		
		return searchedComments;
	}
	
	public void displayComments(ArrayList<Comment> searchedComments)
	{
		for(int i = 0; i < searchedComments.size(); i++)
		{
			Comment comment = searchedComments.get(i);
			System.out.println("내용 : " + comment.getComment());
			System.out.println("작성자 : " + comment.getWriter());
			System.out.println("등록날짜 : " + comment.getDate());
			System.out.println("===============");
		}
	}
}
