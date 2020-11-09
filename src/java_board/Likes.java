package java_board;

public class Likes {
	private int id; // 좋아요 번호
	private int parentId; // 원글 번호
	private String memberId; // 체크 유저 번호
	private Object date; // 등록 날짜
	
	public Likes()
	{
		
	}
	
	public Likes(int parentId, String memberId)
	{
		this.parentId = parentId;
		this.memberId = memberId;
	}
	
	public Likes(int parentId, String memberId, Object date) {
		this.parentId = parentId;
		this.memberId = memberId;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Object getDate() {
		return date;
	}
	public void setDate(Object date) {
		this.date = date;
	}

	
}
