package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * An owl equivalent property.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class OwlEquivalentPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty("EquivalentPropertyBase");
    OWLObjectProperty equivalentProperty1 = featurePool.getExclusiveProperty("EquivalentProperty1");
    OWLObjectProperty equivalentProperty2 = featurePool.getExclusiveProperty("EquivalentProperty2");

    OWLAxiom equivalent1Axiom = factory.getOWLEquivalentObjectPropertiesAxiom(property, equivalentProperty1);
    OWLAxiom equivalent2Axiom = factory.getOWLEquivalentObjectPropertiesAxiom(property, equivalentProperty2);

    OWLClass equivalentDomain = featurePool.getReusableClass();
    OWLClass equivalentRange = featurePool.getExclusiveClass("EquivalentPropertyTest");
    OWLAxiom domainAxiom = factory.getOWLObjectPropertyDomainAxiom(property, equivalentDomain);
    OWLAxiom rangeAxiom = factory.getOWLObjectPropertyRangeAxiom(property, equivalentRange);

    addToOntology(ontology, equivalent1Axiom);
    addToOntology(ontology, equivalent2Axiom);
    addToOntology(ontology, domainAxiom);
    addToOntology(ontology, rangeAxiom);
  }
}
