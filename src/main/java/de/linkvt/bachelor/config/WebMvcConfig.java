package de.linkvt.bachelor.config;

import de.linkvt.bachelor.web.converters.message.OntologyHttpMessageConverter;
import de.linkvt.bachelor.web.converters.message.OwlMediaType;
import de.linkvt.bachelor.web.converters.message.RdfXmlOntologyHttpMessageConverter;
import de.linkvt.bachelor.web.converters.message.TurtleOntologyHttpMessageConverter;
import de.linkvt.bachelor.web.converters.parameter.StringToFeaturesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Configures the web module.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Autowired
  private StringToFeaturesConverter converter;

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(converter);
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.ignoreAcceptHeader(true)
        .mediaType("owl", OwlMediaType.APPLICATION_RDF_XML)
        .mediaType("rdf", OwlMediaType.APPLICATION_RDF_XML)
        .mediaType("xml", OwlMediaType.APPLICATION_RDF_XML)
        .mediaType("ttl", OwlMediaType.TEXT_PLAIN); // use text/plain for turtle for access without downloading
  }

  @Bean
  public HttpMessageConverters customConverters() {
    OntologyHttpMessageConverter turtleConverter = new TurtleOntologyHttpMessageConverter();
    OntologyHttpMessageConverter rdfConverter = new RdfXmlOntologyHttpMessageConverter();
    return new HttpMessageConverters(turtleConverter, rdfConverter);
  }
}
