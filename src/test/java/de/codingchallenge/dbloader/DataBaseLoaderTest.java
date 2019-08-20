package de.codingchallenge.dbloader;

import de.codingchallenge.model.Category;
import de.codingchallenge.model.Question;
import de.codingchallenge.model.Survey;
import de.codingchallenge.repository.CategoryRepository;
import de.codingchallenge.repository.QuestionRepository;
import de.codingchallenge.repository.SurveyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DataBaseLoaderTest {

	@Mock CategoryRepository categoryRepository;
	@Mock QuestionRepository questionRepository;
	@Mock SurveyRepository surveyRepository;

	@Captor ArgumentCaptor<List<Category>> categoryCaptor;
	@Captor ArgumentCaptor<List<Question>> questionCaptor;
	private DataBaseLoader dataBaseLoader;

	@BeforeEach
	void setUp() {
		dataBaseLoader = new DataBaseLoader(categoryRepository, questionRepository, surveyRepository);
		dataBaseLoader.seedDb = true;
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

	@Test
	void if_survey_is_saved() throws Exception {
		dataBaseLoader.run();
		verify(surveyRepository, times(1)).save(any(Survey.class));
	}
}