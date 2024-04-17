package assignment3;
import java.util.Scanner;

class Arrayreverse
{
	void reverse(int a[], int n) 
	{
		int i;
		int k;
		int t; 
	    for (i = 0; i < n / 2; i++) 
	    { 
	        t = a[i]; 
	        a[i] = a[n - i - 1]; 
	        a[n - i - 1] = t; 
	    } 

	    System.out.println("Reversed array is: "); 
	    for (k = 0; k < n; k++) 
	    { 
	        System.out.println(a[k]); 
	    }
	}	
}

class Reverse 
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
		Arrayreverse a1 = new Arrayreverse();
		a1.reverse(array, array.length);
	}
}
