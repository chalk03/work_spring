package com.koitt.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koitt.book.dao.BookDao;
import com.koitt.book.model.Book;
import com.koitt.book.model.BookException;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao dao;
	
	@Override
	public void add(Book book) throws BookException {
		dao.insert(book);
		
	}

	@Override
	public Book detail(String isbn) throws BookException {
		return dao.select(isbn);
	}

	@Override
	public List<Book> list() throws BookException {
		return dao.selectAll();
	}

	@Override
	public int count() throws BookException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String modify(Book book) throws BookException {
		Book item = dao.select(book.getIsbn().toString());
		String filename = item.getAttachment(); 
		
		dao.update(book);
		
		return filename;
		
	}

	@Override
	public String remove(String isbn) throws BookException {
		Book book = dao.select(isbn);
		String filename = book.getAttachment();
		
		dao.delete(isbn);
		
		return filename;
		
	}

}
