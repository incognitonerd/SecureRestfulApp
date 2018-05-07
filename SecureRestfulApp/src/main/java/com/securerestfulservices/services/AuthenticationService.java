package com.securerestfulservices.services;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.securerestfulservices.repositories.UserDetailRepository;
import com.securerestfulservices.security.domains.Authentication;
import com.securerestfulservices.security.domains.Role;
import com.securerestfulservices.security.domains.UserDetail;

@Component
public class AuthenticationService implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);
	@Autowired
	private UserDetailRepository userRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		SecurityContextHolder.clearContext();
		System.out.println("rockets");
		LOGGER.info("username - " + username);
		try{
			if(username == null || username.isEmpty()){
				throw new UsernameNotFoundException("User not found");
			}
			UserDetail user = userRepository.findByUsername(username);
			if(user == null || user.getAuthentication() == null){
				throw new UsernameNotFoundException("User not found");
			}
			return new User(user.getAuthentication().getUsername(), user.getAuthentication().getPassword(),
					getAuthorities(user.getAuthentication()));
		} catch(Exception e){
			throw new UsernameNotFoundException("User not found");
		}
	}
	
	private Set<GrantedAuthority> getAuthorities(Authentication authentication){
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for(Role role: authentication.getRoles()){
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getAuthority());
			authorities.add(grantedAuthority);
		}
		return authorities;
	}
}
