package br.estacio.config;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.event.LoggerListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService);
	auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	authenticationProvider.setUserDetailsService(userDetailsService);
	authenticationProvider.setPasswordEncoder(passwordEncoder());
	return authenticationProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public LoggerListener loggerListener() {
	return new LoggerListener();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests()
	.antMatchers("/user/register/**").access("hasRole('ROLE_SYSADMIN')")
	.antMatchers("/index.jsp", "/webjars/**", "/resources/**").permitAll()
	.anyRequest().authenticated()
	.and()
	.formLogin()
	.loginPage("/login").failureUrl("/login?error").successForwardUrl("/home").permitAll()
	.usernameParameter("username").passwordParameter("password")
	.and()
	.logout()
	.logoutUrl("/logout").logoutSuccessUrl("/home").permitAll()
	.and()
	.csrf()
	.and()
	.httpBasic();
	}

}
