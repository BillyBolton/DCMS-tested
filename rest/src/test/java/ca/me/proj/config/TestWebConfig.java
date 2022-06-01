package ca.me.proj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"ca.me.proj.api"})
// @TestPropertySource(value = "classpath:application-heroku.properties")
// @TestPropertySource(value = "classpath:application-https.properties")
// @TestPropertySource(value = "classpath:application-local.properties")
// @TestPropertySource(value = "classpath:application-pgadmin.properties")
// @TestPropertySource(value = "classpath:application.properties")
// @TestPropertySource(value = "classpath:heroku.env")
@ActiveProfiles({"heroku, local"})
public class TestWebConfig implements WebMvcConfigurer {

}
