package de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectCardinalityOwlLiteFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectExactCardinalityProperty_Lite");
    OWLClass range = featurePool.getExclusiveClass(":ObjectExactCardinalityRange_Lite");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectExactCardinality exactCardinality = factory.getOWLObjectExactCardinality(1, property);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, exactCardinality));
  }

  @Override
  public String getName() {
    return "owl:cardinality";
  }

  @Override
  public String getCompliance() {
    return "OWL Lite";
  }

  @Override
  public String getToken() {
    return "cardinalitylite";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
