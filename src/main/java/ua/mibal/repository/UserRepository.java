package ua.mibal.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.mibal.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Repository
public class UserRepository {
	private static final Logger log = LoggerFactory.getLogger(UserRepository.class);
	private final List<User> users = new ArrayList<>();
	private int counter = 0;

	public void addBestLecturers() {
		User mike = new User();
		mike.setId(++counter);
		mike.setName("Mykhailo");

		User alex = new User();
		alex.setId(++counter);
		alex.setName("Alex");

		users.add(mike);
		users.add(alex);
		
		log.info("Best lecturers added: {}", users);
	}

	public List<User> getAllUsers() {
		log.info("All users: {}", users);
		return users;
	}

	public User getUserById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				log.info("User found: {}", user);
				return user;
			}
		}
		return null;
	}

	public User addUser(User user) {
		user.setId(++counter);
		users.add(user);
		log.info("User added: {}", user);
		return user;
	}

	public User updateUser(User user) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId()) {
				users.set(i, user);
				log.info("User updated: {}", user);
				return users.get(i);
			}
		}
		return null;
	}
	
	public void deleteUser(int id) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				log.info("User deleted: {}", users.get(i));
				users.remove(i);
				return;
			}
		}
	}
}
