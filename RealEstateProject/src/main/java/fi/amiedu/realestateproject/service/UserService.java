package fi.amiedu.realestateproject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import fi.amiedu.realestateproject.domain.User;

@Component
public class UserService {
	// Logger create to help debugging problems
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	private ArrayList<User> users = new ArrayList<User>(
			Arrays.asList(new User("mikko.johansson@gmail.com", "Mikko#123", "admin")));
	boolean startUp = true;
 
	// This gives the initial users at the startup situation.
	public void getUsers() {
		if (startUp == true) {
			User user1 = new User("Tapsa", "Tap10123#", "service");
			User user2 = new User("Mikko", "M1kk0456¤", "admin");
			User user3 = new User("Heidi", "He1d1789%", "service");
			User user4 = new User("ServiceUser1", "sdfjkdfjl335%", "seeker");
			User user5 = new User("Matti Meikäläinen", "Masa123%", "seeker");
			users.add(user1);
			users.add(user2);
			users.add(user3);
			users.add(user4);
			users.add(user5);
			startUp = false;
		}
	}

	// This actually calls initialization and the list of users
	public List<User> getAllUsers() {
		if (startUp == true) {
			getUsers();
			startUp = false;
		}
		logger.info("getAllUsers: " + users);
		return users;
	}
	
	// Different types of users are checked. Possible values are seeker, service and admin
	public ArrayList<User> getTypeUsers(String type) {
		if (startUp == true) {
			getUsers();
			startUp = false;
		}
		logger.info("getTypeUsers: " + users);
		ArrayList<User> typeUsers = new ArrayList<User>(Arrays.asList());
		logger.info("getTypeUsers:  list at first:" + typeUsers);
		for (User user : users) {
			if ((user.getType().equals("service")) && (type.equals("service"))) {
				typeUsers.add(user);
			} else if ((user.getType().equals("admin")) && (type.equals("admin"))) {
				typeUsers.add(user);
			} else if ((user.getType().equals("seeker")) && (type.equals("seeker"))) {
				typeUsers.add(user);
			} else if (!(type.equals("service")) && !(type.equals("admin")) && !(type.equals("seeker"))) {
				typeUsers.add(new User("This is not in use!", " Sorry about that.", "Be pation my friend."));
				break;
			}
		}
		logger.info("getTypeUsers:  list in the end:" + typeUsers);
		return typeUsers;
	}

	// New user is added in the arraylist of users
	public User addUser(User user) {
		if (startUp == true) {
			getUsers();
			startUp = false;
		}
		boolean found = false;
		for (User user1 : users) {
			if (user1.getName().equals(user.getName())) {
				found = true;
				logger.info("addUser: Can not be same username. Create unique one. And create your account.");
				return new User("Can not be same username", " Create unique one.", "And create your account.");
			}
		}
		if (found == false) {
			users.add(user);
		}
		return user;
	}

	// User role or type is changed if user exists
	public String updateUser(User user) {
		if (startUp == true) {
			getUsers();
			startUp = false;
		}
		boolean found = false;
		for (User user1 : users) {
			if (user1.getName().equals(user.getName())) {
				found = true;
				user1.setType(user.getType());
				logger.info("addUser: Can not be same username. Create unique one. And create your account.");
				return user + " type is updated!";
			}
		}
		return user.getName() + " does not exist.";
	}
}
