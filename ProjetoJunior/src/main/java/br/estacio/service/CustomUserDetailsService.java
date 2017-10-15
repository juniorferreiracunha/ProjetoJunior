package br.estacio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.estacio.model.User;
import br.estacio.model.UserProfile;


@Service("UserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	@Qualifier("UserService")
	private UserService UserService;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
	User User = UserService.findByEmail(email);
	if (User == null) {
	throw new UsernameNotFoundException("Username not found");
	}
	
	return new org.springframework.security.core.userdetails.User(User.getEmail(), User.getPwd(),true, true, true, true, getGrantedAuthorities(User));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User User) {
		
	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
	for (UserProfile userProfile : User.getUserProfiles()) {
	authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
	}
	return authorities;
	}

}
