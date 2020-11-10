package java_board;

public class Signup {
	private String id;
	private String password;
	private String nickname;
	private int no;
	
	public Signup()
	{
		
	}
	
	public Signup(String id, String password, String nickname, int no)
	{
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.no = no;

	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
