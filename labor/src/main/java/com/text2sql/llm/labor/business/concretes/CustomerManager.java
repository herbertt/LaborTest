package com.text2sql.llm.labor.business.concretes;

import com.text2sql.llm.labor.business.abstracts.CustomerService;
import com.text2sql.llm.labor.business.requests.customers.CreateCustomerRequest;
import com.text2sql.llm.labor.business.requests.customers.DeleteCustomerRequest;
import com.text2sql.llm.labor.business.requests.customers.UpdateCustomerRequest;
import com.text2sql.llm.labor.business.responses.customers.CustomerGetResponse;
import com.text2sql.llm.labor.business.responses.customers.CustomerListResponse;
import com.text2sql.llm.labor.entities.Customer;
import com.text2sql.llm.labor.repository.CustomerRepository;
import com.text2sql.llm.labor.utils.mapping.ModelMapperService;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;
import com.text2sql.llm.labor.utils.results.SuccessDataResult;
import com.text2sql.llm.labor.utils.results.SuccessResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class CustomerManager implements CustomerService {
	private CustomerRepository customerRepository;
	private ModelMapperService modelMapperService;
	
	public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelMapperService) {
		this.customerRepository = customerRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateCustomerRequest createCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
		
		return new SuccessResult("Added");
	}

	@Override
	public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
		this.customerRepository.deleteById(deleteCustomerRequest.getCustomerId());
		
		return new SuccessResult("Deleted");
	}

	@Override
	public Result update(UpdateCustomerRequest updateCustomerRequest) {
		Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
		
		return new SuccessResult("Updated");
	}

	@Override
	public DataResult<CustomerGetResponse> getById(String customerId) {
		Customer customer = this.customerRepository.findById(customerId).get();
		CustomerGetResponse response = this.modelMapperService.forResponse().map(customer, CustomerGetResponse.class);
		return new SuccessDataResult<CustomerGetResponse>(response);
	}
	
	@Override
	public DataResult<List<CustomerListResponse>> getAll() {
		List<Customer> result = this.customerRepository.findAll();
		List<CustomerListResponse> responses = result.stream().map(customer -> this.modelMapperService.forResponse()
				.map(customer, CustomerListResponse.class)).collect(Collectors.toList());
				
		return new SuccessDataResult<List<CustomerListResponse>>(responses);
	}
	
}
