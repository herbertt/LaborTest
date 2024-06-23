package com.text2sql.llm.labor.controller;

import com.text2sql.llm.labor.business.abstracts.ProductService;
import com.text2sql.llm.labor.business.requests.products.CreateProductRequest;
import com.text2sql.llm.labor.business.requests.products.DeleteProductRequest;
import com.text2sql.llm.labor.business.requests.products.UpdateProductRequest;
import com.text2sql.llm.labor.business.responses.products.ProductGetResponse;
import com.text2sql.llm.labor.business.responses.products.ProductListResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping( "/getall")
	public DataResult<List<ProductListResponse>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
    public Result add(@RequestBody @Valid CreateProductRequest createProductRequest) {
        return this.productService.add(createProductRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteProductRequest deleteProductRequest) {
        return this.productService.delete(deleteProductRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateProductRequest updateProductRequest) {
        return this.productService.update(updateProductRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<ProductGetResponse> getById(@RequestBody int id) {
        return this.productService.getById(id);
    }
    
    @GetMapping("/getallbypage")
	public DataResult<List<ProductListResponse>> getAll(@RequestParam int pageNo,int pageSize){
		return this.productService.getAll(pageNo,pageSize);
	}
	
	@GetMapping("/getallsortedbyasc")
	public DataResult<List<ProductListResponse>> getAllSortedByAsc(@RequestParam String field){
		return this.productService.getAllSortedByAsc(field);
	}
	
	@GetMapping("/getallsortedbydesc")
	public DataResult<List<ProductListResponse>> getAllSortedByDesc(@RequestParam String field){
		return this.productService.getAllSortedByDesc(field);
	}
}
