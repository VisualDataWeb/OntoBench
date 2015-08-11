package de.linkvt.bachelor.config;

import de.linkvt.bachelor.web.converters.message.FunctionalSyntaxHttpMessageConverter;
import de.linkvt.bachelor.web.converters.message.ManchesterSyntaxHttpMessageConverter;
import de.linkvt.bachelor.web.converters.message.OntologySyntax;
import de.linkvt.bachelor.web.converters.message.OwlXmlHttpMessageConverter;
import de.linkvt.bachelor.web.converters.message.RdfXmlOntologyHttpMessageConverter;
import de.linkvt.bachelor.web.converters.message.TurtleOntologyHttpMessageConverter;
import de.linkvt.bachelor.web.converters.parameter.StringToFeaturesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

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
        .favorParameter(true)
        .ignoreUnknownPathExtensions(false)
        .defaultContentType(MediaType.TEXT_PLAIN)
        .mediaType("owx", OntologySyntax.OWL_XML.getMediaType())
        .mediaType("owl", OntologySyntax.RDF_XML.getMediaType())
        .mediaType("rdf", OntologySyntax.RDF_XML.getMediaType())
        .mediaType("xml", OntologySyntax.RDF_XML.getMediaType())
        .mediaType("ofn", OntologySyntax.FUNCTIONAL.getMediaType())
        .mediaType("omn", OntologySyntax.MANCHESTER.getMediaType())
        .mediaType("ttl", OntologySyntax.TURTLE.getMediaType());
  }

  @Bean
  public HttpMessageConverters customConverters() {
    List<HttpMessageConverter<?>> converters = new ArrayList<>();

    converters.add(new FunctionalSyntaxHttpMessageConverter());
    converters.add(new ManchesterSyntaxHttpMessageConverter());
    converters.add(new OwlXmlHttpMessageConverter());
    converters.add(new RdfXmlOntologyHttpMessageConverter());
    converters.add(new TurtleOntologyHttpMessageConverter());

    return new HttpMessageConverters(converters);
  }
}
