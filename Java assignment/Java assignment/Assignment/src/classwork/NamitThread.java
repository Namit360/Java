package classwork;

public class NamitThread implements Runnable
{
	public void run() 
	{
		System.out.println("Child Thread");
		for(int i=10; i>=0; i--)
		{
			System.out.println(i);
		}
		System.out.println("Child Thread end");
	}
	
	public static void main(String args[])
	{
		System.out.println("Main Thread");
		for(int i=0; i<=10; i++)
		{
			System.out.println(i);
		}
		System.out.println("Main Thread end");
		
		Runnable r = new NamitThread();
		Thread t1 = new Thread(r);
		t1.start();
	}
}
