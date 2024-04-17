package assignment3;
import java.util.Scanner;

class Count
{
	int countOccurrences(int arr[], int n, int x)
	{
		int res=0;
		for(int i=0;i<n;i++)
		{
			if (x == arr[i])
	              res++;
		}
		System.out.println("No of time "+x+" occured "+res);
		return res;
	}
}


public class Occurance 
{
	public static void main(String[] args) 
	{
		int n;
		Scanner sc=new Scanner(System.in);  
		System.out.print("Enter the number of elements you want to store: ");  
		n=sc.nextInt(); 
		int[] array = new int[n];  
		System.out.println("Enter the elements of the array: ");  
		for(int i=0; i<n; i++)  
		{  
			array[i]=sc.nextInt();  
		}  
		System.out.println("Array elements are: ");  
		for (int i=0; i<n; i++)   
		{  
			System.out.println(array[i]);  
		} 
		
		System.out.println("Enter the element to be found ");
		int s=sc.nextInt();
		sc.close();
		Count c = new Count();
		c.countOccurrences(array, array.length, s);
	}
}
