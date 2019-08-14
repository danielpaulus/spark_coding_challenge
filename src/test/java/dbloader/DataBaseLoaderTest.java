package dbloader;

import model.Category;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.CategoryRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DataBaseLoaderTest {

	@Mock
	CategoryRepository categoryRepository;

	@Captor
	ArgumentCaptor<List<Category>> captor;

	@Test
	void if_four_categories_are_saved_to_the_repo() throws Exception {
		var dataBaseLoader = new DataBaseLoader(categoryRepository);
		dataBaseLoader.run();
		verify(categoryRepository, times(1)).saveAll(captor.capture());
		assertThat(captor.getValue()).hasSize(4);
	}
}