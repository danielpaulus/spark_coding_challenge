package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

public class SingleChoiceConditionalQuestionType implements QuestionType {

	static final String TYPE_NAME = "single_choice_conditional";

	private final List<String> options;
	private final Condition condition;

	@JsonCreator
	public SingleChoiceConditionalQuestionType(
			@JsonProperty("options") List<String> options,
			@JsonProperty("condition") Condition condition
	) {
		this.options = options;
		this.condition = condition;
	}

	@JsonProperty("type")
	public String getQuestionType() {
		return TYPE_NAME;
	}

	public List<String> getOptions() {
		return options;
	}

	public Condition getCondition() {
		return condition;
	}

	public static class Condition {

		private final Question ifConditionPositive;
		private final HashMap<String, Object> condition;

		@JsonCreator
		public Condition(
				@JsonProperty("if_positive") Question ifConditionPositive,
				@JsonProperty("predicate") HashMap<String, Object> condition) {

			this.ifConditionPositive = ifConditionPositive;
			this.condition = condition;
		}

		public Question getIfConditionPositive() {
			return ifConditionPositive;
		}

		public HashMap<String, Object> getCondition() {
			return condition;
		}

	}
}
