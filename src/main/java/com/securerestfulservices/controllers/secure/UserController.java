package com.securerestfulservices.controllers.secure;
import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.securerestfulservices.dto.entities.security.UserDto;
import com.securerestfulservices.dto.entities.security.UserList;
import com.securerestfulservices.dto.responses.AbstractResponseDto;
import com.securerestfulservices.services.UserManagedService;
import com.securerestfulservices.utils.ResponseUtil;

@RestController
@RequestMapping(value = "/securetester")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserManagedService userService; // Service which will do all data retrieval/manipulation work
	
	// http://localhost:8080/securetester/user/profile/
	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> profileDetail(Principal principal){
		LOGGER.info("current username - " + principal.getName());
		UserDto user = userService.findByUsername(principal.getName());
		return ResponseUtil.success().body(user).send(HttpStatus.OK);
	}
	
	// http://localhost:8080/user/count/
	@RequestMapping(value = "/user/count", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> userCout(){
		return ResponseUtil.success().body(userService.count()).send(HttpStatus.OK);
	}
	
	// http://localhost:8080/user/
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public HttpEntity<AbstractResponseDto> listAllUsers(){
		UserList users = userService.findAllUsers();
		if(users.getUserList().isEmpty()){
			return ResponseUtil.error().message("No data found").send(HttpStatus.NOT_FOUND);
		}
		return ResponseUtil.success().body(users).message("User list fetched successfully !!!").send(HttpStatus.OK);
	}
	
	// http://localhost:8080/user/1
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<AbstractResponseDto> getUser(@PathVariable("id") long id){
		UserDto user = userService.findById(id);
		if(user == null){
			return ResponseUtil.error().message("No data found").send(HttpStatus.NOT_FOUND);
		}
		return ResponseUtil.success().body(user).message("User fetched successfully !!!").send(HttpStatus.OK);
	}
	// ******************** Create ******************** // http://localhost:8080/user/
	/*
	 * @RequestMapping(value = "/user/", method = RequestMethod.POST) public ResponseEntity<AbstractResponseDto> createUser(@RequestBody AuthenticationDto user){ userService.saveUser(user); return
	 * ResponseUtil.success().body(user.detail()).message("User created successfully !!!").send(HttpStatus.CREATED); }
	 */
	// ******************** Update ******************** // http://localhost:8080/user/1
	/*
	 * @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT) public ResponseEntity<AbstractResponseDto> updateUser(@PathVariable("id") long id, @RequestBody UserDto user){ UserDto currentUser = userService.findById(id); if(currentUser ==
	 * null){ return ResponseUtil.error().message("User with id " + id + " not found").send(HttpStatus.NOT_FOUND); } userService.updateUser(currentUser, user); return
	 * ResponseUtil.success().body(currentUser).message("User updated successfully !!!").send(HttpStatus.OK); }
	 */
	// ******************** Delete ******************** // http://localhost:8080/user/1
	/*
	 * @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE) public ResponseEntity<AbstractResponseDto> deleteUser(@PathVariable("id") long id){ UserDto user = userService.findById(id); if(user == null){
	 * System.out.println("Unable to delete. User with id " + id + " not found"); return ResponseUtil.error().message("Unable to delete. User with id " + id + " not found") .send(HttpStatus.NOT_FOUND); } userService.deleteUserById(id); return
	 * ResponseUtil.success().body(user).message("User deleted successfully !!!").send(HttpStatus.OK); }
	 */
	// ******************** Delete All ********************
	/*
	 * @RequestMapping(value = "/user/", method = RequestMethod.DELETE) public ResponseEntity<AbstractResponseDto> deleteAllUsers(){ userService.deleteAllUsers(); return ResponseUtil.success().body(new
	 * UserList()).message("All User deleted successfully !!!").send(HttpStatus.OK); }
	 */
}
