package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

/**
 * An owl functional property.
 */
@Component
public class OwlInverseOfPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getReusableClass();
    OWLClass range = featurePool.getExclusiveClass("Child");

    OWLObjectProperty property = featurePool.getExclusiveProperty("hasChild");
    addAxiomToOntology(factory.getOWLObjectPropertyDomainAxiom(property, domain));
    addAxiomToOntology(factory.getOWLObjectPropertyRangeAxiom(property, range));

    OWLObjectProperty inverseProperty = featurePool.getExclusiveProperty("hasParent");
    addAxiomToOntology(factory.getOWLObjectPropertyDomainAxiom(inverseProperty, range));
    addAxiomToOntology(factory.getOWLObjectPropertyRangeAxiom(inverseProperty, domain));

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
}
