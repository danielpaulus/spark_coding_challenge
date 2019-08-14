package dbloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.NumberRangeQuestionType;
import model.Question;
import model.SingleChoiceConditionalQuestionType;
import model.SingleChoiceQuestionType;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionSerializationTest {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void if_single_choice_conditional_is_parsed_correcty() throws Exception {
		var jsonFile = new ClassPathResource("single_choice_conditional_question.json").getFile();
		var numberRangeQuestion = objectMapper.readValue(jsonFile, Question.class);
		assertThat(numberRangeQuestion.getCategory().getName()).isEqualTo("hard_fact");
		assertThat(numberRangeQuestion.getQuestion()).isEqualTo("How important is the age of your partner to you?");
		assertThat(numberRangeQuestion.getQuestionType()).isInstanceOf(SingleChoiceConditionalQuestionType.class);
		var numberRangeQuestionType = (SingleChoiceConditionalQuestionType) numberRangeQuestion.getQuestionType();
		assertThat(numberRangeQuestionType.getCondition().getIfConditionPositive().getQuestionType()).isInstanceOf(NumberRangeQuestionType.class);
	}

	@Test
	void if_number_range_question_is_parsed_correctly() throws Exception {
		var jsonFile = new ClassPathResource("number_range_question.json").getFile();

		var numberRangeQuestion = objectMapper.readValue(jsonFile, Question.class);
		assertThat(numberRangeQuestion.getCategory().getName()).isEqualTo("hard_fact");
		assertThat(numberRangeQuestion.getQuestion()).isEqualTo("What age should your potential partner be?");
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
		assertThat(singleChoiceQuestion.getQuestion()).isEqualTo("How important is the gender of your partner?");
		assertThat(singleChoiceQuestion.getQuestionType()).isInstanceOf(SingleChoiceQuestionType.class);
		var singleChoiceQuestionType = (SingleChoiceQuestionType) singleChoiceQuestion.getQuestionType();
		assertThat(singleChoiceQuestionType.getOptions()).containsExactly("not important", "important", "very important");
		assertThat(singleChoiceQuestionType.getQuestionType()).isEqualTo("single_choice");
	}
}
