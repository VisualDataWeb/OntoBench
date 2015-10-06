package de.linkvt.bachelor.features.declarations;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.springframework.stereotype.Component;

@Component
public class OwlTopDataPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLTopDataProperty();
    OWLDatatype datatype = factory.getIntegerOWLDatatype();

    addToGenericDomainAndNewRange(property, datatype);
  }

  @Override
  public String getName() {
    return "owl:topDataProperty";
  }

  @Override
  public String getToken() {
    return "topdatatypeprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DECLARATIONS;
  }
}
