package classwork;

public class ThrowsEx 
{
	public void doAthing() throws Exception 
	{
		int a = 10;
		int b = 0;
		int s = a/b;
	}
	public void didAthing()
	{
		try
		{
			doAthing();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void nothing() throws Exception 
	{
		doAthing();
	}
	public static void main(String args[]) throws Exception
	{
		ThrowsEx t = new ThrowsEx();
		t.didAthing();
		try 
		{
			t.doAthing();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		t.nothing();
	}
}
