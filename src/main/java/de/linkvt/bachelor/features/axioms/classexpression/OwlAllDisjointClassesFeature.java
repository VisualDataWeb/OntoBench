package de.linkvt.bachelor.features.axioms.classexpression;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class OwlAllDisjointClassesFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass opera = featurePool.getExclusiveClass(":Opera");
    OWLClass operetta = featurePool.getExclusiveClass(":Operetta");
    OWLClass musical = featurePool.getExclusiveClass(":Musical");

    addAxiomToOntology(factory.getOWLDisjointClassesAxiom(opera, operetta, musical));
  }

  @Override
  public String getName() {
    return "owl:AllDisjointClasses";
  }

  @Override
  public String getToken() {
    return "alldisjointclasses";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS_EXPRESSION_AXIOMS;
  }
}
