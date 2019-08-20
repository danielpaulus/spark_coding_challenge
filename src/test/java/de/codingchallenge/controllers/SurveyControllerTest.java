package de.codingchallenge.controllers;

import de.codingchallenge.model.Question;
import de.codingchallenge.model.Survey;
import de.codingchallenge.repository.SurveyRepository;
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
class SurveyControllerTest {

	@Mock SurveyRepository surveyRepository;
	private SurveyController surveyController;
	private List<Survey> surveyFixture = Lists.list(
			new Survey(Lists.list(new Question("bla", null, null))),
			new Survey(Lists.list(new Question("bla2", null, null))));

	@BeforeEach
	void setUp() {
		surveyController = new SurveyController(surveyRepository);
	}

	@Test
	void if_all_categories_are_returned() {
		when(surveyRepository.findAll()).thenReturn(surveyFixture);
		assertThat(surveyController.listSurveys()).containsAll(surveyFixture);
	}
}