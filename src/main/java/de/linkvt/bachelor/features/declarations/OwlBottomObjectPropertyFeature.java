package de.linkvt.bachelor.features.declarations;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlBottomObjectPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty objectProperty = factory.getOWLBottomObjectProperty();
    OWLClass range = featurePool.getExclusiveClass(":BottomObjectPropertyRange");

    addToGenericDomainAndNewRange(objectProperty, range);
  }

  @Override
  public String getName() {
    return "owl:bottomObjectProperty";
  }

  @Override
  public String getToken() {
    return "bottomobjectprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DECLARATIONS;
  }

  @Override
  public boolean isGeneral() {
    return true;
  }
}
