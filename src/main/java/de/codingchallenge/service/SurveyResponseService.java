package de.codingchallenge.service;

import de.codingchallenge.model.SurveyResponse;
import de.codingchallenge.repository.SurveyRepository;
import de.codingchallenge.repository.SurveyResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyResponseService {

	private final SurveyResponseRepository surveyResponseRepository;
	private final SurveyRepository surveyRepository;

	@Autowired
	SurveyResponseService(SurveyResponseRepository surveyResponseRepository,
			SurveyRepository surveyRepository) {
		this.surveyResponseRepository = surveyResponseRepository;
		this.surveyRepository = surveyRepository;
	}

	public boolean validate(SurveyResponse surveyResponse) {

		return true;
	}

	public void save(SurveyResponse surveyResponse) {
		surveyResponseRepository.save(surveyResponse);
	}
}
