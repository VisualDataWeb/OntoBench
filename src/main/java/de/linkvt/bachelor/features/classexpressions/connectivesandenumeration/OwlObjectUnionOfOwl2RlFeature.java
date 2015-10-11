package de.linkvt.bachelor.features.classexpressions.connectivesandenumeration;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectUnionOfOwl2RlFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass c1 = featurePool.getExclusiveClass(":ObjectUnionOf_RL_Class1");
    OWLClass c2 = featurePool.getExclusiveClass(":ObjectUnionOf_RL_Class2");
    OWLClass c3 = featurePool.getExclusiveClass(":ObjectUnionOf_RL_Class3");
    OWLObjectUnionOf unionOf = factory.getOWLObjectUnionOf(c1, c2, c3);

    OWLClass unionClass = featurePool.getExclusiveClass(":ObjectUnionOf_RL");

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(unionOf, unionClass));
  }

  @Override
  public String getName() {
    return "owl:unionOf (adjusted to OWL 2 RL)";
  }

  @Override
  public String getToken() {
    return "unionrlclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS_EXPRESSIONS;
  }
}
