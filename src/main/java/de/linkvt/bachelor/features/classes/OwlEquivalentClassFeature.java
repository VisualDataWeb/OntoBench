package de.linkvt.bachelor.features.classes;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.web.converters.parameter.ParameterName;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Multiple equivalent owl classes.
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
@ParameterName("equivalentclass")
public class OwlEquivalentClassFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass owlClass = featurePool.getReusableClassAndRemoveFromPool();
    OWLClass equivalentClass1 = featurePool.getExclusiveClass("EquivalentClass1");
    OWLClass equivalentClass2 = featurePool.getExclusiveClass("EquivalentClass2");
    OWLAxiom equivalentAxiom = factory.getOWLEquivalentClassesAxiom(owlClass, equivalentClass1, equivalentClass2);

    addAxiomToOntology(equivalentAxiom);
  }
}
