package com.shopping.shoppingApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.shoppingApi.entitie.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByCpf(String cpf);

	List<User> queryByNameLike(String name);
}
