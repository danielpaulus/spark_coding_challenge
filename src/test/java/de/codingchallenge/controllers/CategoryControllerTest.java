package de.codingchallenge.controllers;

import de.codingchallenge.model.Category;
import de.codingchallenge.repository.CategoryRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CategoryControllerTest {
	private final List<Category> categoriesFixture = Lists.list(new Category("1"), new Category("2"), new Category("3"));
	@Mock CategoryRepository categoryRepository;
	private CategoryController categoryController;

	@BeforeEach
	void setUp() {
		categoryController = new CategoryController(categoryRepository);
	}

	@Test
	void if_all_categories_are_returned() {
		when(categoryRepository.findAll()).thenReturn(categoriesFixture);
		assertThat(categoryController.categories()).containsAll(categoriesFixture);
	}
}