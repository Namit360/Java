package project007;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User 
{
	ArrayList<Book> books = new ArrayList<>();
	ArrayList<Book> borrow = new ArrayList<>();
	public int count = 0;
	Scanner input = new Scanner(System.in);
		
	public void searchBySno()
	{
	    int sNo;
	    System.out.println("Enter Serial No of Book:");
	    sNo = input.nextInt();
	    int flag = 0;
	    for (int i=0; i<count; i++)
	    {
	        if (books.contains(sNo))
	        {
	            System.out.println("books");
	            flag++;
	            return;
	        }
	    }
	    if (flag == 0)
	        System.out.println("No Book for Serial No " + sNo + " Found.");
	}
		
	public void searchByAuthorName()
	{
	    input.nextLine();
	    System.out.println("Enter Author Name:");
	    String authorName = input.nextLine();
	    int flag = 0;
	    for (int i=0; i<count; i++)
	    {

	        if (books.contains(authorName))
	        {
	        	System.out.println("books");
	            flag++;
	        }

	    }
	    if (flag == 0)
	        System.out.println("No Books of " + authorName + " Found.");
	}
	
	private Integer dews(Book book)
	{
        Date today = new Date();
		Date dewDate = null;
		Long min = Math.abs(today.getTime() - dewDate.getTime());
        Long day = min / (24 * 60 * 60 * 1000);
        return day.intValue();
    }
	
	public boolean returnBook (Book book) 
	{
		double lateFees = 50;
        if (borrow.indexOf(book) >= 0) 
        {
            Integer dew = dews(book);
            if (dew > 30) 
            {
            	lateFees = lateFees + ((dew-10)*1.00);
            }
            this.borrow.remove(book);
            return true;
        }
        return false;
    }
	
	public static void main(String args[])
	{
			User u = new User();
			Book b = new Book();
			System.out.println("Press 1 to issue a book");
			System.out.println("Press 2 to return a book");
			System.out.println("Press 3 to search by author name");
			System.out.println("Press 4 to search by serial number");
			System.out.println("Press 5 to exit");
			Scanner c = new Scanner(System.in);
			int choice = c.nextInt();
			do {
				switch (choice) {
				case 1:
					break;
				case 2:
					u.returnBook(b);
					break;
				case 3:
					u.searchByAuthorName();
					break;
				case 4:
					u.searchBySno();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Invalid input");
					break;
				}
				c = new Scanner(System.in);
				choice = c.nextInt();
			}
			while (choice > 0 && choice < 5);
	
	
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","root");
        PreparedStatement stmt=con.prepareStatement("insert into myuser value(?,?)");
        int i=stmt.executeUpdate();
        System.out.println(i + "Number of records inserted");
	} 
	catch (ClassNotFoundException e) 
	{
		e.printStackTrace();
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	}	
}
