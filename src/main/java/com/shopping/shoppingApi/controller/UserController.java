package com.shopping.shoppingApi.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shoppingApi.dto.UserDTO;
import com.shopping.shoppingApi.entitie.User;
import com.shopping.shoppingApi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());

	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id, @RequestBody @Valid UserDTO userDTO) {
		Optional<User> userOptional = userService.findById(id);
		if (userOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
		}
		var user = userOptional.get();
		user.setAdress(userDTO.getAdress());
		user.setEmail(userDTO.getEmail());
		user.setPhone(user.getPhone());
		return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findByIdUser(@PathVariable(value = "id") UUID id) {
		Optional<User> userOptional = userService.findById(id);
		if (userOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
	}

	@GetMapping("/search")
	public ResponseEntity<List<UserDTO>> queryByName(@RequestParam(name = "name", required = true) String name) {
		return ResponseEntity.ok().body(userService.queryByName(name));

	}

	@PostMapping
	public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDTO userDTO) {
		var user = new User();
		BeanUtils.copyProperties(userDTO, user);
		user.setDateRegister(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteByUserId(@PathVariable(value = "id") UUID id) {
		Optional<User> userOptional = userService.findById(id);
		if (userOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
		}
		userService.delete(userOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
	}

}
