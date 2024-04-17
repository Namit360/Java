package classwork;

public class Mythread extends Thread 
{
	public void run() 
	{
		System.out.println("Child Thread");
		for(int i=10; i>=0; i--)
		{
			if(i==3)
			{
				try 
				{
					Thread.sleep(500);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
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
		
		Thread t1 = new Mythread();
		t1.start();
		Thread t2 = new Mythread();
		t2.start();
	}
}
