package com.text2sql.llm.labor.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.text2sql.llm.labor.business.abstracts.SupplierService;
import com.text2sql.llm.labor.business.requests.suppliers.CreateSupplierRequest;
import com.text2sql.llm.labor.business.requests.suppliers.DeleteSupplierRequest;
import com.text2sql.llm.labor.business.requests.suppliers.UpdateSupplierRequest;
import com.text2sql.llm.labor.business.responses.suppliers.SupplierGetResponse;
import com.text2sql.llm.labor.business.responses.suppliers.SupplierListResponse;
import com.text2sql.llm.labor.entities.Supplier;
import com.text2sql.llm.labor.repository.SupplierRepository;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.SuccessDataResult;
import org.springframework.stereotype.Service;


import com.text2sql.llm.labor.utils.mapping.ModelMapperService;
import com.text2sql.llm.labor.utils.results.Result;
import com.text2sql.llm.labor.utils.results.SuccessResult;

@Service
public class SupplierManager implements SupplierService {
	private SupplierRepository supplierRepository;
	private ModelMapperService modelMapperService;
	
	public SupplierManager(SupplierRepository supplierRepository, ModelMapperService modelMapperService) {
		this.supplierRepository = supplierRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<SupplierListResponse>> getAll() {
		List<Supplier> result = this.supplierRepository.findAll();
		List<SupplierListResponse> responses = result.stream().map(supplier->this.modelMapperService.forResponse()
				.map(supplier, SupplierListResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<SupplierListResponse>>(responses);
	}

	@Override
	public Result add(CreateSupplierRequest createSupplierRequest) {
		Supplier supplier = this.modelMapperService.forRequest().map(createSupplierRequest, Supplier.class);
		this.supplierRepository.save(supplier);
		
		return new SuccessResult("Added");
	}

	@Override
	public Result delete(DeleteSupplierRequest deleteSupplierRequest) {
		this.supplierRepository.deleteById(deleteSupplierRequest.getSupplierId());
		
		return new SuccessResult("Deleted");
	}

	@Override
	public Result update(UpdateSupplierRequest updateSupplierRequest) {
		Supplier supplier = this.modelMapperService.forRequest().map(updateSupplierRequest, Supplier.class);
		this.supplierRepository.save(supplier);
		
		return new SuccessResult("Added");		
	}

	@Override
	public DataResult<SupplierGetResponse> getById(int id) {
		Supplier supplier = this.supplierRepository.findById(id).get();
		SupplierGetResponse response = this.modelMapperService.forResponse().map(supplier, SupplierGetResponse.class);
		return new SuccessDataResult<SupplierGetResponse>(response);
	}
		
}
