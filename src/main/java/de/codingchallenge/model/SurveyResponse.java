package de.codingchallenge.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class SurveyResponse {

	private final Map<String, Object> answers;

	@JsonCreator
	public SurveyResponse(@JsonProperty("answers")
			Map<String, Object> answers) {
		this.answers = answers;
	}

	public Map<String, Object> getAnswers() {
		return answers;
	}
}
