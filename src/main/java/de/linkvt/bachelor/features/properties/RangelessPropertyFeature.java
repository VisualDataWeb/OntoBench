package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.generator.FeaturePool;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * Property without a range.
 */
public class RangelessPropertyFeature extends Feature {
  @Override
  public void addTo(OWLOntology ontology, OWLDataFactory factory, FeaturePool featurePool) {
    OWLClass domain = featurePool.getExclusiveClass("Domain");
    OWLObjectProperty objectProperty = featurePool.getExclusiveProperty("HasNoRange");
    OWLAxiom axiom = factory.getOWLObjectPropertyDomainAxiom(objectProperty, domain);

    addToOntology(ontology, axiom);
  }
}
