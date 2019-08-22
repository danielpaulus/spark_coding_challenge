package de.codingchallenge.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Map;

public class SurveyResponse {

	private final Map<String, Object> data;

	@JsonCreator
	public SurveyResponse(
			Map<String, Object> data) {
		this.data = data;
	}
}
