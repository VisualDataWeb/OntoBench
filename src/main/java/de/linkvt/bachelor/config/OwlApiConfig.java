package de.linkvt.bachelor.config;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 * Creates beans for OWL API classes.
 */
@Configuration
public class OwlApiConfig {
  @Bean
  public OWLDataFactory dataFactory() {
    return OWLManager.getOWLDataFactory();
  }

  @Bean
  @Scope(WebApplicationContext.SCOPE_REQUEST)
  public OWLOntology owlOntology() throws OWLOntologyCreationException {
    return OWLManager.createOWLOntologyManager().createOntology();
  }
}
