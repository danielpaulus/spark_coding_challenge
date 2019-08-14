package dbloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Question;
import model.SingleChoiceQuestionType;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionSerializationTest {

	private ObjectMapper objectMapper = new ObjectMapper();

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
