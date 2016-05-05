package de.linkvt.ontobench.features.axioms.objectproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlInverseOfPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getReusableClass();
    OWLClass range = featurePool.getExclusiveClass(":InverseOfPropertyRange");

    OWLObjectProperty property = featurePool.getExclusiveProperty(":nonInverseProperty");
    addProperty(domain, property, range);

    OWLObjectProperty inverseProperty = featurePool.getExclusiveProperty(":inverseProperty");
    addProperty(range, inverseProperty, domain);

    addAxiomToOntology(factory.getOWLInverseObjectPropertiesAxiom(property, inverseProperty));
  }

  @Override
  public String getName() {
    return "owl:inverseOf";
  }

  @Override
  public String getToken() {
    return "inverseprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
  }
}
