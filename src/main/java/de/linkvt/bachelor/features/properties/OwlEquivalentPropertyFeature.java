package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.generator.FeaturePool;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;

import java.util.Collections;

/**
 * An owl equivalent property.
 */
public class OwlEquivalentPropertyFeature extends Feature {
  @Override
  protected void addTo(OWLOntology ontology, OWLDataFactory factory, FeaturePool featurePool) {
    OWLObjectProperty property = featurePool.getReusableProperty();
    featurePool.removePropertyFromPool(property);
    OWLObjectProperty equivalentProperty = featurePool.getExclusiveProperty("EquivalentProperty");

    OWLAxiom equivalentAxiom = factory.getOWLEquivalentObjectPropertiesAxiom(property, equivalentProperty);

    OWLClass equivalentDomain = featurePool.getReusableClass();
    OWLClass equivalentRange = featurePool.getExclusiveClass("EquivalentPropertyTest");
    OWLAxiom domainAxiom = factory.getOWLObjectPropertyDomainAxiom(equivalentProperty, equivalentDomain);
    OWLAxiom rangeAxiom = factory.getOWLObjectPropertyRangeAxiom(equivalentProperty, equivalentRange);

    addToOntology(ontology, equivalentAxiom);
    addToOntology(ontology, domainAxiom);
    addToOntology(ontology, rangeAxiom);
  }
}
