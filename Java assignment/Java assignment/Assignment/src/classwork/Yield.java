package classwork;

public class Yield extends Thread 
{
	public void run()
	{
		for(int i=0;i<=5;i++)
		{
			if(i==3)
			{
					Thread.yield();
				
			}
			System.out.println(i);
		}
				
	}

	public static void main(String[] args) 
	{
		System.out.println("Main Thread");				
		Thread t =new ThreadPrority();
		t.setPriority(10);
		t.start();
		
		Thread t1= new ThreadPrority();
		t1.setPriority(0);
		t1.start();
		
	}

}
