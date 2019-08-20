package de.codingchallenge.dbloader;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.codingchallenge.model.Category;
import de.codingchallenge.model.Question;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonImport {

	private final List<Category> categories;
	private final List<Question> questions;

	@JsonCreator
	public JsonImport(
			@JsonProperty("categories") List<Category> categories,
			@JsonProperty("questions") List<Question> questions) {
		this.categories = categories;
		this.questions = questions;
	}

	List<Question> getQuestions() {
		return questions;
	}

	List<Category> getCategories() {
		return categories;
	}

}
