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
    OWLClass start = featurePool.getReusableClass();
    OWLClass middle = featurePool.getExclusiveClass(":PropertyChainMiddle");
    OWLClass end = featurePool.getExclusiveClass(":PropertyChainEnd");

    OWLObjectProperty singleStep = featurePool.getExclusiveProperty(":propertyChainProperty_SingleStep");
    OWLObjectProperty doubleStep = featurePool.getExclusiveProperty(":propertyChainProperty_DoubleStep");

    List<OWLObjectProperty> propertyChain = Arrays.asList(singleStep, singleStep);
    addAxiomToOntology(factory.getOWLSubPropertyChainOfAxiom(propertyChain, doubleStep));

    addProperty(end, singleStep, middle);
    addProperty(middle, singleStep, start);
    addProperty(end, doubleStep, start);
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
    return FeatureCategory.OBJECT_PROPERTIES;
  }
}
