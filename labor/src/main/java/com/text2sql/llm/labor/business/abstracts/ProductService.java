package com.text2sql.llm.labor.business.abstracts;

import com.text2sql.llm.labor.business.requests.products.CreateProductRequest;
import com.text2sql.llm.labor.business.requests.products.DeleteProductRequest;
import com.text2sql.llm.labor.business.requests.products.UpdateProductRequest;
import com.text2sql.llm.labor.business.responses.products.ProductGetResponse;
import com.text2sql.llm.labor.business.responses.products.ProductListResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;

import java.util.List;



public interface ProductService {
	Result add(CreateProductRequest createProductRequest);
	Result delete(DeleteProductRequest deleteProductRequest);
	Result update(UpdateProductRequest updateProductRequest);
	DataResult<ProductGetResponse> getById(int id);
	DataResult<List<ProductListResponse>> getAll();
	DataResult<List<ProductListResponse>> getAll(int pageNo, int pageSize);
	DataResult<List<ProductListResponse>> getAllSortedByAsc(String field );
	DataResult<List<ProductListResponse>> getAllSortedByDesc(String field );
}
