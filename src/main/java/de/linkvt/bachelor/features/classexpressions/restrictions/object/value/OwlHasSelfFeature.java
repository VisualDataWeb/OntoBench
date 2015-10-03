package de.linkvt.bachelor.features.classexpressions.restrictions.object.value;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlHasSelfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":hasSelfProperty");

    OWLClass hasSelf = featurePool.getExclusiveClass(":HasSelfClass");

    OWLObjectHasSelf restriction = factory.getOWLObjectHasSelf(property);
    addAxiomToOntology(factory.getOWLEquivalentClassesAxiom(hasSelf, restriction));
  }

  @Override
  public String getName() {
    return "owl:hasSelf";
  }

  @Override
  public String getToken() {
    return "hasself";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
