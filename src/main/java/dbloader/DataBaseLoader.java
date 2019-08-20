package dbloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import repository.CategoryRepository;
import repository.QuestionRepository;
import repository.SurveyRepository;

@Component
public class DataBaseLoader implements CommandLineRunner {

	private final CategoryRepository categoryRepository;
	private final QuestionRepository questionRepository;
	private final SurveyRepository surveyRepository;

	@Autowired
	public DataBaseLoader(CategoryRepository categoryRepository, QuestionRepository questionRepository,
			SurveyRepository surveyRepository) {
		this.categoryRepository = categoryRepository;
		this.questionRepository = questionRepository;
		this.surveyRepository = surveyRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		var objectMapper = new ObjectMapper();
		var jsonFile = new ClassPathResource("personality_test.json").getFile();
		var jsonImport = objectMapper.readValue(jsonFile, JsonImport.class);
		categoryRepository.saveAll(jsonImport.getCategories());
		questionRepository.saveAll(jsonImport.getQuestions());
		var survey = new Survey(jsonImport.getQuestions());
		surveyRepository.save(survey);
	}
}
