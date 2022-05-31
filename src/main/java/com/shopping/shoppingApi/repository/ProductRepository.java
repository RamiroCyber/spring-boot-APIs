package com.shopping.shoppingApi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopping.shoppingApi.entitie.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

	@Query(value = "select p.name, p.price, p.description" + "from product p"
			+ "join category c on p.category.id = c.id" + "where.id = :categoryId")
	public List<Product> getProductByCategory(@Param("categoryId") UUID categoryId);
	
	boolean existsByproduct(String name, String model, String maanufacturer);
	

}
