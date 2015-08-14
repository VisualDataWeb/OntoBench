package de.linkvt.bachelor.features.axioms.objectproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlEquivalentObjectPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":EquivalentPropertyBase");
    OWLObjectProperty equivalentProperty1 = featurePool.getExclusiveProperty(":EquivalentProperty1");
    OWLObjectProperty equivalentProperty2 = featurePool.getExclusiveProperty(":EquivalentProperty2");

    OWLAxiom equivalentAxiom = factory.getOWLEquivalentObjectPropertiesAxiom(property, equivalentProperty1, equivalentProperty2);

    OWLClass range = featurePool.getExclusiveClass(":EquivalentPropertyRange");
    addToGenericDomainAndNewRange(property, range);

    addAxiomToOntology(equivalentAxiom);
  }

  @Override
  public String getName() {
    return "owl:equivalentProperty (Object Property)";
  }

  @Override
  public String getToken() {
    return "equivalentprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_AXIOMS;
  }
}
