package model;

import org.springframework.data.annotation.Id;

public class Category {

	@Id
	private final String id;
	private final String name;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Category(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
