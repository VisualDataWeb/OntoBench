package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.generator.FeaturePool;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * Property without a domain.
 */
public class DomainlessPropertyFeature extends Feature {
  @Override
  public void addTo(OWLOntology ontology, OWLDataFactory factory, FeaturePool featurePool) {
    OWLClass range = featurePool.getExclusiveClass("Range");
    OWLObjectProperty objectProperty = factory.getOWLObjectProperty(IRI.create("HasNoDomain"));
    OWLAxiom axiom = factory.getOWLObjectPropertyRangeAxiom(objectProperty, range);

    OWLOntologyManager manager = ontology.getOWLOntologyManager();
    manager.addAxiom(ontology, axiom);
  }
}
