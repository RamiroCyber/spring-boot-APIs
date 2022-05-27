package com.shopping.shoppingApi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.shoppingApi.dto.UserDTO;
import com.shopping.shoppingApi.entitie.User;
import com.shopping.shoppingApi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> getAll() {
		List<User> allUsers = userRepository.findAll();
		return allUsers.stream().map(UserDTO::convert).collect(Collectors.toList());
	}

	public UserDTO findById(UUID id) {
		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			return UserDTO.convert(user.get());
		}
		return null;
	}

	@Transactional
	public User save(User user) {
		return userRepository.save(user);

	}

	public void delete(UUID id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.delete(user.get());
		}
	}

	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		if (user != null) {
			return UserDTO.convert(user);
		}
		return null;
	}

	public List<UserDTO> queryByName(String name) {
		List<User> users = userRepository.queryByNameLike(name);
		return users.stream().map(UserDTO::convert).collect(Collectors.toList());
	}
}
