package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.generator.FeaturePool;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * Property without a domain.
 */
public class DomainlessPropertyFeature extends Feature {
  @Override
  public void addTo(OWLOntology ontology, OWLDataFactory factory, FeaturePool featurePool) {
    OWLClass range = featurePool.getExclusiveClass("Range");
    OWLObjectProperty objectProperty = featurePool.getExclusiveProperty("HasNoDomain");
    OWLAxiom axiom = factory.getOWLObjectPropertyRangeAxiom(objectProperty, range);

    addToOntology(ontology, axiom);
  }
}
