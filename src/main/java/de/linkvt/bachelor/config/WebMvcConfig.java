package de.linkvt.bachelor.config;

import de.linkvt.bachelor.web.converters.message.OntologyHttpMessageConverter;
import de.linkvt.bachelor.web.converters.message.RdfXmlOntologyHttpMessageConverter;
import de.linkvt.bachelor.web.converters.message.TurtleOntologyHttpMessageConverter;
import de.linkvt.bachelor.web.converters.parameter.StringToPropertyFeaturesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configures the web module.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Autowired
  private StringToPropertyFeaturesConverter converter;

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(converter);
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.ignoreAcceptHeader(true)
        .mediaType("owl", MediaType.TEXT_XML)
        .mediaType("rdf", MediaType.TEXT_XML)
        .mediaType("xml", MediaType.TEXT_XML)
        .mediaType("ttl", MediaType.TEXT_PLAIN);
  }

  @Bean
  public HttpMessageConverters customConverters() {
    OntologyHttpMessageConverter turtleConverter = new TurtleOntologyHttpMessageConverter();
    OntologyHttpMessageConverter rdfConverter = new RdfXmlOntologyHttpMessageConverter();
    return new HttpMessageConverters(turtleConverter, rdfConverter);
  }
}
