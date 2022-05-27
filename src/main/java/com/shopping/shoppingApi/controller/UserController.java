package com.shopping.shoppingApi.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<UserDTO> users = userService.getAll();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<UserDTO> findByCpf(@PathVariable String cpf) {
		return ResponseEntity.ok().body(userService.findByCpf(cpf));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(userService.findById(id));
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
	public void deleteUser(@PathVariable Long id) {
		userService.delete(id);
	}

}
