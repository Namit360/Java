package project007;
import java.util.Arrays;
import java.util.Scanner;

public class Admin 
{
	Book books[] = new Book[50]; 
	public int count;
	Scanner input = new Scanner(System.in);
	
	public int compareBookObjects(Book b1, Book b2)
	{
	    if (b1.bookName.equalsIgnoreCase(b2.bookName))
	    {
	        System.out.println("Book of this Name Already Exists.");
	        return 0;
	    }
	    if (b1.sNo==b2.sNo)
	    {
	        System.out.println("Book of this Serial No Already Exists.");
	        return 0;
	    }
	    return 1;
	}

	public void addBook(Book b)
	{
	    for (int i=0; i<count; i++)
	    {
	        if (this.compareBookObjects(b, this.books[i]) == 0)
	            return;
	    }

	    if (count<50)
	    {
	    	books[count] = b;
	        count++;
	    }
	    else
	    {
	        System.out.println("No Space to Add More Books.");
	    }
	}
	
	public String toString() 
	{
		return Arrays.toString(books);
	}
	
	public synchronized int issued(int sNo)
	{
	    for (int i=0; i<count; i++)
	    {
	        if (sNo == books[i].sNo)
	        {
	            if(books[i].bookQtyCopy > 0)
	            {
	                System.out.println("Book is issued");
	                return i;
	            }
	            System.out.println("Book is not issued");
	            return -1;
	        }
	    }
	    return -1;
	}
	public static void main(String args[])
	{
		Admin a = new Admin();
		a.addBook(new Book(123,"Harry potter","Jk Rowlings",20));
		a.addBook(new Book(125,"Fantastic beasts","Jk Rowlings",20));
		a.addBook(new Book(126,"Moby Dick","Herman Melville",20));
		a.addBook(new Book(126,"In Search of Lost Time","Marcel Proust",50));
		a.addBook(new Book(126,"Ulysses","James Joyce",20));			
		a.issued(123);
		System.out.println(a.toString());
	}
}
