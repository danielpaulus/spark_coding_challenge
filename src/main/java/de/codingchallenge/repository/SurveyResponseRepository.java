package de.codingchallenge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Map;

public interface SurveyResponseRepository extends MongoRepository<Map<String, Object>, String> {

}
