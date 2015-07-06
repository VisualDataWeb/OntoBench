package de.linkvt.bachelor.features.classes;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.generator.FeaturePool;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * An owl class.
 */
public class OwlClassFeature extends Feature {
  @Override
  public void addTo(OWLOntology ontology, OWLDataFactory factory, FeaturePool featurePool) {
    OWLClass owlClass = featurePool.getReusableClass();
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(owlClass);

    addToOntology(ontology, axiom);
  }
}
