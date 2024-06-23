package com.text2sql.llm.labor.controller;

import com.text2sql.llm.labor.business.abstracts.CustomerService;
import com.text2sql.llm.labor.business.requests.customers.CreateCustomerRequest;
import com.text2sql.llm.labor.business.requests.customers.DeleteCustomerRequest;
import com.text2sql.llm.labor.business.requests.customers.UpdateCustomerRequest;
import com.text2sql.llm.labor.business.responses.customers.CustomerGetResponse;
import com.text2sql.llm.labor.business.responses.customers.CustomerListResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/customers")
public class CustomersController {
	private CustomerService customerService;

	public CustomersController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateCustomerRequest createCustomerRequest) {
		return this.customerService.add(createCustomerRequest);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteCustomerRequest deleteCustomerRequest) {
		return this.customerService.delete(deleteCustomerRequest);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
		return this.customerService.update(updateCustomerRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CustomerGetResponse> getById(@RequestParam String customerId) {
		return this.customerService.getById(customerId);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CustomerListResponse>> getAll(){
		return this.customerService.getAll();
	}
}
