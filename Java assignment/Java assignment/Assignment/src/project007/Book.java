package project007;
import java.util.Scanner;

public class Book 
{
	public int sNo;
	public String bookName;
	public String authorName;
	public int bookQty;
	public int bookQtyCopy;

	Scanner input = new Scanner(System.in);
	
	public Book(){}

	public Book(int sNo,String bookName,String authorName,int bookQty)
	{
	    this.sNo = sNo;
	    this.bookName = bookName;
	    this.authorName = authorName;
	    this.bookQty = bookQty;
	}
	
	public String toString() 
	{
		return "SNo=" + sNo + ", BookName=" + bookName + ", AuthorName=" + authorName + ", BookQty=" + bookQty;
	}
}
