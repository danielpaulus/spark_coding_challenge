package de.codingchallenge.repository;

import de.codingchallenge.model.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SurveyRepository extends MongoRepository<Survey, String> {

	List<Survey> findAll();
}
