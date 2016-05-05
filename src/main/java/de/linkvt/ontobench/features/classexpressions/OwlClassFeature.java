package de.linkvt.ontobench.features.classexpressions;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class OwlClassFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass owlClass = featurePool.getReusableClass();
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(owlClass);

    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:Class";
  }

  @Override
  public String getToken() {
    return "class";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS_EXPRESSIONS;
  }

  @Override
  public boolean isGeneral() {
    return true;
  }
}
