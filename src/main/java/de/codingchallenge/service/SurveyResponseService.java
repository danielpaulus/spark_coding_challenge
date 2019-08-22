package de.codingchallenge.service;

import de.codingchallenge.model.Question;
import de.codingchallenge.model.SingleChoiceQuestionType;
import de.codingchallenge.model.Survey;
import de.codingchallenge.model.SurveyResponse;
import de.codingchallenge.repository.SurveyRepository;
import de.codingchallenge.repository.SurveyResponseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SurveyResponseService {

	private static final Logger log = LoggerFactory.getLogger(SurveyResponseService.class);

	private final SurveyResponseRepository surveyResponseRepository;
	private final SurveyRepository surveyRepository;

	@Autowired
	SurveyResponseService(SurveyResponseRepository surveyResponseRepository,
			SurveyRepository surveyRepository) {
		this.surveyResponseRepository = surveyResponseRepository;
		this.surveyRepository = surveyRepository;
	}

	public boolean validate(SurveyResponse surveyResponse) {
		if (surveyResponse.getAnswers() == null || surveyResponse.getAnswers().isEmpty()) {
			log.debug("null or empty answers");
			return false;
		}
		Survey survey = surveyRepository.findAll().get(0);
		if (survey == null) {
			throw new IllegalStateException("There should be at least one survey in the DB.");
		}
		if (survey.getQuestions().size() != surveyResponse.getAnswers().size()) {
			log.debug("Wrong number of responses: {}", surveyResponse.getAnswers().size());
			return false;
		}
		return validateQuestionType(survey.getQuestions(), surveyResponse.getAnswers());
	}

	private boolean validateQuestionType(List<Question> questions, Map<String, Object> answers) {
		var questionsIterator = questions.iterator();
		var i = 0;
		while (questionsIterator.hasNext()) {
			Question question = questionsIterator.next();
			if (isSingleChoiceQuestionType(question)
					&& !checkAnswerIndex(
					(SingleChoiceQuestionType) question.getQuestionType(),
					answers,
					i)) {
				log.debug("broken option {} for question {}", i, question.getQuestionText());
				return false;
			}
			i++;
		}
		return true;
	}

	private boolean isSingleChoiceQuestionType(Question next) {
		return SingleChoiceQuestionType.TYPE_NAME.equals(next.getQuestionType().getQuestionType());
	}

	private boolean checkAnswerIndex(SingleChoiceQuestionType questionType, Map<String, Object> answers, int i) {
		Object value = answers.get(String.format("q%d", i));
		if (!(value instanceof Integer)) {
			return false;
		}
		var answerIndex = (Integer) value;
		int size = questionType.getOptions().size();
		return size >= answerIndex && answerIndex >= 0;
	}

	public void save(SurveyResponse surveyResponse) {
		surveyResponseRepository.save(surveyResponse.getAnswers());
	}
}
