package java_board;

import java.util.ArrayList;

public class SignupDao {
	
	private ArrayList<Signup> signup;
	private int no = 1;
	
	public SignupDao()
	{
		signup = new ArrayList<Signup>();
	}
	
	public void insertSignup(Signup s)
	{
		s.setNo(no);
		no++;
		signup.add(s);
	}
	
	public void removeSignup(Signup s)
	{
		signup.remove(s);
	}
	
	public ArrayList<Signup> getSignup()
	{
		return signup;
	}
	
//	public String getId()
//	{
//		Signup s = new Signup();
//		return s.getId();
//	}
//	
//	public String getPassword()
//	{
//		
//	}
	
	
	
}
