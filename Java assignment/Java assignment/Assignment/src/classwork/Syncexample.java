package classwork;

class Table
{
	Table()
	{
		
	}
	public void printTable(int n)
	{
		System.out.println("before sync");	
		synchronized (this) 
		{
			for(int i=1;i<=10;i++)
			{
				System.out.println(n+" x "+i+" = " +n*i);		
			}
		}
		System.out.println("after sync");
	}
}

class Display1 extends Thread
{
	Table table;
	public 	Display1(Table table)
	{
		this.table = table;
	}
	
	public void run()
	{
		table.printTable(5);
	}	
	
}

class Display2 extends Thread
{
	Table table;
	Display2(Table table)
	{
		this.table = table;
	}
	
	public void run()
	{
		table.printTable(7);
	}	
	
}

public class Syncexample
{
	public static void main(String[] args) 
	{
		Table t1 = new Table();
		Display1 d1= new Display1(t1);		
		d1.start();
		
		Table t2 = new Table();
		Display2 d2= new Display2(t2);		
		d2.start();
	}
}
