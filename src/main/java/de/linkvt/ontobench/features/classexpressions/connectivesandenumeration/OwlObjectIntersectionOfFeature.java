package de.linkvt.ontobench.features.classexpressions.connectivesandenumeration;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectIntersectionOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass c1 = featurePool.getExclusiveClass(":ObjectIntersectionOf_Class1");
    OWLClass c2 = featurePool.getExclusiveClass(":ObjectIntersectionOf_Class2");
    OWLObjectIntersectionOf spork = factory.getOWLObjectIntersectionOf(c1, c2);

    OWLClass owlClass = featurePool.getExclusiveClass(":ObjectIntersectionOf");

    OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(owlClass, spork);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:intersectionOf";
  }

  @Override
  public String getToken() {
    return "intersectionofclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS_EXPRESSIONS;
  }
}
