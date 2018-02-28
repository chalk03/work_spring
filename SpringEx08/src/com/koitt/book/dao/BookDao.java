package com.koitt.book.dao;

import java.util.List;

import com.koitt.book.model.Book;
import com.koitt.book.model.BookException;


public interface BookDao {

	// 도서 등록
	public void insert(Book isbn) throws BookException;

	// 도서번호를 이용하여 책 불러오기
	public Book select(String isbn) throws BookException;

	// 전체 도서 불러오기
	public List<Book> selectAll() throws BookException;

	// 도서 수정하기
	public void update(Book book) throws BookException;

	// 도서 삭제하기
	public void delete(String isbn) throws BookException;
	
	// 도서 전체 삭제하기
	public void deleteAll() throws BookException;
	
	// 도서 개수 가져오기
	public Integer getCount() throws BookException;
	
	public Integer selectLastInsertId() throws BookException;
}
