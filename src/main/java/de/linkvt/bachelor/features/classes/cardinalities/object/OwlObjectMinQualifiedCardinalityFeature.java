package de.linkvt.bachelor.features.classes.cardinalities.object;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectMinQualifiedCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty hasWeels = featurePool.getExclusiveProperty("hasWeels");
    OWLClass range = featurePool.getExclusiveClass("MinQualifiedCardinalityRange");
    addToGenericDomainAndNewRange(hasWeels, range);

    OWLClass reserveWheel = featurePool.getExclusiveClass("ReserveWheel");
    OWLObjectMinCardinality minCardinality = factory.getOWLObjectMinCardinality(1, hasWeels, reserveWheel);
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, minCardinality));
  }

  @Override
  public String getName() {
    return "owl:minQualifiedCardinality";
  }

  @Override
  public String getToken() {
    return "minqualifiedcardinality";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
