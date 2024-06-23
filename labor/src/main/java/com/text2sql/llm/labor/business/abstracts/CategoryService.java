package com.text2sql.llm.labor.business.abstracts;

import com.text2sql.llm.labor.business.requests.categories.CreateCategoryRequest;
import com.text2sql.llm.labor.business.requests.categories.DeleteCategoryRequest;
import com.text2sql.llm.labor.business.requests.categories.UpdateCategoryRequest;
import com.text2sql.llm.labor.business.responses.categories.CategoryGetResponse;
import com.text2sql.llm.labor.business.responses.categories.CategoryListResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;

import java.util.List;



public interface CategoryService {
	Result add(CreateCategoryRequest createCategoryRequest);
	Result delete(DeleteCategoryRequest deleteCategoryRequest);
	Result update(UpdateCategoryRequest updateCategoryRequest);
	DataResult<CategoryGetResponse> getById(int id);
	DataResult<List<CategoryListResponse>> getAll();
}
