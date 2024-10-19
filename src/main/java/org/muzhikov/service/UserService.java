package org.muzhikov.service;

import org.muzhikov.model.User;

import java.util.List;

public interface UserService {
	void add(User user);
	
	User get(long id);
	
	void update(User user);
	
	void delete(long id);
	
	List<User> getUsers();
}
