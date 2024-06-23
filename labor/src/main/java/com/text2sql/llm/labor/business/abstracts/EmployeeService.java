package com.text2sql.llm.labor.business.abstracts;

import com.text2sql.llm.labor.business.requests.employees.CreateEmployeeRequest;
import com.text2sql.llm.labor.business.requests.employees.DeleteEmployeeRequest;
import com.text2sql.llm.labor.business.requests.employees.UpdateEmployeeRequest;
import com.text2sql.llm.labor.business.responses.employees.EmployeeGetResponse;
import com.text2sql.llm.labor.business.responses.employees.EmployeeListResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;

import java.util.List;


public interface EmployeeService {
	Result add(CreateEmployeeRequest createEmployeeRequest);
	Result delete(DeleteEmployeeRequest deleteEmployeeRequest);
	Result update(UpdateEmployeeRequest updateEmployeeRequest);
	DataResult<EmployeeGetResponse> getById(int id);
	DataResult<List<EmployeeListResponse>> getAll();
}
