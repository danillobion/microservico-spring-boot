package br.com.omnilink.category.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CategoryPage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long category_id;
	private long page_id;
}
