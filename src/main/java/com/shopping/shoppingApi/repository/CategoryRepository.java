package com.shopping.shoppingApi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.shoppingApi.entitie.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
