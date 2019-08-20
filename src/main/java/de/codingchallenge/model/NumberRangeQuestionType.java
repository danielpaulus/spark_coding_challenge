package de.codingchallenge.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NumberRangeQuestionType implements QuestionType {

	static final String TYPE_NAME = "number_range";
	private final Range range;

	@JsonCreator
	public NumberRangeQuestionType(
			@JsonProperty("range") Range range) {
		this.range = range;
	}

	public Range getRange() {
		return range;
	}

	@JsonProperty("type")
	public String getQuestionType() {
		return TYPE_NAME;
	}

	public static class Range {
		private final int from;
		private final int to;

		@JsonCreator
		public Range(
				@JsonProperty("from") int from,
				@JsonProperty("to") int to) {
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
}
