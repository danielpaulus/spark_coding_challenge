package de.codingchallenge.controllers;

import de.codingchallenge.model.Category;
import de.codingchallenge.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
class CategoryController {

	private final CategoryRepository categoryRepository;

	@Autowired
	CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@RequestMapping("/category")
	List<Category> categories() {
		return categoryRepository.findAll();
	}
}
