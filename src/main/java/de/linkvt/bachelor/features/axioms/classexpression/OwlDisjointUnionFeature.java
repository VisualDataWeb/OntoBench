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
    OWLClass c1 = featurePool.getExclusiveClass(":DisjointUnion_Class1");
    OWLClass c2 = featurePool.getExclusiveClass(":DisjointUnion_Class2");
    OWLClass disjointUnionClass = featurePool.getExclusiveClass(":DisjointUnion");

    addAxiomToOntology(factory.getOWLDisjointUnionAxiom(disjointUnionClass, new HashSet<>(Arrays.asList(c1, c2))));
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
