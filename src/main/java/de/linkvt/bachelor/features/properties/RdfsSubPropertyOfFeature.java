package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class RdfsSubPropertyOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass start = featurePool.getReusableClass();
    OWLClass middle = featurePool.getReusableClossDifferentFrom(start);
    OWLClass end = featurePool.getReusableClossDifferentFrom(start, middle);

    OWLObjectProperty subProperty = featurePool.getExclusiveProperty("SubProperty");
    OWLObjectProperty superProperty = featurePool.getExclusiveProperty("SuperProperty");
    addProperty(subProperty, start, middle);
    addProperty(superProperty, middle, end);

    OWLAxiom axiom = factory.getOWLSubObjectPropertyOfAxiom(subProperty, superProperty);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "rdfs:subPropertyOf";
  }

  @Override
  public String getToken() {
    return "subprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.PROPERTY;
  }
}
