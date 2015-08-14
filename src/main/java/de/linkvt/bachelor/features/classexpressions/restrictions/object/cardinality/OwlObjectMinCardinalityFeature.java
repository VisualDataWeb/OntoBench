package de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectMinCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();
    OWLClass range = featurePool.getExclusiveClass(":MinCardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectMinCardinality minCardinality = factory.getOWLObjectMinCardinality(2, property);
    OWLAxiom axiom = factory.getOWLSubClassOfAxiom(range, minCardinality);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:minCardinality (Object Property)";
  }

  @Override
  public String getToken() {
    return "mincardinality";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
