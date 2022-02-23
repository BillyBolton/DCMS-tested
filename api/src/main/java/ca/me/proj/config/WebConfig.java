package ca.me.proj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:/endpoints.properties")
public class WebConfig implements WebMvcConfigurer {

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
