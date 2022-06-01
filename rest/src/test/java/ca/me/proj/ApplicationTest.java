package ca.me.proj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ca.me.proj.config.TestWebConfig;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = TestWebConfig.class)
class ApplicationTest {

    @Test
    void contextLoads() {}

}
