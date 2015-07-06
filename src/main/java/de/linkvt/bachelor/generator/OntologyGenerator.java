package de.linkvt.bachelor.generator;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Evaluates the features and creates the ontology.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OntologyGenerator {
  private List<Feature> features = new ArrayList<>();
  private GeneratorResources resources;

  @Autowired
  public OntologyGenerator(GeneratorResources resources) throws OWLOntologyCreationException {
    this.resources = resources;
  }

  public OWLOntology generate() {
    features.forEach(this::visit);
    return resources.getOntology();
  }

  public void addFeature(Feature feature) {
    features.add(feature);
  }

  public void addFeatures(List<Feature> features) {
    this.features.addAll(features);
  }

  private void visit(Feature feature) {
    feature.addTo(resources);
  }

}
