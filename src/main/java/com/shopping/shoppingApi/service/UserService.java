package com.shopping.shoppingApi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopping.shoppingApi.dto.UserDTO;
import com.shopping.shoppingApi.entitie.User;
import com.shopping.shoppingApi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Page<User> getAllUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
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

	public User findByCpf(String cpf) {
		return userRepository.findByCpf(cpf);
	}

	public List<User> queryByName(String name) {
		return userRepository.queryByNameLike(name);
	}

	public Optional<User> findById(UUID id) {
		return userRepository.findById(id);
	}
}
