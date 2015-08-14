package de.linkvt.bachelor.features.axioms.classexpression;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class OwlDisjointUnionFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass boy = featurePool.getExclusiveClass(":Boy");
    OWLClass girl = featurePool.getExclusiveClass(":Girl");
    OWLClass child = featurePool.getExclusiveClass(":Child");

    addAxiomToOntology(factory.getOWLDisjointUnionAxiom(child, new HashSet<>(Arrays.asList(boy, girl))));
  }

  @Override
  public String getName() {
    return "owl:disjointUnionOf";
  }

  @Override
  public String getToken() {
    return "disjointunion";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS_EXPRESSION_AXIOMS;
  }
}
