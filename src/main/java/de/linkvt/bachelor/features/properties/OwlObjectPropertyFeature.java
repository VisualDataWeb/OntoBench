package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.generator.FeaturePool;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * An owl object property.
 */
public class OwlObjectPropertyFeature extends Feature {
  @Override
  protected void addTo(OWLOntology ontology, OWLDataFactory factory, FeaturePool featurePool) {
    OWLClass domain = featurePool.getReusableClass();
    OWLClass range = featurePool.getExclusiveClass("ObjectPropertyRange");
    OWLObjectProperty objectProperty = featurePool.getExclusiveProperty("ObjectProperty");

    OWLAxiom domainAxiom = factory.getOWLObjectPropertyDomainAxiom(objectProperty, domain);
    OWLAxiom rangeAxiom = factory.getOWLObjectPropertyRangeAxiom(objectProperty, range);

    addToOntology(ontology, domainAxiom);
    addToOntology(ontology, rangeAxiom);
  }
}
