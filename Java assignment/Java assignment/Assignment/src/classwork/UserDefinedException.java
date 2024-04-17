package classwork;

class MyException extends RuntimeException
{
	String m;
	public MyException(String m) 
	{
		this.m=m;
		System.out.println(m);
	}
}

public class UserDefinedException 
{
	public static void validateName(String name) throws  MyException
	{
		if(name == null)
			System.out.println("Name cannot be null");
		else		
			System.out.println(name);
		
	}
	
	public static void main(String args[])
	{
		UserDefinedException.validateName(null);
		UserDefinedException.validateName("namit");
	}
}
