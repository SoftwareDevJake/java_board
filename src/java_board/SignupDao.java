package java_board;

import java.util.ArrayList;

public class SignupDao {
	
	private ArrayList<Signup> signup;
	private int no = 1;
	
	public SignupDao()
	{
		signup = new ArrayList<Signup>();
		
		Signup s1 = new Signup("a","b","c",0);
		Signup s2 = new Signup("didrudcks","rudcksdid","jake",1);
		Signup s3 = new Signup("hannah001kr","kr090909","hanna",2);
		
		signup.add(s1);
		signup.add(s2);
		signup.add(s3);
		
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
	
	public boolean checkIfLogin(int find_user)
	{
		if(find_user >= 0)
		{
			return true;
		}
		
		else
		{
			System.out.println("로그인이 필요한 기능입니다.");
			return false;
		}
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
