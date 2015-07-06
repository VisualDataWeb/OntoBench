package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.generator.FeaturePool;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLProperty;

/**
 * Property without domain and range.
 */
public class UnboundPropertyFeature extends Feature {
  @Override
  public void addTo(OWLOntology ontology, OWLDataFactory factory, FeaturePool featurePool) {
    OWLProperty property = featurePool.getExclusiveProperty("HasNoDomainAndRange");
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(property);

    addToOntology(ontology, axiom);
  }
}
