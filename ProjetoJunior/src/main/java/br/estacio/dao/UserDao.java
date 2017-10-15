package br.estacio.dao;

import java.io.Serializable;

import br.estacio.model.User;

public interface UserDao extends Serializable {
	
	public User save(User user);
	public void delete(Long id);
	public Iterable<User> findAll();
	public User findByEmail(String email);

}
