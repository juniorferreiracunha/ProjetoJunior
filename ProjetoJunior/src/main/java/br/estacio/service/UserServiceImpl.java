package br.estacio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.estacio.dao.UserDao;
import br.estacio.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private static final long serialVersionUID = -3951326895743325749L;
	UserDao dao;

	@Autowired
	public void setUserdao(UserDao userdao) {
		this.dao = userdao;
	}

	@Override
	public User save(User user) {
		return dao.save(user);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public Iterable<User> findAll() {
		return dao.findAll();
	}

	@Override
	public User findByEmail(String email){
		return dao.findByEmail(email);
	}
}
