package com.text2sql.llm.labor.controller;

import com.text2sql.llm.labor.business.abstracts.SupplierService;
import com.text2sql.llm.labor.business.requests.suppliers.CreateSupplierRequest;
import com.text2sql.llm.labor.business.requests.suppliers.DeleteSupplierRequest;
import com.text2sql.llm.labor.business.requests.suppliers.UpdateSupplierRequest;
import com.text2sql.llm.labor.business.responses.suppliers.SupplierGetResponse;
import com.text2sql.llm.labor.business.responses.suppliers.SupplierListResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {
	private SupplierService supplierService;

	public SuppliersController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SupplierListResponse>> getAll(){
		return this.supplierService.getAll();
	}
	
	@PostMapping("/add")
    public Result add(@RequestBody CreateSupplierRequest createSupplierRequest) {
        return this.supplierService.add(createSupplierRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteSupplierRequest deleteSupplierRequest) {
        return this.supplierService.delete(deleteSupplierRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateSupplierRequest updateSupplierRequest) {
        return this.supplierService.update(updateSupplierRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<SupplierGetResponse> getById(@RequestBody int id) {
        return this.supplierService.getById(id);
    }
}
