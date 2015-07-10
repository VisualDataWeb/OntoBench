package de.linkvt.bachelor.features.classes;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.generator.FeaturePool;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * The owl thing.
 */
public class OwlThingFeature extends Feature {
  @Override
  protected void addTo(OWLOntology ontology, OWLDataFactory factory, FeaturePool featurePool) {
    OWLClass owlThing = factory.getOWLThing();
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(owlThing);

    addToOntology(ontology, axiom);
  }
}
