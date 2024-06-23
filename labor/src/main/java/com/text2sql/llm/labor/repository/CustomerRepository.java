package com.text2sql.llm.labor.repository;

import com.text2sql.llm.labor.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, String>{

}
