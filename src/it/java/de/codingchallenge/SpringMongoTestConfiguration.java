package de.codingchallenge;

import com.mongodb.MongoClient;
import de.codingchallenge.repository.CategoryRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@TestConfiguration
@EnableMongoRepositories(basePackageClasses = CategoryRepository.class)
public class SpringMongoTestConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "survey_codingchallenge_app_test";
	}

	@Bean
	@Profile("test")
	@Override
	public MongoClient mongoClient() {
		return new MongoClient("localhost:" + ContainerBaseTest.MONGO_CONTAINER.getMappedPort(27017));
	}
}