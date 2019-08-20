package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.annotation.Id;

@JsonSerialize(using = CategorySerializer.class)
public class Category {

	private final String name;
	@Id
	private String id;

	@JsonCreator
	public Category(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
