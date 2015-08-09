package de.linkvt.bachelor.features.classexpressions.connectivesandenumeration;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectUnionOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass fork = featurePool.getExclusiveClass("Fork");
    OWLClass knife = featurePool.getExclusiveClass("Knife");
    OWLClass spoon = featurePool.getExclusiveClass("Spoon");
    OWLObjectUnionOf unionOf = factory.getOWLObjectUnionOf(fork, knife, spoon);

    OWLClass cutlery = factory.getOWLClass(IRI.create("Cutlery"));

    OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(cutlery, unionOf);
    addAxiomToOntology(axiom);
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
