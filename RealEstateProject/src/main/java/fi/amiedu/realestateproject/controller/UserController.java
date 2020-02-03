package fi.amiedu.realestateproject.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import fi.amiedu.realestateproject.service.UserService;

//http://localhost:8080/users
//http://localhost:8080/users/service
//http://localhost:8080/users/admin
//http://localhost:8080/users/seeker

	@RestController
	public class UserController {

		@Autowired // Using services
		private UserService userService;
		
		@RequestMapping(method = RequestMethod.GET, 
				value = "/users",
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Map<String,String> getUsers() {
			return userService.getUsers();
		}
	
		@RequestMapping(method = RequestMethod.GET, // HTTP GET
				value = "/user/service", 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ArrayList<String> getServiceUsers(String type) {
			type = "service";
			userService.getTypeUsers(type);
		return userService.getTypeUsers(type);
		}
		
		@RequestMapping(method = RequestMethod.GET, 
				value = "/user/admin", 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ArrayList<String> getAdminUsers(String type) {
			type = "admin";
			userService.getTypeUsers(type);
		return userService.getTypeUsers(type);
		}
		
		@RequestMapping(method = RequestMethod.GET, 
				value = "/user/seeker",
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ArrayList<String> getSeekerUsers(String type) {
			type = "seeker";
			userService.getTypeUsers(type);
		return userService.getTypeUsers(type);
		}
		
		@RequestMapping(method = RequestMethod.GET, 
				value = "/user/{type}",
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ArrayList<String> getOtherUsers(String type) {
		
			userService.getTypeUsers(type);
		return userService.getTypeUsers(type);
		}
		
//		User userx = new User("service","Sisko","S1sk0111+");
//		@RequestMapping(method = RequestMethod.POST, 
//				value = "/users",
//				produces = MediaType.APPLICATION_JSON_VALUE)
//				public Map<String,String> addUser(User userx) {
//			return userService.addUser(userx);
//		}
		
	
}
