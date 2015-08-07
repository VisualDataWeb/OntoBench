package de.linkvt.bachelor.config;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLMutableOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

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
  @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
  public OWLMutableOntology owlOntology(HttpServletRequest request) throws OWLOntologyCreationException {
    OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
    // Cast to a mutable ontology to pass OWLApi's strange checks
    return (OWLMutableOntology) ontologyManager.createOntology(IRI.create(request.getRequestURL().toString()));
  }

}
