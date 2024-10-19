package org.muzhikov.dao;

import org.muzhikov.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void add(User user) {
		entityManager.persist(user);
	}
	
	@Override
	public User get(long id) {
		return entityManager.find(User.class, id);
	}
	
	@Override
	public void update(User user) {
		User existingUser = entityManager.find(User.class, user.getId());
		if (existingUser != null) {
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setEmail(user.getEmail());
		}
	}
	
	@Override
	public void delete(long id) {
		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityManager.remove(user);
		}
	}
	
	@Override
	public List<User> getUsers() {
		TypedQuery<User> query = entityManager.createQuery("from User", User.class);
		return query.getResultList();
	}
}