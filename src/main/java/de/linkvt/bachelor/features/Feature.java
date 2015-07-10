package de.linkvt.bachelor.features;

import de.linkvt.bachelor.generator.FeaturePool;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base class for ontology features.
 */
public abstract class Feature {

  @Autowired
  protected OWLDataFactory factory;

  @Autowired
  protected FeaturePool featurePool;

  @Autowired
  protected OWLOntology ontology;


  /**
   * Adds this feature to the passed ontology.
   *
   * @param ontology the ontology this feature will be added to
   */
  public abstract void addToOntology();

  protected void addAxiomToOntology(OWLAxiom axiom) {
    ontology.getOWLOntologyManager().addAxiom(ontology, axiom);
  }

  protected void addToGenericDomainAndNewRange(OWLObjectProperty property, OWLClass range) {
    OWLClass domain = featurePool.getReusableClass();
    OWLAxiom domainAxiom = factory.getOWLObjectPropertyDomainAxiom(property, domain);
    OWLAxiom rangeAxiom = factory.getOWLObjectPropertyRangeAxiom(property, range);

    addAxiomToOntology(domainAxiom);
    addAxiomToOntology(rangeAxiom);
  }

  /**
   * @return a readable name of the feature
   */
  public String getNiceName() {
    return getClass().getSimpleName();
  }

}
