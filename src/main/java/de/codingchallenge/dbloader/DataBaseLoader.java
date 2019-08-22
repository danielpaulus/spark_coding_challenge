package de.codingchallenge.dbloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.codingchallenge.model.Survey;
import de.codingchallenge.repository.CategoryRepository;
import de.codingchallenge.repository.QuestionRepository;
import de.codingchallenge.repository.SurveyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(DataBaseLoader.class);
	private final CategoryRepository categoryRepository;
	private final QuestionRepository questionRepository;
	private final SurveyRepository surveyRepository;
	private final boolean seedDb;

	@Autowired
	DataBaseLoader(CategoryRepository categoryRepository, QuestionRepository questionRepository,
			SurveyRepository surveyRepository, @Value("${db.seed:false}") boolean seedDb) {
		this.categoryRepository = categoryRepository;
		this.questionRepository = questionRepository;
		this.surveyRepository = surveyRepository;
		this.seedDb = seedDb;
	}

	@Override
	public void run(String... strings) throws Exception {
		if (!seedDb) {
			return;
		}
		log.info("Running Database seed..");
		var objectMapper = new ObjectMapper();
		var jsonFile = new ClassPathResource("personality_test.json").getInputStream();
		var jsonImport = objectMapper.readValue(jsonFile, JsonImport.class);
		categoryRepository.saveAll(jsonImport.getCategories());
		questionRepository.saveAll(jsonImport.getQuestions());
		var survey = new Survey(jsonImport.getQuestions());
		surveyRepository.save(survey);
		log.info("Database intialized");
	}
}
