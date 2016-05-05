package de.linkvt.ontobench.features.axioms.objectproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlAsymmetricPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":asymmetricProperty");
    OWLClass range = featurePool.getExclusiveClass(":AsymmetricObjectPropertyRange");
    addToGenericDomainAndNewRange(property, range);

    addAxiomToOntology(factory.getOWLAsymmetricObjectPropertyAxiom(property));
  }

  @Override
  public String getName() {
    return "owl:AsymmetricProperty";
  }

  @Override
  public String getToken() {
    return "asymmetricprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
  }
}
