package br.com.omnilink.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.omnilink.category.dto.CategoryRequest;
import br.com.omnilink.category.dto.CategoryResponse;
import br.com.omnilink.category.facade.Facade;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private Facade facade;
	
	@PostMapping("/create")
	public CategoryResponse create(@RequestBody CategoryRequest category) {
		return facade.createCategory(category);
	}
//	@GetMapping("/find/all")
//	public List<CategoryResponse> categoryAll(){
//		return facade.findAllCategory();
//	}
}