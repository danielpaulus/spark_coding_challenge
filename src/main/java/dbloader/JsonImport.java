package dbloader;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import model.Category;
import model.Question;

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

	public List<Question> getQuestions() {
		return questions;
	}

	public List<Category> getCategories() {
		return categories;
	}

}
