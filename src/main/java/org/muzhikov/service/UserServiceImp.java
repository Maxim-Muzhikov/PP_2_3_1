package org.muzhikov.service;

import org.muzhikov.dao.UserDao;
import org.muzhikov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
	
	private final UserDao userDao;
	
	@Autowired
	public UserServiceImp(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Transactional
	@Override
	public void add(User user) {
		userDao.add(user);
	}
	
	@Transactional(readOnly = true)
	@Override
	public User get(long id) {
		return userDao.get(id);
	}
	
	@Transactional
	@Override
	public void update(User user) {
		userDao.update(user);
	}
	
	@Transactional
	@Override
	public void delete(long id) {
		userDao.delete(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}
}
