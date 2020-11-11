package java_board;

import java.util.ArrayList;

public class LikesDao {

	private ArrayList<Likes> likes;
	private int no = 1;
	Util util = new Util();
	
	
	public LikesDao()
	{
		likes = new ArrayList<>();
		
	}
	
	public void insertLikes(Likes l)
	{
		l.setId(no);
		no++;
		l.setDate(util.getCurrentDate());
		
		likes.add(l);
	}
	
	public void removeLikes(Likes l)
	{
		likes.remove(l);
	}
	
	public Likes getLikeByArticleIdAndMemberId(int p_id, String id)
	{
		for(int i = 0; i < likes.size(); i++)
		{
			Likes like = likes.get(i);
			
			if(like.getParentId() == p_id && like.getMemberId().equals(id))
			{
				return like;
			}
		}
		
		return null;
	}
	
	public int getLikeCount(int id)
	{
		int count = 0;
		for(int i = 0; i < likes.size(); i++)
			{
				if(id == likes.get(i).getParentId())
				count++;
			}
		return count;
	}
	
}
