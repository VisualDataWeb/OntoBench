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
    OWLClass leftBrain = featurePool.getExclusiveClass(":LeftHemisphere");
    OWLClass rightBrain = featurePool.getExclusiveClass(":RightHemisphere");
    OWLClass brain = featurePool.getExclusiveClass(":BrainHemisphere");

    addAxiomToOntology(factory.getOWLDisjointUnionAxiom(brain, new HashSet<>(Arrays.asList(leftBrain, rightBrain))));
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
