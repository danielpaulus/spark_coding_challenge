package de.codingchallenge.controllers;

import de.codingchallenge.model.Survey;
import de.codingchallenge.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
class SurveyController {
	private final SurveyRepository surveyRepository;

	@Autowired
	SurveyController(SurveyRepository surveyRepository) {
		this.surveyRepository = surveyRepository;
	}

	@RequestMapping("/survey")
	List<Survey> listSurveys() {
		return surveyRepository.findAll();
	}
}
