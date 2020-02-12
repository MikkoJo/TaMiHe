  
package fi.amiedu.realestateproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.amiedu.realestateproject.domain.User;
import fi.amiedu.realestateproject.service.UserService;

//http://localhost:8080/users
//http://localhost:8080/users/{type}           // {type} = seeker, service, admin

	@RestController
	public class UserController {

		@Autowired // Using services
		private UserService userService;
		
		// get all users
		//http://localhost:8080/users
		@RequestMapping(method = RequestMethod.GET, // HTTP GET
				value = "/users",
				produces = MediaType.APPLICATION_JSON_VALUE)
		public List<User> getAllUsers() {
				return userService.getAllUsers();
		}
		
		// call out all user of specific type
		//http://localhost:8080/users/{type} 
		@RequestMapping(method = RequestMethod.GET, 
				value = "/users/{type}", 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ArrayList<User> getTypeUsers(@PathVariable String type) {
		return userService.getTypeUsers(type);
		}
		
		// create new user with unique username
		@RequestMapping(method = RequestMethod.POST, 
				value = "/users", 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public User addUser(@RequestBody User user) {

		return userService.addUser(user);
		}
		
		// update the rolr or type of user with unique username
		@RequestMapping(method = RequestMethod.PUT, 
				value = "/users", 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public String updateUser(@RequestBody User user) {
		return userService.updateUser(user);
		}
}