package de.linkvt.ontobench.features.axioms.objectproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlReflexivePropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":reflexiveObjectProperty");
    OWLClass range = featurePool.getExclusiveClass(":ReflexiveObjectPropertyRange");
    addToGenericDomainAndNewRange(property, range);

    addAxiomToOntology(factory.getOWLReflexiveObjectPropertyAxiom(property));
  }

  @Override
  public String getName() {
    return "owl:ReflexiveProperty";
  }

  @Override
  public String getToken() {
    return "reflexiveprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
  }
}
