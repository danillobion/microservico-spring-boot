package br.com.omnilink.category.dto;

import br.com.omnilink.category.model.Category;
import lombok.Data;

@Data
public class CategoryResponse {
	private long id;
	private String name;
	
	public CategoryResponse(Category c) {
		this.id = c.getId();
		this.name = c.getName();
	}
}
