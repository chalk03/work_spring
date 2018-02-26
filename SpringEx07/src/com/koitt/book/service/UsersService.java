package com.koitt.book.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetails;

import com.koitt.book.model.Authority;
import com.koitt.book.model.Users;
import com.koitt.book.model.UsersException;

public interface UsersService {

	public List<Users> list() throws UsersException;
	
	public Users detail(Integer no) throws UsersException;
	
	public void add(Users users) throws UsersException;
	
	public String remove(Integer no, String password) throws UsersException;
	
	public String modify(Users users) throws UsersException;
	
	public Users detailByEmail(String email) throws UsersException;
	
	public Authority getAuthority(Integer id) throws UsersException;
	
	public UserDetails getPrincipal();
	
	public void logout(HttpServletRequest req, HttpServletResponse resp);
	
	
}
