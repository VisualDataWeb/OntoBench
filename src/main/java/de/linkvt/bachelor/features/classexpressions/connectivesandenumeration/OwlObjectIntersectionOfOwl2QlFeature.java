package de.linkvt.bachelor.features.classexpressions.connectivesandenumeration;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectIntersectionOfOwl2QlFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass c1 = featurePool.getExclusiveClass(":ObjectIntersectionOf_QL_Class1");
    OWLClass c2 = featurePool.getExclusiveClass(":ObjectIntersectionOf_QL_Class2");
    OWLObjectIntersectionOf spork = factory.getOWLObjectIntersectionOf(c1, c2);

    OWLClass owlClass = featurePool.getExclusiveClass(":ObjectIntersectionOf_QL");

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(owlClass, spork));
  }

  @Override
  public String getName() {
    return "owl:intersectionOf (Class, OWL 2 QL)";
  }

  @Override
  public String getToken() {
    return "intersectionofqlclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CONNECTIVES_AND_ENUMERATION;
  }
}
