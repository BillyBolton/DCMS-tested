package ca.me.proj.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @TestConfiguration
@Configuration
@ComponentScan(basePackages = {"ca.me.proj.api"})
@ActiveProfiles({"heroku, local"})
public class TestWebConfig implements WebMvcConfigurer {

}
