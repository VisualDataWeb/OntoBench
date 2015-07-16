package de.linkvt.bachelor.features.classes.cardinalities;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

/**
 * An owl functional property.
 */
@Component
public class OwlCardinalityPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();
    OWLClass range = featurePool.getExclusiveClass("CardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectExactCardinality exactCardinality = factory.getOWLObjectExactCardinality(4, property);
    OWLAxiom axiom = factory.getOWLSubClassOfAxiom(range, exactCardinality);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:cardinality";
  }

  @Override
  public String getToken() {
    return "cardinality";
  }
}
