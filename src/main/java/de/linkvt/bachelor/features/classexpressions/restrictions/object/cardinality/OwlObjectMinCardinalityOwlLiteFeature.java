package de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectMinCardinalityOwlLiteFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectMinCardinalityProperty_Lite");
    OWLClass range = featurePool.getExclusiveClass(":ObjectMinCardinalityRange_Lite");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectMinCardinality minCardinality = factory.getOWLObjectMinCardinality(0, property);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, minCardinality));
  }

  @Override
  public String getName() {
    return "owl:minCardinality (Object Property, OWL Lite)";
  }

  @Override
  public String getToken() {
    return "mincardinalitylite";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
