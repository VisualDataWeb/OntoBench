package de.linkvt.bachelor.features.classexpressions.connectivesandenumeration;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectIntersectionOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass c1 = featurePool.getExclusiveClass(":ObjectIntersectionOf_1");
    OWLClass c2 = featurePool.getExclusiveClass(":ObjectIntersectionOf_2");
    OWLObjectIntersectionOf spork = factory.getOWLObjectIntersectionOf(c1, c2);

    OWLClass owlClass = featurePool.getExclusiveClass(":ObjectIntersectionOf");

    OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(owlClass, spork);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:intersectionOf (Class)";
  }

  @Override
  public String getToken() {
    return "intersectionofclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CONNECTIVES_AND_ENUMERATION;
  }
}
