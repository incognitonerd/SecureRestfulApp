package com.securerestfulservices.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.securerestfulservices.dto.entities.security.UserCountDto;
import com.securerestfulservices.dto.entities.security.UserDto;
import com.securerestfulservices.dto.entities.security.UserList;
import com.securerestfulservices.repositories.UserDetailRepository;
import com.securerestfulservices.security.domains.UserDetail;

@Service
public class UserManagedService {
	@Autowired
	private UserDetailRepository userRepository;
	// @Autowired
	// private RoleRepository roleRepository;
	
	public UserCountDto count(){
		return new UserCountDto(userRepository.count());
	}
	
	public UserList findAllUsers(){
		Iterable<UserDetail> users = userRepository.findAll();
		if(users == null){
			return new UserList();
		}
		List<UserDto> dtos = new ArrayList<UserDto>();
		for(UserDetail user: users){
			dtos.add(new UserDto(user));
		}
		return new UserList(dtos);
	}
	
	public UserDto findById(long id){
		UserDetail user = userRepository.findOne(id);
		UserDto userDto = null;
		if(user != null){
			userDto = new UserDto(user);
		}
		return userDto;
	}
	
	public UserDto findByUsername(String username){
		return new UserDto(userRepository.findByUsername(username));
	}
	/*
	 * public void saveUser(AuthenticationDto userDto){ Set<Role> roles = new HashSet<Role>(); for(RoleConstants role: userDto.getAuthorites()){ roles.add(roleRepository.findByAuthority(role.getRole())); }
	 * userRepository.save(userDto.buildUser(roles)); }
	 */
	/*
	 * public void updateUser(UserDto currentUser, UserDto user){ currentUser.setName(user.getName()); currentUser.setAge(user.getAge()); userRepository.save(currentUser.buildUser()); }
	 */
	/*
	 * public void deleteUserById(long id){ userRepository.delete(id); }
	 */
	/*
	 * public void deleteAllUsers(){ userRepository.deleteAll(); }
	 */
}
