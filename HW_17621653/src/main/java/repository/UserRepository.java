package repository;

import java.util.Set;
import java.util.TreeSet;

import model.User;

public class UserRepository {
	private static Set<User> users = new TreeSet<>();

	public UserRepository() {
	}

	public static void addUser(User user) {
		users.add(user);
	}

	public static User getUser(User user) {
		for (User repoUser : users) {
			if (repoUser.getEmail().equals(user.getEmail()) 
					&& repoUser.getPassword().equals(user.getPassword()))
				return repoUser;
		}
		return null;
	}

	public static boolean contains(User user) {
		for (User repoUser : users) {
			if (repoUser.equals(user))
				return true;
		}
		return false;
	}
}
