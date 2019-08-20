package dbloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.NumberRangeQuestionType;
import model.Question;
import model.SingleChoiceConditionalQuestionType;
import model.SingleChoiceQuestionType;
import org.json.JSONException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionSerializationTest {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Nested
	class question_types_should_be_serialized_correctly {

		@Test
		void if_single_choice_conditional_is_serialized_correcty() throws Exception {
			var type = "single_choice_conditional_question.json";
			compareSerializedToOriginal(type);
		}

		@Test
		void if_single_choice_is_serialized_correcty() throws Exception {
			var type = "single_choice_question.json";
			compareSerializedToOriginal(type);
		}

		@Test
		void if_number_range_is_serialized_correcty() throws Exception {
			var type = "number_range_question.json";
			compareSerializedToOriginal(type);
		}

		private void compareSerializedToOriginal(String type) throws IOException, JSONException {
			var jsonFile = new ClassPathResource(type).getFile();
			var jsonContents = Files.readString(jsonFile.toPath());
			var numberRangeQuestion = objectMapper.readValue(jsonFile, Question.class);
			var serializedJson = objectMapper.writeValueAsString(numberRangeQuestion);
			System.out.println(serializedJson);
			System.out.println(jsonContents);
			JSONAssert.assertEquals(jsonContents, serializedJson, false);
		}
	}

	@Nested
	class question_types_should_be_deserialized_correctly {
		@Test
		void if_single_choice_conditional_is_parsed_correcty() throws Exception {
			var jsonFile = new ClassPathResource("single_choice_conditional_question.json").getFile();
			var numberRangeQuestion = objectMapper.readValue(jsonFile, Question.class);
			assertThat(numberRangeQuestion.getCategory().getName()).isEqualTo("hard_fact");
			assertThat(numberRangeQuestion.getQuestionText()).isEqualTo("How important is the age of your partner to you?");
			assertThat(numberRangeQuestion.getQuestionType()).isInstanceOf(SingleChoiceConditionalQuestionType.class);
			var numberRangeQuestionType = (SingleChoiceConditionalQuestionType) numberRangeQuestion.getQuestionType();
			assertThat(numberRangeQuestionType.getCondition().getIfConditionPositive().getQuestionType())
					.isInstanceOf(NumberRangeQuestionType.class);
		}

		@Test
		void if_number_range_question_is_parsed_correctly() throws Exception {
			var jsonFile = new ClassPathResource("number_range_question.json").getFile();

			var numberRangeQuestion = objectMapper.readValue(jsonFile, Question.class);
			assertThat(numberRangeQuestion.getCategory().getName()).isEqualTo("hard_fact");
			assertThat(numberRangeQuestion.getQuestionText()).isEqualTo("What age should your potential partner be?");
			assertThat(numberRangeQuestion.getQuestionType()).isInstanceOf(NumberRangeQuestionType.class);
			var numberRangeQuestionType = (NumberRangeQuestionType) numberRangeQuestion.getQuestionType();
			assertThat(numberRangeQuestionType.getRange().getFrom()).isEqualTo(18);
			assertThat(numberRangeQuestionType.getRange().getTo()).isEqualTo(140);
			assertThat(numberRangeQuestionType.getQuestionType()).isEqualTo("number_range");
		}

		@Test
		void if_single_choice_question_is_parsed_correctly() throws IOException {
			var jsonFile = new ClassPathResource("single_choice_question.json").getFile();

			var singleChoiceQuestion = objectMapper.readValue(jsonFile, Question.class);
			assertThat(singleChoiceQuestion.getCategory().getName()).isEqualTo("hard_fact");
			assertThat(singleChoiceQuestion.getQuestionText()).isEqualTo("How important is the gender of your partner?");
			assertThat(singleChoiceQuestion.getQuestionType()).isInstanceOf(SingleChoiceQuestionType.class);
			var singleChoiceQuestionType = (SingleChoiceQuestionType) singleChoiceQuestion.getQuestionType();
			assertThat(singleChoiceQuestionType.getOptions()).containsExactly("not important", "important", "very important");
			assertThat(singleChoiceQuestionType.getQuestionType()).isEqualTo("single_choice");
		}
	}
}
