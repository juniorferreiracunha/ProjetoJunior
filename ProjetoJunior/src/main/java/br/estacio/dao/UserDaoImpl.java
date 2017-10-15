package br.estacio.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.estacio.model.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession() {
	return sessionFactory.getCurrentSession();
	}
	
	@Override
	public User save(User user) {
	getSession().saveOrUpdate(user);
	return getSession().get(User.class, user.getId());
	}
	
	@Override
	public void delete(Long id) {
	User u = getSession().get(User.class, id);
	getSession().delete(u);
	}
	
	@Override
	public Iterable<User> findAll() {
	TypedQuery<User> query = getSession().createQuery("select u from User u");
	return query.getResultList();
	}
	
	@Override
	public User findByEmail(String email) {
	TypedQuery<User> query = getSession().createQuery("select u from User u where u.email = ?1", User.class);
	query.setParameter(1, email);
	if (query.getResultList().isEmpty())
	return null;
	else
	return query.getSingleResult();
	}

}
