package assignment3;
import java.util.ArrayList;
import java.util.Scanner;

class Countdup
{
	void countRepeated(int arr[], int n)
	{
		ArrayList a = new ArrayList();
		int temp = 0;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if (arr[i] == arr[j])
				{
					if(a.contains(arr[i]))
					{
						break;
					}
					else
					{
						a.add(arr[i]);
						temp =1;
					}
				}
					
			}	
		}
		if(temp ==1)
		{
			System.out.println("Repeated elements "+a);
		}
		else
		{
			System.out.println("No duplicate elements ");
		}
	}
}

public class Dublicate
{
	public static void main(String args[])	
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
		Countdup d = new Countdup();
		d.countRepeated(array, array.length);
	}
}
