package de.linkvt.ontobench.generator;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureComparator;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Evaluates the features and creates the ontology.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class OntologyGenerator {
  private SortedSet<Feature> features = new TreeSet<>(new FeatureComparator());
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

  public void addFeatures(Collection<Feature> features) {
    this.features.addAll(features);
  }

  public List<Feature> getFeatures() {
    return Collections.unmodifiableList(new ArrayList<>(features));
  }

}
