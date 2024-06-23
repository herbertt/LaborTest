package com.text2sql.llm.labor.business.concretes;

import com.text2sql.llm.labor.business.abstracts.EmployeeService;
import com.text2sql.llm.labor.business.requests.employees.CreateEmployeeRequest;
import com.text2sql.llm.labor.business.requests.employees.DeleteEmployeeRequest;
import com.text2sql.llm.labor.business.requests.employees.UpdateEmployeeRequest;
import com.text2sql.llm.labor.business.responses.employees.EmployeeGetResponse;
import com.text2sql.llm.labor.business.responses.employees.EmployeeListResponse;
import com.text2sql.llm.labor.entities.Employee;
import com.text2sql.llm.labor.repository.EmployeeRepository;
import com.text2sql.llm.labor.utils.mapping.ModelMapperService;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;
import com.text2sql.llm.labor.utils.results.SuccessDataResult;
import com.text2sql.llm.labor.utils.results.SuccessResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class EmployeeManager implements EmployeeService {
	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;
	
	public EmployeeManager(EmployeeRepository employeeRepository, ModelMapperService modelMapperService) {
		this.employeeRepository = employeeRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateEmployeeRequest createEmployeeRequest) {
		Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);	
		return new SuccessResult("Added");
	}

	@Override
	public Result delete(DeleteEmployeeRequest deleteEmployeeRequest) {
		this.employeeRepository.deleteById(deleteEmployeeRequest.getEmployeeId());
		return new SuccessResult("Deleted");
	}

	@Override
	public Result update(UpdateEmployeeRequest updateEmployeeRequest) {
		Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		
		return new SuccessResult("Updated");
	}

	@Override
	public DataResult<EmployeeGetResponse> getById(int id) {
		Employee employee = this.employeeRepository.findById(id).get();
		EmployeeGetResponse response = this.modelMapperService.forResponse().map(employee, EmployeeGetResponse.class);
		return new SuccessDataResult<>(response);
	}
	
	@Override
	public DataResult<List<EmployeeListResponse>> getAll() {
		List<Employee> result = this.employeeRepository.findAll();
		List<EmployeeListResponse> responses = result.stream().map(employee -> this.modelMapperService.forResponse()
				.map(employee, EmployeeListResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<>(responses);
	}

	
}
