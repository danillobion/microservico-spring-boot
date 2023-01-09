package br.com.omnilink.category.dto;

import br.com.omnilink.category.model.Category;
import lombok.Data;

@Data
public class CategoryRequest {
	private long id;
	private String name;
	
	public Category toCategory() {
		Category category = Category.builder().id(id).name(name).build();
		return category;
	}
}
