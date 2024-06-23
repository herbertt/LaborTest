package com.text2sql.llm.labor.business.abstracts;

import com.text2sql.llm.labor.business.requests.suppliers.CreateSupplierRequest;
import com.text2sql.llm.labor.business.requests.suppliers.DeleteSupplierRequest;
import com.text2sql.llm.labor.business.requests.suppliers.UpdateSupplierRequest;
import com.text2sql.llm.labor.business.responses.suppliers.SupplierGetResponse;
import com.text2sql.llm.labor.business.responses.suppliers.SupplierListResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;

import java.util.List;



public interface SupplierService {
	Result add(CreateSupplierRequest createSupplierRequest);
	Result delete(DeleteSupplierRequest deleteSupplierRequest);
	Result update(UpdateSupplierRequest updateSupplierRequest);
	DataResult<SupplierGetResponse> getById(int id);
	DataResult<List<SupplierListResponse>> getAll();
}
