package com.text2sql.llm.labor.repository;

import java.util.List;

import com.text2sql.llm.labor.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
