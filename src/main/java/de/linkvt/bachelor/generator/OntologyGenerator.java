package de.linkvt.bachelor.generator;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Evaluates the features and creates the ontology.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class OntologyGenerator {
  private List<Feature> features = new ArrayList<>();
  private OWLOntology ontology;

  @Autowired
  public OntologyGenerator(OWLOntology ontology) throws OWLOntologyCreationException {
    this.ontology = ontology;
  }

  public OWLOntology generate() {
    features.forEach(Feature::addToOntology);
    return ontology;
  }

  public void addFeature(Feature feature) {
    features.add(feature);
  }

  public void addFeatures(List<Feature> features) {
    this.features.addAll(features);
  }

}
