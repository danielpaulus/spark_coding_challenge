package de.codingchallenge.service;

import de.codingchallenge.model.*;
import de.codingchallenge.repository.SurveyRepository;
import de.codingchallenge.repository.SurveyResponseRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SurveyResponseServiceTest {

	@Mock private SurveyRepository surveyRepository;
	@Mock private SurveyResponseRepository surveyResponseRepository;

	private List<Survey> surveyFixture = Lists.list(
			new Survey(Lists.list(new Question("bla", new Category("category"), new SingleChoiceQuestionType(Lists.list("1", "2"))))),
			new Survey(Lists.list(new Question("bla2", new Category("category2"), new SingleChoiceQuestionType(Lists.list("1", "2"))))));

	private SurveyResponseService surveyResponseService;

	@BeforeEach
	void setUp() {
		surveyResponseService = new SurveyResponseService(surveyResponseRepository, surveyRepository);
	}

	@Test
	void if_input_is_valid_return_true() {
		when(surveyRepository.findAll()).thenReturn(surveyFixture);
		boolean validate = surveyResponseService.validate(new SurveyResponse(Map.of("q0", 0, "q1", 0)));
		assertThat(validate).isEqualTo(true);
	}

	@Test
	void if_wrong_option_type_in_one_answer_id_invalid() {
		when(surveyRepository.findAll()).thenReturn(surveyFixture);
		boolean validate = surveyResponseService.validate(new SurveyResponse(Map.of("q0", 0, "q1", "s")));
		assertThat(validate).isEqualTo(false);
	}

	@Test
	void if_too_small_option_in_one_answer_id_invalid() {
		when(surveyRepository.findAll()).thenReturn(surveyFixture);
		boolean validate = surveyResponseService.validate(new SurveyResponse(Map.of("q0", 0, "q1", -1)));
		assertThat(validate).isEqualTo(false);
	}

	@Test
	void if_too_many_options_in_one_answer_id_invalid() {
		when(surveyRepository.findAll()).thenReturn(surveyFixture);
		boolean validate = surveyResponseService.validate(new SurveyResponse(Map.of("q0", 0, "q1", 9)));
		assertThat(validate).isEqualTo(false);
	}

	@Test
	void if_too_many_answers_are_invalid() {
		when(surveyRepository.findAll()).thenReturn(surveyFixture);
		boolean validate = surveyResponseService.validate(new SurveyResponse(Map.of("q0", 0, "q1", 0, "q3", 0)));
		assertThat(validate).isEqualTo(false);
	}

	@Test
	void if_too_few_answers_are_invalid() {
		when(surveyRepository.findAll()).thenReturn(surveyFixture);
		boolean validate = surveyResponseService.validate(new SurveyResponse(Collections.singletonMap("q0", 1)));
		assertThat(validate).isEqualTo(false);
	}

	@Test
	void if_empty_response_is_invalid() {
		when(surveyRepository.findAll()).thenReturn(surveyFixture);
		boolean validate = surveyResponseService.validate(new SurveyResponse(Collections.emptyMap()));
		assertThat(validate).isEqualTo(false);
	}
}