package assignment3;
import java.util.Scanner;

class Display
{
	void displayoddeven(int arr[],int n) 
	{
		System.out.println("EVEN NUMBERS ");
		for(int i=0;i<n;i++)
		{
			if(arr[i]%2 == 0)
			{
				System.out.println(arr[i]);
			}
		}
		
		System.out.println("ODD NUMBERS ");
		for(int i=0;i<n;i++)
		{
			if(arr[i]%2 != 0 )
			{
				System.out.println(arr[i]);
			}
		}
	}	
}

public class OddEven 
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
		sc.close();
		Display d = new Display();
		d.displayoddeven(array, array.length);
	}
}
