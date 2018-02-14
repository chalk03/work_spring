package com.koitt.book.service;

import java.util.List;

import com.koitt.book.model.Book;
import com.koitt.book.model.BookException;


public interface BookService {

	// 도서 등록
	public void add(Book book) throws BookException;

	// 도서 상세정보
	public Book detail(String isbn	) throws BookException;

	// 도서 전체
	public List<Book> list() throws BookException;

	// 도서 개수
	public int count() throws BookException;

	// 도서 수정하기
	public void modify(Book book) throws BookException;

	// 도서 삭제하기
	public void remove(String isbn) throws BookException;
}
