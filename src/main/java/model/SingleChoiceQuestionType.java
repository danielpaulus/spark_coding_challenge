package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SingleChoiceQuestionType implements QuestionType {

	final static String TYPE_NAME = "single_choice";

	private final List<String> options;

	@JsonCreator
	public SingleChoiceQuestionType(
			@JsonProperty("options") List<String> options) {
		this.options = options;
	}

	@JsonProperty("type")
	public String getQuestionType() {
		return TYPE_NAME;
	}

	public List<String> getOptions() {
		return options;
	}
}
