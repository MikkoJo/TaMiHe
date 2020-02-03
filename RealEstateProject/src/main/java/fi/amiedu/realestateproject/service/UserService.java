package fi.amiedu.realestateproject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import fi.amiedu.realestateproject.domain.User;

@Component
public class UserService {

	private Map<String, String> logUsers = getUsers();
	

//		List<User> users = new ArrayList<User>(Arrays.asList(
//		 new User("service", "Tapsa", "Tap10123#"),
//		 new User("admin", "Mikko", "M1kk0456¤"),
//		 new User("service", "Heidi", "He1d1789%"),
//		new User("seeker", "ServiceUser1", "sdfjkdfjl335%"),
//		new User("seeker", "Matti Meikäläinen", "Masa123%")));
//
//		public Map<String, String> getUsers() {
//			HashMap<String, String> userDetails = new HashMap<String, String>();
////		for (User user: users) {
////			userDetails.put(user.getName(),user.getType());
////		}
//		userDetails.put("Oipat","service");
//				return userDetails;
//		}

	public Map<String, String> getUsers() {
		HashMap<String, String> users = new HashMap<String, String>();
		User user1 = new User("service", "Tapsa", "Tap10123#");
		User user2 = new User("admin", "Mikko", "M1kk0456¤");
		User user3 = new User("service", "Heidi", "He1d1789%");
		User user4 = new User("seeker", "ServiceUser1", "sdfjkdfjl335%");
		User user5 = new User("seeker", "Matti Meikäläinen", "Masa123%");
		users.put(user1.getName(),user1.getType());
		users.put(user2.getName(),user2.getType());
		users.put(user3.getName(),user3.getType());
		users.put(user4.getName(),user4.getType());
		users.put(user5.getName(),user5.getType());
		return users;
	}
	
	public ArrayList<String> getTypeUsers(String type) {
		Map<String, String> users = getUsers();
		Set<Map.Entry<String, String>> entryUsers = users.entrySet();
		ArrayList<String> typeUsers = new ArrayList<String>();

		for (Map.Entry<String, String> user : entryUsers) {
			if (user.getValue().equals("service")&&(type=="service")) {
				typeUsers.add(user.getKey());
			} else if (user.getValue().equals("admin")&&(type=="admin")) {
				typeUsers.add(user.getKey());
			} else if (user.getValue().equals("seeker")&&(type=="seeker")) {
				typeUsers.add(user.getKey());
			} else if(!(type=="service")&&!(type=="admin")&&!(type=="seeker")) {
				typeUsers.add("This is not in use!");
				break;}
			}
	return typeUsers;
	}
	
//	public Map<String,String> addUser(User user){
//		logUsers.put(user.getName(),user.getType());
//		return logUsers;
//	}
	
	//public setPassworh(type, name, password)



//	public Map<String,Map<String,String>> setUser(String user, String password, String type) {
//		logUsers.put(user, password);
//		for( Map users : logUsers) {
//			infoUsers = keySet
//		}
//		return }

//		public Map<String> setUser(String user, String password, String type) {
//			if (!(type == "service user") || !(type == "administrator"))
//				type = "watcher";
//			logUsers.put(user, password);
//			
//			for( Map users : logUsers) {
//			logUsers.keySet();
//			}

//	public void print() {
//		System.out.println(getUsers());
//	}

}
