package de.linkvt.ontobench.features.axioms.classexpression;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class OwlAllDisjointClassesFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass c1 = featurePool.getExclusiveClass(":AllDisjointClasses_Class1");
    OWLClass c2 = featurePool.getExclusiveClass(":AllDisjointClasses_Class2");
    OWLClass c3 = featurePool.getExclusiveClass(":AllDisjointClasses_Class3");

    addAxiomToOntology(factory.getOWLDisjointClassesAxiom(c1, c2, c3));
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
