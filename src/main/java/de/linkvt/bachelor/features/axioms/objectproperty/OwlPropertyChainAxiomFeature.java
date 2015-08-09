package de.linkvt.bachelor.features.axioms.objectproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class OwlPropertyChainAxiomFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass grandParent = featurePool.getReusableClass();
    OWLClass parent = featurePool.getExclusiveClass("Parent");
    OWLClass child = featurePool.getExclusiveClass("Child");

    OWLObjectProperty hasParent = featurePool.getExclusiveProperty("hasParent");
    OWLObjectProperty hasGrandParent = featurePool.getExclusiveProperty("hasGrandParent");

    List<OWLObjectProperty> propertyChain = Arrays.asList(hasParent, hasParent);
    addAxiomToOntology(factory.getOWLSubPropertyChainOfAxiom(propertyChain, hasGrandParent));

    addProperty(child, hasParent, parent);
    addProperty(parent, hasParent, grandParent);
    addProperty(child, hasGrandParent, grandParent);
  }

  @Override
  public String getName() {
    return "owl:PropertyChainAxiom";
  }

  @Override
  public String getToken() {
    return "propertychain";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_AXIOMS;
  }
}
