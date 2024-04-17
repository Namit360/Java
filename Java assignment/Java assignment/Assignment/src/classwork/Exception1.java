package classwork;

public class Exception1 
{
	static int arr[]=new int[5];
	static int a;
	static int b;
	
	public static void main(String args[])
	{
		try
		{
			arr[5]=10;
			
			try
			{
			  a=b/0;	
			}
			catch(ArithmeticException e)
			{
				e.printStackTrace();
			}
		}		
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		
	}
}
