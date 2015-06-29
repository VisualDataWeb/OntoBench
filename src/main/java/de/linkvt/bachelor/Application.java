package de.linkvt.bachelor;

import de.linkvt.bachelor.config.WebMvcConfig;
import de.linkvt.bachelor.web.converter.OntologyHttpMessageConverter;
import de.linkvt.bachelor.web.converter.RdfXmlOntologyHttpMessageConverter;
import de.linkvt.bachelor.web.converter.TurtleOntologyHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * The entry point of the application.
 */
@SpringBootApplication @Import(WebMvcConfig.class) public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean public HttpMessageConverters customConverters() {
		OntologyHttpMessageConverter turtleConverter = new TurtleOntologyHttpMessageConverter();
		OntologyHttpMessageConverter rdfConverter = new RdfXmlOntologyHttpMessageConverter();
		return new HttpMessageConverters(turtleConverter, rdfConverter);
	}

	@Bean public RequestMappingHandlerMapping disableDefaultSuffixPattern() {
		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
		handlerMapping.setUseSuffixPatternMatch(false);
		return handlerMapping;
	}

}
