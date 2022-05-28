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

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public boolean existsByCpf(String cpf) {
		return userRepository.existsByCpf(cpf);
	}

	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Transactional
	public User save(User user) {
		return userRepository.save(user);

	}

	@Transactional
	public void delete(User user) {
		userRepository.delete(user);
	}

	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);

		return null;
	}

	public List<UserDTO> queryByName(String name) {
		List<User> users = userRepository.queryByNameLike(name);
		return null;
	}

	public Optional<User> findById(UUID id) {
		return userRepository.findById(id);
	}
}
