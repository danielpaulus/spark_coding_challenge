package de.codingchallenge.dbloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.codingchallenge.model.Survey;
import de.codingchallenge.repository.CategoryRepository;
import de.codingchallenge.repository.QuestionRepository;
import de.codingchallenge.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements CommandLineRunner {

	private final CategoryRepository categoryRepository;
	private final QuestionRepository questionRepository;
	private final SurveyRepository surveyRepository;

	@Value("${db.seed:false}")
	boolean seedDb;

	@Autowired
	DataBaseLoader(CategoryRepository categoryRepository, QuestionRepository questionRepository,
			SurveyRepository surveyRepository) {
		this.categoryRepository = categoryRepository;
		this.questionRepository = questionRepository;
		this.surveyRepository = surveyRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		if (!seedDb) {
			return;
		}
		var objectMapper = new ObjectMapper();
		var jsonFile = new ClassPathResource("personality_test.json").getFile();
		var jsonImport = objectMapper.readValue(jsonFile, JsonImport.class);
		categoryRepository.saveAll(jsonImport.getCategories());
		questionRepository.saveAll(jsonImport.getQuestions());
		var survey = new Survey(jsonImport.getQuestions());
		surveyRepository.save(survey);
	}
}
