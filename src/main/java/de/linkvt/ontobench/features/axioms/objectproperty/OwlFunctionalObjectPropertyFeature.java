package de.linkvt.ontobench.features.axioms.objectproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlFunctionalObjectPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":functionalObjectProperty");
    OWLClass range = featurePool.getExclusiveClass(":FunctionalObjectPropertyRange");
    addToGenericDomainAndNewRange(property, range);

    addAxiomToOntology(factory.getOWLFunctionalObjectPropertyAxiom(property));
  }

  @Override
  public String getName() {
    return "owl:FunctionalProperty";
  }

  @Override
  public String getToken() {
    return "functionalprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
  }
}
