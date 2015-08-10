package de.linkvt.bachelor.config;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureComparator;
import de.linkvt.bachelor.generator.OntologyGenerator;

import org.apache.commons.codec.binary.Hex;
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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
  public OWLMutableOntology owlOntology(HttpServletRequest request, OntologyGenerator generator) throws OWLOntologyCreationException {
    OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
    // Cast to a mutable ontology to pass OWLApi's strange checks
    return (OWLMutableOntology) ontologyManager.createOntology(IRI.create(createOntologyIri(request, generator)));
  }

  private String createOntologyIri(HttpServletRequest request, OntologyGenerator generator) {
    String url = request.getRequestURL().toString();

    // ignore urls of stored generations
    if (!url.matches(".*\\d+/$")) {
      SortedSet<Feature> features = new TreeSet<>(new FeatureComparator());
      features.addAll(generator.getFeatures());
      String featureString = features.stream().map(Feature::getToken).collect(Collectors.joining(","));

      try {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(featureString.getBytes());
        url += "tmp/" + String.valueOf(Hex.encodeHex(digest.digest())) + "/";
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      }
    }

    return url;
  }

}
