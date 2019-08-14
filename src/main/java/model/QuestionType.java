package model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type")
@JsonSubTypes({
		@JsonSubTypes.Type(value = SingleChoiceQuestionType.class, name = SingleChoiceQuestionType.TYPE_NAME),
		@JsonSubTypes.Type(value = NumberRangeQuestionType.class, name = NumberRangeQuestionType.TYPE_NAME),
		@JsonSubTypes.Type(value = SingleChoiceConditionalQuestionType.class, name = "single_choice_conditional"),
})
public interface QuestionType {
}
