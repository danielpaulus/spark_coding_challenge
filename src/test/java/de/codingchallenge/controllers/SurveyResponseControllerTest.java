package de.codingchallenge.controllers;

import de.codingchallenge.model.SurveyResponse;
import de.codingchallenge.service.SurveyResponseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SurveyResponseControllerTest {

	@Mock SurveyResponseService surveyResponseService;
	private SurveyResponseController surveyResponseController;
	private SurveyResponse fixture = new SurveyResponse(Collections.emptyMap());

	@BeforeEach
	void setUp() {
		surveyResponseController = new SurveyResponseController(surveyResponseService);
	}

	@Test
	void if_invalid_data_causes_422() {
		when(surveyResponseService.validate(any())).thenReturn(false);
		ResponseEntity response = surveyResponseController.createResponse(fixture);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@Test
	void if_valid_data_causes_201() {
		when(surveyResponseService.validate(any())).thenReturn(true);
		ResponseEntity response = surveyResponseController.createResponse(fixture);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
}