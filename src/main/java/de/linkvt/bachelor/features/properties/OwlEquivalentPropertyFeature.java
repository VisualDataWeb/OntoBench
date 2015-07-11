package de.linkvt.bachelor.features.properties;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.web.converters.parameter.ParameterName;

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
@ParameterName("equivalentprop")
public class OwlEquivalentPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty("EquivalentPropertyBase");
    OWLObjectProperty equivalentProperty1 = featurePool.getExclusiveProperty("EquivalentProperty1");
    OWLObjectProperty equivalentProperty2 = featurePool.getExclusiveProperty("EquivalentProperty2");

    OWLAxiom equivalentAxiom = factory.getOWLEquivalentObjectPropertiesAxiom(property, equivalentProperty1, equivalentProperty2);

    OWLClass range = featurePool.getExclusiveClass("EquivalentPropertyRange");
    addToGenericDomainAndNewRange(property, range);

    addAxiomToOntology(equivalentAxiom);
  }
}
