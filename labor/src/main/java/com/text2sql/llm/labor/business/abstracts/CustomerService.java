package com.text2sql.llm.labor.business.abstracts;

import com.text2sql.llm.labor.business.requests.customers.CreateCustomerRequest;
import com.text2sql.llm.labor.business.requests.customers.DeleteCustomerRequest;
import com.text2sql.llm.labor.business.requests.customers.UpdateCustomerRequest;
import com.text2sql.llm.labor.business.responses.customers.CustomerGetResponse;
import com.text2sql.llm.labor.business.responses.customers.CustomerListResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;

import java.util.List;


public interface CustomerService {
	Result add(CreateCustomerRequest createCustomerRequest);
	Result delete(DeleteCustomerRequest deleteCustomerRequest);
	Result update(UpdateCustomerRequest updateCustomerRequest);
	DataResult<CustomerGetResponse> getById(String customerId);
	DataResult<List<CustomerListResponse>> getAll();
}
