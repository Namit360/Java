package com.spring.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book 
{
	@Id
	public int bookid;
	public String bookname;
	public String authorname;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", authorname=" + authorname + "]";
	}
}
