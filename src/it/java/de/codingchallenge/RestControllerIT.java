package de.codingchallenge;

import de.codingchallenge.main.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.nio.file.Files;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { Application.class, SpringMongoTestConfiguration.class })

@SpringBootTest(properties = {
		"db.seed=true"
		, "spring.main.allow-bean-definition-overriding=true"
})
@AutoConfigureMockMvc
@Testcontainers
@ActiveProfiles("test")
class RestControllerIT extends ContainerBaseTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void if_all_four_categories_can_be_retrieved() throws Exception {
		var result = mockMvc.perform(MockMvcRequestBuilders.get("/api/category")).andReturn();
		var contentAsString = result.getResponse().getContentAsString();
		var expectedJson = "[\"hard_fact\",\"lifestyle\",\"introversion\",\"passion\"]";
		JSONAssert.assertEquals(expectedJson, contentAsString, false);
	}

	@Test
	void if_the_survey_is_retrieved_correctly() throws Exception {
		var result = mockMvc.perform(MockMvcRequestBuilders.get("/api/survey")).andReturn();
		var contentAsString = result.getResponse().getContentAsString();
		var jsonFile = new ClassPathResource("expected_survey.json").getFile();
		var expectedJson = Files.readString(jsonFile.toPath());
		JSONAssert.assertEquals(expectedJson, contentAsString, false);
	}
}