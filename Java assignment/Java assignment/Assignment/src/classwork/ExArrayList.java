package classwork;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExArrayList 
{
	public static void main(String args[])
	{
		ArrayList<Customer> arr = new ArrayList<>();
		List<Customer> arr1 = new ArrayList<>();
		
		arr.add(new Customer(101,"ABSKLL","QWERTYUIOP"));		
		Iterator<Customer> itr = arr.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		arr1.add(new Customer(102,"AAKDIE","SOUNSXFVWNSJGFVDG"));
		Iterator<Customer> itr1 = arr1.iterator();
		while(itr1.hasNext())
		{
			System.out.println(itr1.next());
		}
	}
}
