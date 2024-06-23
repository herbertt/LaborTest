package com.text2sql.llm.labor.repository;

import com.text2sql.llm.labor.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
