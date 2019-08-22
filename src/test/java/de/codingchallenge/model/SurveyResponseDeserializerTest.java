package de.codingchallenge.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SurveyResponseDeserializerTest {
	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void if_survey_response_deserializes_correctly() throws Exception {
		var jsonFile = new ClassPathResource("survey_response.json").getFile();
		var surveyResponse = objectMapper.readValue(jsonFile, SurveyResponse.class);
		assertThat(surveyResponse.getAnswers().size()).isEqualTo(25);
		var simpleResponses = surveyResponse.getAnswers().values().stream().filter(o -> o instanceof Integer).count();
		assertThat(simpleResponses).isEqualTo(24);
	}

	@Test
	void if_survey_response_with_extra_deserializes_correctly() throws Exception {
		var jsonFile = new ClassPathResource("survey_response_extra.json").getFile();
		var surveyResponse = objectMapper.readValue(jsonFile, SurveyResponse.class);
		Object q2 = surveyResponse.getAnswers().get("q2");
		assertThat(q2).isInstanceOf(Map.class);
		Map<String, Object> q2Map = (Map<String, Object>) q2;
		assertThat(q2Map).containsKey("extra");
		assertThat(q2Map.get("extra")).isEqualTo(18);
	}

}
