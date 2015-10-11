package de.linkvt.bachelor.features.axioms.objectproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class RdfsObjectSubPropertyOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass start = featurePool.getReusableClass();
    OWLClass middle = featurePool.getReusableClassDifferentFrom(start);
    OWLClass end = featurePool.getReusableClassDifferentFrom(start, middle);

    OWLObjectProperty subProperty = featurePool.getExclusiveProperty(":subObjectProperty");
    OWLObjectProperty superProperty = featurePool.getExclusiveProperty(":superObjectProperty");
    addProperty(start, subProperty, middle);
    addProperty(middle, superProperty, end);

    OWLAxiom axiom = factory.getOWLSubObjectPropertyOfAxiom(subProperty, superProperty);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "rdfs:subPropertyOf";
  }

  @Override
  public String getToken() {
    return "subpropobject";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
  }
}
