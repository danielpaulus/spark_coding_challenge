package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NumberRangeQuestionType implements QuestionType {
	private final int from;
	private final int to;

	private final String questionType;

	@JsonCreator
	public NumberRangeQuestionType(
			@JsonProperty("type") String questionType,
			@JsonProperty("from") int from,
			@JsonProperty("to") int to) {
		this.questionType = questionType;
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

}
