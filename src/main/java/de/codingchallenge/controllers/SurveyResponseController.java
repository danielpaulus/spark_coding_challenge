package de.codingchallenge.controllers;

import de.codingchallenge.model.SurveyResponse;
import de.codingchallenge.service.SurveyResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class SurveyResponseController {
	private final SurveyResponseService surveyResponseService;

	@Autowired
	SurveyResponseController(SurveyResponseService surveyResponseService) {
		this.surveyResponseService = surveyResponseService;
	}

	@PostMapping(path = "/response", consumes = "application/json", produces = "application/json")
	ResponseEntity createResponse(@RequestBody SurveyResponse surveyResponse) {
		if (!surveyResponseService.validate(surveyResponse)) {
			return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		surveyResponseService.save(surveyResponse);
		return new ResponseEntity(HttpStatus.CREATED);
	}
}
