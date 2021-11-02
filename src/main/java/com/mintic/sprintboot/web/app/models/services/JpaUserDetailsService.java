package com.mintic.sprintboot.web.app.models.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.sprintboot.web.app.models.dao.IUserDao;
import com.mintic.sprintboot.web.app.models.entity.Role;
import com.mintic.sprintboot.web.app.models.entity.User;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private IUserDao userDao;
	
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByEmail(username);
		
		if(user == null) {
			logger.error("Error login: no existe el usuario "+username);
			throw new UsernameNotFoundException("Usuario " + username + "no existe en el sistema!");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role: user.getRole()) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}

		if(authorities.isEmpty()) {
			logger.error("Error login: usuario "+username+" no tiene roles asignados");
			throw new UsernameNotFoundException("Usuario " + username + "no tiene un role!");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getEnable(), true, true, true, authorities);
	}

}
