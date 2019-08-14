package dbloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import repository.CategoryRepository;

@Component
public class DataBaseLoader implements CommandLineRunner {

	private final CategoryRepository categoryRepository;

	@Autowired
	public DataBaseLoader(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		var objectMapper = new ObjectMapper();
		var jsonFile = new ClassPathResource("personality_test.json").getFile();
		var jsonImport = objectMapper.readValue(jsonFile, JsonImport.class);
		categoryRepository.saveAll(jsonImport.getCategories());
	}
}
