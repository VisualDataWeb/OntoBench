package de.linkvt.bachelor.features.axioms.objectproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlAsymmetricPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":hasMonitor");
    OWLClass range = featurePool.getExclusiveClass(":WideHdMonitor");
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
    return FeatureCategory.OBJECT_PROPERTY_AXIOMS;
  }
}
