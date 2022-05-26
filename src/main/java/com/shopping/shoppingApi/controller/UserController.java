package com.shopping.shoppingApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shoppingApi.dto.UserDTO;
import com.shopping.shoppingApi.service.UserService;

@RestController()
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<UserDTO> users = userService.getAll();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/user/{cpf}")
	public ResponseEntity<UserDTO> findByCpf(@PathVariable String cpf) {
		return ResponseEntity.ok().body(userService.findByCpf(cpf));
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}

	@GetMapping("/user/search")
	public ResponseEntity<List<UserDTO>> queryByName(@RequestParam(name = "name", required = true) String name) {
		return ResponseEntity.ok().body(userService.queryByName(name));

	}

	@PostMapping("/user")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
		return ResponseEntity.ok().body(userService.save(userDTO));
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.delete(id);
	}

}
