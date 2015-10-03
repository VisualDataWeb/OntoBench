package de.linkvt.bachelor.features.classexpressions.connectivesandenumeration;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectUnionOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass c1 = featurePool.getExclusiveClass(":ObjectUnionOf_1");
    OWLClass c2 = featurePool.getExclusiveClass(":ObjectUnionOf_2");
    OWLClass c3 = featurePool.getExclusiveClass(":ObjectUnionOf_3");
    OWLObjectUnionOf unionOf = factory.getOWLObjectUnionOf(c1, c2, c3);

    OWLClass unionClass = featurePool.getExclusiveClass(":ObjectUnionOf");

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(unionClass, unionOf));
  }

  @Override
  public String getName() {
    return "owl:unionOf (Class)";
  }

  @Override
  public String getToken() {
    return "unionclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CONNECTIVES_AND_ENUMERATION;
  }
}
