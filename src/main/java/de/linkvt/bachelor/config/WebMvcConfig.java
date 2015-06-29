package de.linkvt.bachelor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configures the web module.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.ignoreAcceptHeader(true)
        .mediaType("rdf", MediaType.TEXT_XML)
        .mediaType("xml", MediaType.TEXT_XML)
        .mediaType("ttl", MediaType.TEXT_PLAIN);
  }
}
