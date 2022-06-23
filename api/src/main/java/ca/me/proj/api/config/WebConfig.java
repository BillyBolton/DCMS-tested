

package ca.me.proj.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"ca.me.proj.api"})
// // @PropertySource(value = "classpath:/endpoints.properties", name = "api-endpoints")
public class WebConfig implements WebMvcConfigurer {

    public final String clientURL = "http://localhost:3000";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // all endpoints
                .allowedOrigins(clientURL)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS"); // specific
        // log.info("CORS URL: " + clientURL);
    }

    // ignore 'Accept' header (we use CustomContentNegotiationStrategy instead)
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentTypeStrategy(new CustomContentNegotiationStrategy())
                .ignoreAcceptHeader(true);
    }

    // allows us to serve static assets
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String[] STATIC_RESOURCE = {"/", "classpath:/", "classpath:/META-INF/resources/",
                "classpath:/resources/", "classpath:/static/", "classpath:/public/"};

        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(STATIC_RESOURCE);
        }
    }



}
