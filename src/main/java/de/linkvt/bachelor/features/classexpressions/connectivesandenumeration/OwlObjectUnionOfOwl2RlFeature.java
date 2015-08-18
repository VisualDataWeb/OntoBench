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
    OWLClass a = featurePool.getExclusiveClass(":UnionClassA");
    OWLClass b = featurePool.getExclusiveClass(":UnionClassB");
    OWLClass c = featurePool.getExclusiveClass(":UnionClassC");
    OWLObjectUnionOf unionOf = factory.getOWLObjectUnionOf(a, b, c);

    OWLClass abc = featurePool.getExclusiveClass(":UnionOfABC");

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(unionOf, abc));
  }

  @Override
  public String getName() {
    return "owl:unionOf (Class, OWL 2 RL)";
  }

  @Override
  public String getToken() {
    return "unionrlclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CONNECTIVES_AND_ENUMERATION;
  }
}
