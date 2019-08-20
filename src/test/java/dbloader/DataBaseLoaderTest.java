package dbloader;

import model.Category;
import model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.CategoryRepository;
import repository.QuestionRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DataBaseLoaderTest {

	@Mock CategoryRepository categoryRepository;

	@Mock QuestionRepository questionRepository;

	@Captor ArgumentCaptor<List<Category>> categoryCaptor;
	@Captor ArgumentCaptor<List<Question>> questionCaptor;
	private DataBaseLoader dataBaseLoader;

	@BeforeEach
	void setUp() {
		dataBaseLoader = new DataBaseLoader(categoryRepository, questionRepository);
	}

	@Test
	void if_four_categories_are_saved_to_the_repo() throws Exception {
		dataBaseLoader.run();
		verify(categoryRepository, times(1)).saveAll(categoryCaptor.capture());
		assertThat(categoryCaptor.getValue()).hasSize(4);
	}

	@Test
	void if_all_questions_are_parsed() throws Exception {
		dataBaseLoader.run();
		verify(questionRepository, times(1)).saveAll(questionCaptor.capture());
		assertThat(questionCaptor.getValue()).hasSize(25);
	}
}