package de.linkvt.bachelor.features.axioms.classexpression;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class OwlDisjointWithFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass c1 = featurePool.getExclusiveClass(":DisjointWith_Class1");
    OWLClass c2 = featurePool.getExclusiveClass(":DisjointWith_Class2");
    OWLClass c3 = featurePool.getExclusiveClass(":DisjointWith_Class3");

    addAxiomToOntology(factory.getOWLDisjointClassesAxiom(c1, c2));
    addAxiomToOntology(factory.getOWLDisjointClassesAxiom(c2, c3));
    addAxiomToOntology(factory.getOWLDisjointClassesAxiom(c3, c1));
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
    return FeatureCategory.CLASS_EXPRESSION_AXIOMS;
  }
}
