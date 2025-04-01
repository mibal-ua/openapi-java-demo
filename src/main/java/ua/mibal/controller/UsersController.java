package ua.mibal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ua.mibal.api.UsersApi;
import ua.mibal.model.User;
import ua.mibal.repository.UserRepository;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@RestController
public class UsersController implements UsersApi {
	private final UserRepository userRepository;

	public UsersController(UserRepository userRepository) {
		this.userRepository = userRepository;
		userRepository.addBestLecturers();
	}

	@Override
	public ResponseEntity<List<User>> usersGet() {
		return ResponseEntity.ofNullable(userRepository.getAllUsers());
	}

	@Override
	public ResponseEntity<User> usersPost(User user) {
		return ResponseEntity.ofNullable(userRepository.addUser(user));
	}

	@Override
	public ResponseEntity<User> usersIdGet(Integer id) {
		return ResponseEntity.ofNullable(userRepository.getUserById(id));
	}

	@Override
	public ResponseEntity<Void> usersIdDelete(Integer id) {
		userRepository.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<User> usersIdPut(Integer id, User user) {
		user.setId(id);
		return ResponseEntity.ofNullable(userRepository.updateUser(user));
	}
}
