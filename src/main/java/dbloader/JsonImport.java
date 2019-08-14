package dbloader;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import model.Category;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonImport {

	private final List<Category> categories;

	@JsonCreator
	public JsonImport(@JsonProperty("categories") List<Category> categories) {
		this.categories = categories;
	}

	public List<Category> getCategories() {
		return categories;
	}
}
