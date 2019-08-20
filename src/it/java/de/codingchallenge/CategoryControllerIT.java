package de.codingchallenge;

import de.codingchallenge.main.Application;
import de.codingchallenge.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.junit.jupiter.Testcontainers;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { Application.class, SpringMongoTestConfiguration.class })

@SpringBootTest(properties = {
		"db.seed=true"
		, "spring.main.allow-bean-definition-overriding=true"
})
@AutoConfigureMockMvc
@Testcontainers
@ActiveProfiles("test")
public class CategoryControllerIT extends ContainerBaseTest {

	@Autowired
	MockMvc mockMvc;
	@Autowired
	CategoryRepository categoryRepository;

	String expectedJson = "[\"hard_fact\",\"lifestyle\",\"introversion\",\"passion\"]";

	@Test
	void if_all_four_categories_can_be_retrieved() throws Exception {
		var result = mockMvc.perform(MockMvcRequestBuilders.get("/api/category")).andReturn();
		String contentAsString = result.getResponse().getContentAsString();
		JSONAssert.assertEquals(expectedJson, contentAsString, false);
	}
}