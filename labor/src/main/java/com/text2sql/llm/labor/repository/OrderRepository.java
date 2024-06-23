package com.text2sql.llm.labor.repository;

import com.text2sql.llm.labor.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Integer> {

}
