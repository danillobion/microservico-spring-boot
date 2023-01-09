package br.com.omnilink.category.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.omnilink.category.dto.CategoryRequest;
import br.com.omnilink.category.dto.CategoryResponse;
import br.com.omnilink.category.service.CategoryService;

@Service
public class Facade {
	@Autowired
	private CategoryService categoryService;
	
	public CategoryResponse createCategory(CategoryRequest categoryRequest) {
		return categoryService.createCategory(categoryRequest);
	}

}
