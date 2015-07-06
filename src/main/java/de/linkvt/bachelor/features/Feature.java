package de.linkvt.bachelor.features;

import de.linkvt.bachelor.generator.FeaturePool;
import de.linkvt.bachelor.generator.GeneratorResources;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * Base class for ontology features.
 */
public abstract class Feature {

  /**
   * Adds this feature to the passed ontology.
   *
   * @param ontology    the ontology this feature will be added to
   * @param factory     an owl factory
   * @param featurePool a pool for getting reusable or new features
   */
  protected abstract void addTo(OWLOntology ontology, OWLDataFactory factory, FeaturePool featurePool);

  /**
   * Adds this feature to the passed ontology.
   *
   * @param resources resources of the generator
   */
  public void addTo(GeneratorResources resources) {
    addTo(resources.getOntology(), resources.getFactory(), resources.getFeaturePool());
  }

  protected void addToOntology(OWLOntology ontology, OWLAxiom axiom) {
    ontology.getOWLOntologyManager().addAxiom(ontology, axiom);
  }

  /**
   * @return a readable name of the feature
   */
  public String getNiceName() {
    return getClass().getSimpleName();
  }

}
