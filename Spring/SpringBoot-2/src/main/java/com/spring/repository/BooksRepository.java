package com.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.model.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer>
{
	
}