package br.com.omnilink.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.omnilink.category.dto.CategoryRequest;
import br.com.omnilink.category.dto.CategoryResponse;
import br.com.omnilink.category.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repositoryCategory;
	
	public CategoryResponse createCategory(CategoryRequest categoryRequest) {
		return new CategoryResponse(repositoryCategory.save(categoryRequest.toCategory()));
	}
}
