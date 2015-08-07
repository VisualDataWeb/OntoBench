package de.linkvt.bachelor.features.classes.axioms;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class OwlDisjointWithFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass opera = featurePool.getExclusiveClass("Opera");
    OWLClass operetta = featurePool.getExclusiveClass("Operetta");
    OWLClass musical = featurePool.getExclusiveClass("Musical");

    addAxiomToOntology(factory.getOWLDisjointClassesAxiom(opera, operetta));
    addAxiomToOntology(factory.getOWLDisjointClassesAxiom(operetta, musical));
    addAxiomToOntology(factory.getOWLDisjointClassesAxiom(musical, opera));
  }

  @Override
  public String getName() {
    return "owl:disjointWith";
  }

  @Override
  public String getToken() {
    return "disjointwith";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
