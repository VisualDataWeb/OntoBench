package de.linkvt.ontobench.features.axioms.objectproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlIrreflexivePropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":irreflexiveObjectProperty");
    OWLClass range = featurePool.getExclusiveClass(":IrreflexiveObjectPropertyRange");
    addToGenericDomainAndNewRange(property, range);

    addAxiomToOntology(factory.getOWLIrreflexiveObjectPropertyAxiom(property));
  }

  @Override
  public String getName() {
    return "owl:IrreflexiveProperty";
  }

  @Override
  public String getToken() {
    return "irreflexiveprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
  }
}
