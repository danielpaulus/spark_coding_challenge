package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {

	private final String question;
	private final Category category;
	private final QuestionType questionType;

	@JsonCreator
	public Question(
			@JsonProperty("question") String question,
			@JsonProperty("category") Category category,
			@JsonProperty("question_type") QuestionType questionType) {
		this.question = question;
		this.category = category;
		this.questionType = questionType;
	}

	public String getQuestion() {
		return question;
	}

	public Category getCategory() {
		return category;
	}

	@JsonProperty("question_type")
	public QuestionType getQuestionType() {
		return questionType;
	}
}
