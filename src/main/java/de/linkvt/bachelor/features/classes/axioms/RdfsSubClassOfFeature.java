package de.linkvt.bachelor.features.classes.axioms;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

/**
 * The rdfs:subClassOf axiom.
 */
@Component
public class RdfsSubClassOfFeature extends Feature {

  @Override
  public void addToOntology() {
    OWLClass superClass = featurePool.getExclusiveClass("SuperClass");
    OWLClass subClass = featurePool.getExclusiveClass("SubClass");
    OWLAxiom subClassOfAxiom = factory.getOWLSubClassOfAxiom(subClass, superClass);

    addAxiomToOntology(subClassOfAxiom);
  }

  @Override
  public String getName() {
    return "rdfs:subClassOf";
  }

  @Override
  public String getToken() {
    return "subclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
