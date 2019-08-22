package de.codingchallenge.service;

import de.codingchallenge.model.SurveyResponse;
import de.codingchallenge.repository.SurveyResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyResponseService {

	private final SurveyResponseRepository surveyResponseRepository;

	@Autowired
	SurveyResponseService(SurveyResponseRepository surveyRepository) {
		this.surveyResponseRepository = surveyRepository;
	}

	public boolean validate(SurveyResponse surveyResponse) {
		return false;
	}

	public void save(SurveyResponse surveyResponse) {
		surveyResponseRepository.save(surveyResponse);
	}
}
