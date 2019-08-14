package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.annotation.Id;

public class Category {

	@Id
	private String id;
	private final String name;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@JsonCreator
	public Category(String name) {
		this.name = name;
	}
}
