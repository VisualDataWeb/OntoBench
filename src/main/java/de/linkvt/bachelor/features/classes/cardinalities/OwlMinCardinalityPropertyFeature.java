package de.linkvt.bachelor.features.classes.cardinalities;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

/**
 * An owl functional property.
 */
@Component
public class OwlMinCardinalityPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();
    OWLClass range = featurePool.getExclusiveClass("MinCardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectMinCardinality minCardinality = factory.getOWLObjectMinCardinality(2, property);
    OWLAxiom axiom = factory.getOWLSubClassOfAxiom(range, minCardinality);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:minCardinality";
  }

  @Override
  public String getToken() {
    return "mincardinality";
  }
}
