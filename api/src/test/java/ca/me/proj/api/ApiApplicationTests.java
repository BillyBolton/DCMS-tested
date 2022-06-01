package ca.me.proj.api;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ca.me.proj.api.config.TestWebConfig;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = TestWebConfig.class)
class ApiApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}


}
