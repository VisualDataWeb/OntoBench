package de.linkvt.bachelor.features.classes.cardinalities.object;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectQualifiedCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty hasFingers = featurePool.getExclusiveProperty("hasFingers");
    OWLClass range = featurePool.getExclusiveClass("QualifiedCardinalityRange");
    addToGenericDomainAndNewRange(hasFingers, range);

    OWLClass thumb = featurePool.getExclusiveClass("Thumb");
    OWLObjectExactCardinality exactCardinality = factory.getOWLObjectExactCardinality(1, hasFingers, thumb);
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, exactCardinality));
  }

  @Override
  public String getName() {
    return "owl:qualifiedCardinality";
  }

  @Override
  public String getToken() {
    return "qualifiedcardinality";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
