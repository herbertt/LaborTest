package com.text2sql.llm.labor.repository;

import java.util.List;

import com.text2sql.llm.labor.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer>{
	Product getByProductName(String productName);
}
