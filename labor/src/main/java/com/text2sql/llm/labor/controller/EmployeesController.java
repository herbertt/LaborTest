package com.text2sql.llm.labor.controller;

import com.text2sql.llm.labor.business.abstracts.EmployeeService;
import com.text2sql.llm.labor.business.requests.employees.CreateEmployeeRequest;
import com.text2sql.llm.labor.business.requests.employees.DeleteEmployeeRequest;
import com.text2sql.llm.labor.business.requests.employees.UpdateEmployeeRequest;
import com.text2sql.llm.labor.business.responses.employees.EmployeeGetResponse;
import com.text2sql.llm.labor.business.responses.employees.EmployeeListResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	private EmployeeService employeeService;

	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmployeeListResponse>> getAll(){
		return this.employeeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateEmployeeRequest createEmployeeRequest) {
		return this.employeeService.add(createEmployeeRequest);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteEmployeeRequest deleteEmployeeRequest) {
		return this.employeeService.delete(deleteEmployeeRequest);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
		return this.employeeService.update(updateEmployeeRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<EmployeeGetResponse> getById(@RequestParam int id) {
		return this.employeeService.getById(id);
	}
}
