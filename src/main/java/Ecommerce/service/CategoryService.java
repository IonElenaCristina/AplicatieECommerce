package Ecommerce.service;


import Ecommerce.dto.ProductDto;
import Ecommerce.model.Category;
import Ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryRepository categoryrepository;

	public List<Category> listCategories() {
		return categoryrepository.findAll();
	}

	public void createCategory(Category category) {
		categoryrepository.save(category);
	}

	public void updateCategory(Integer categoryId, Category category) {
		Category categoryToUpdate = categoryrepository.findById(categoryId).orElseThrow(NoSuchElementException::new);
		categoryToUpdate.setCategoryName(category.getCategoryName());
		categoryToUpdate.setImageUrl(category.getImageUrl());
		categoryToUpdate.setDescription(category.getDescription());
		categoryrepository.save(categoryToUpdate);
	}
	public boolean isCategoryPresent(ProductDto productDto) {
		return categoryrepository.findById(productDto.getCategoryId()).isPresent();
	}
}
