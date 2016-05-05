package de.linkvt.ontobench.features.axioms.objectproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlTopObjectPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty objectProperty = factory.getOWLTopObjectProperty();
    OWLClass range = featurePool.getExclusiveClass(":TopObjectPropertyRange");

    addToGenericDomainAndNewRange(objectProperty, range);
  }

  @Override
  public String getName() {
    return "owl:topObjectProperty";
  }

  @Override
  public String getToken() {
    return "topobjectprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
  }

  @Override
  public boolean isGeneral() {
    return true;
  }
}
