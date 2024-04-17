package assignment;

public class Author
{
	private String name;
	private String email;
	private char gender;
		
	Author(String name, String email,char gender)
	{
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
	
	
	//name 	
	public String getName()
	{
		return name;
	}
	
	//email 
	public void setEmail(String email)
	{
		this.email = email;
	}
		
	public String getEmail()
	{
		return email;
	}
		
	//gender 		
	public char getGender()
	{
		return gender;
	}	
	
	public String toString()
	{
		return name+" ("+gender+") at "+email;
	}
	
	public static void main(String[] args)
	{
		Author a1 = new Author("Namit","namitrao360@gmail.com",'M');
		System.out.println(a1);
	}
}
