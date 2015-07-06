package de.linkvt.bachelor.generator;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Encapsulates resources of a generator.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GeneratorResources {

  private OWLOntology ontology;
  private OWLDataFactory factory;
  private FeaturePool featurePool;

  public GeneratorResources() throws OWLOntologyCreationException {
    OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();

    ontology = ontologyManager.createOntology();
    factory = ontologyManager.getOWLDataFactory();
    featurePool = new FeaturePool(factory);
  }

  /**
   * @return the feature pool
   */
  public FeaturePool getFeaturePool() {
    return featurePool;
  }

  /**
   * @return an owl factory
   */
  public OWLDataFactory getFactory() {
    return factory;
  }

  /**
   * @return the ontology
   */
  public OWLOntology getOntology() {
    return ontology;
  }

}
