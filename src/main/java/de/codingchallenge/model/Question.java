package de.codingchallenge.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Question {

	private final String questionText;
	private final Category category;
	private final QuestionType questionType;
	@Id
	@SuppressWarnings("unused")
	private String id;

	@JsonCreator
	public Question(
			@JsonProperty("question") String questionText,
			@JsonProperty("category") Category category,
			@JsonProperty("question_type") QuestionType questionType) {
		this.questionText = questionText;
		this.category = category;
		this.questionType = questionType;
	}

	@JsonProperty("question")
	public String getQuestionText() {
		return questionText;
	}

	public Category getCategory() {
		return category;
	}

	@JsonProperty("question_type")
	public QuestionType getQuestionType() {
		return questionType;
	}
}
