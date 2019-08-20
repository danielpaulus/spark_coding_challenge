package de.codingchallenge.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CategorySerializer extends StdSerializer<Category> {
	/**
	 * This one is needed for Jackson to work
	 */
	@SuppressWarnings("unused")
	public CategorySerializer() {
		this(null);
	}

	private CategorySerializer(Class<Category> t) {
		super(t);
	}

	@Override
	public void serialize(Category category, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		jsonGenerator.writeString(category.getName());
	}
}
