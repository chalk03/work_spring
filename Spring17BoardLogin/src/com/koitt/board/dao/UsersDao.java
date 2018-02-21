package com.koitt.board.dao;

import java.util.List;

import com.koitt.board.model.Users;
import com.koitt.board.model.UsersException;

public interface UsersDao {

	public List<Users> selectAll() throws UsersException;
	
	public Users select(Integer no) throws UsersException;
	
	public void insert(Users uesrs) throws UsersException;
	
	public void delete(String email) throws UsersException;
	
	public void deleteUserTypes(Integer no) throws UsersException;
	
	public void update(Users users) throws UsersException;
}
