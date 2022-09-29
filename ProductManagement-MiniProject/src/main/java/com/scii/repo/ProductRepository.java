package com.scii.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.scii.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
	@Query("UPDATE Product SET prodCode=:code WHERE prodId=:id")
	public void updateProductCodeById(String code,Integer id);
}
