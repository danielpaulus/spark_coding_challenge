package de.codingchallenge.repository;

import de.codingchallenge.model.SurveyResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SurveyResponseRepository extends MongoRepository<SurveyResponse, String> {

	List<SurveyResponse> findAll();
}
