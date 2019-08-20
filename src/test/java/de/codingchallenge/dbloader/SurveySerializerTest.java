package de.codingchallenge.dbloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.codingchallenge.model.*;
import org.assertj.core.util.Lists;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.util.Collections;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SurveySerializerTest {
	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void if_survey_serializes_correctly() throws Exception {
		var survey = createSurvey();
		var surveyJSON = objectMapper.writeValueAsString(survey);

		var jsonFile = new ClassPathResource("generated_survey.json").getFile();
		var jsonContents = Files.readString(jsonFile.toPath());

		JSONAssert.assertEquals(jsonContents, surveyJSON, false);
	}

	@NotNull
	private Survey createSurvey() {
		return new Survey(
				Lists.list(
						new Question("bla", new Category("something"),
								new SingleChoiceConditionalQuestionType(Lists.list("option1", "option2"),
										new SingleChoiceConditionalQuestionType.Condition(
												new Question("something2", new Category("cat"), null),
												Collections.singletonMap("key", "value")
										)
								)
						),
						new Question("some2", new Category("sfg"),
								new NumberRangeQuestionType(new NumberRangeQuestionType.Range(12, 2))),
						new Question("some3", new Category("sfg"),
								new SingleChoiceQuestionType(Lists.list("opt12", "opt134")))
				)
		);
	}
}
