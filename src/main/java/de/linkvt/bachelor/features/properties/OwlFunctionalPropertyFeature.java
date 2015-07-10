package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.generator.FeaturePool;

import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * An owl functional property.
 */
public class OwlFunctionalPropertyFeature extends Feature {
  @Override
  protected void addTo(OWLOntology ontology, OWLDataFactory factory, FeaturePool featurePool) {
    OWLObjectProperty property = featurePool.getReusableProperty();
    featurePool.removePropertyFromPool(property);

    OWLFunctionalObjectPropertyAxiom axiom = factory.getOWLFunctionalObjectPropertyAxiom(property);

    addToOntology(ontology, axiom);
  }
}
