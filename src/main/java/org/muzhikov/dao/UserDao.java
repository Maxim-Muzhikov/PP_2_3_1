package org.muzhikov.dao;

import org.muzhikov.model.User;

import java.util.List;

public interface UserDao {
	void add(User user);
	
	User get(long id);
	
	void update(User user);
	
	void delete(long id);
	
	List<User> getUsers();
}
