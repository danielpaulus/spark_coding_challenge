package model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Survey {

	private final List<Question> questions;

	@Id
	@SuppressWarnings("unused")
	private String id;

	public Survey(List<Question> questions) {
		this.questions = new ArrayList<>(questions);
	}

}
