package br.com.omnilink.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.omnilink.category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
