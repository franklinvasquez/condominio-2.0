package co.edu.ufps.condominio.servicios.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.ufps.condominio.entity.UserRole;
import co.edu.ufps.condominio.repository.UserRepository;

@Service("UserServicioImpl")
public class UserServicioImpl implements UserDetailsService {

	@Autowired
	@Qualifier("UserRepository")
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		co.edu.ufps.condominio.entity.User user =userRepository.findByUsername(username);
		List<GrantedAuthority>authorities= buildAuthorities(user.getUserRole());
		return buildUser(user, authorities);
	}
	
	private User buildUser(co.edu.ufps.condominio.entity.User user ,List<GrantedAuthority> authorities) {
		
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles){
		Set<GrantedAuthority> auths = new HashSet<>();
		for(UserRole userRole:userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
		
	}

}
