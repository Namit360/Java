package com.spring.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.model.Book;
import com.spring.repository.BooksRepository;

public class BooksService 
{
	@Autowired  
	BooksRepository booksRepository;  
	public List<Book> getAllBooks()   
	{  
	List<Book> books = new ArrayList<Book>();  
	booksRepository.findAll().forEach(books1 -> books.add(books1));  
	return books;  
	}  
	public Book getBooksById(int id)   
	{  
	return booksRepository.findById(id).get();  
	}  
	public void saveOrUpdate(Book books)   
	{  
	booksRepository.save(books);  
	}  
	public void delete(int id)   
	{  
	booksRepository.deleteById(id);  
	}  
	public void update(Book books, int bookid)   
	{  
	booksRepository.save(books);  
	}  
}
