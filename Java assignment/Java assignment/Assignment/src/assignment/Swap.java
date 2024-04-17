package assignment;

public class Swap 
{		
	public static void swap(int x, int y)
	{
		int temp;
		temp =x;
		x=y;
		y=temp;
		System.out.println("after swap x: "+x);
		System.out.println("after swap y: "+y);
	}
	

	public static void main(String[] args) 
	{
		int x=10;
		int y=20;
		System.out.println("before swap x: "+x);
		System.out.println("before swap y: "+y);
		swap(x,y);
	}

}
