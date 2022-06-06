package ca.me.proj.api;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = ApiApplication.class)
class ApiApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}

	@Test
	void add() {
		int a = 1;
		int b = 2;
		assertEquals(3, a + b);
	}

}
