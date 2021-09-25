package com.relationship.oneone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relationship.oneone.Dao.UserDao;
import com.relationship.oneone.entitys.User;

@RestController
@RequestMapping("users")
public class ControllerUser {
	@Autowired
	private UserDao userDao;

	@GetMapping
	public ResponseEntity<List<User>> userAll() {
		List<User> listUser = userDao.findAll();
		return ResponseEntity.ok(listUser);

	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = userDao.save(user);
		return ResponseEntity.ok(newUser);

	}

	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {

		Optional<User> pastUser = userDao.findById(user.getId());
		if (pastUser.isPresent()) {
			User userUpdate = pastUser.get();
			userUpdate.setEdad(user.getEdad());
			userUpdate.setNombre(user.getNombre());
			userUpdate.setPais(user.getPais());
			userUpdate.setAddress(user.getAddress());
			userDao.save(userUpdate);
			return ResponseEntity.ok(userUpdate);

		}

		return ResponseEntity.noContent().build();

	}

	@DeleteMapping("{id}")
	public String deleteUser(@PathVariable Long id) {
		if (userDao.findById(id).isPresent()) {
			userDao.deleteById(id);
			return " el user con id " + id + "fue eliminado";
		}

		return " el user con id " + id + "no existee";

	}

	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		if (userDao.findById(id).isPresent()) {
			return ResponseEntity.ok(userDao.findById(id).get());
		}
		return ResponseEntity.noContent().build();

	}

}
