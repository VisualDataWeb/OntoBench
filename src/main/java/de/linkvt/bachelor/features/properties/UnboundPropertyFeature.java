package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.generator.FeaturePool;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * Property without domain and range.
 */
public class UnboundPropertyFeature extends Feature {
  @Override
  public void addTo(OWLOntology ontology, OWLDataFactory factory, FeaturePool featurePool) {
    OWLObjectProperty objectProperty = factory.getOWLObjectProperty(IRI.create("NoDomainAndRange"));
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(objectProperty);

    addToOntology(ontology, axiom);
  }
}
