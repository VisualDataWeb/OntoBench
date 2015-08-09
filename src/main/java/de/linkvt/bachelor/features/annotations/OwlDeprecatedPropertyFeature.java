package de.linkvt.bachelor.features.annotations;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlDeprecatedPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty("DeprecatedProperty");
    addToGenericDomainAndNewRange(property, featurePool.getExclusiveClass("DeprecatedPropertyRange"));

    OWLAnnotation annotation = factory.getOWLAnnotation(factory.getOWLDeprecated(), factory.getOWLLiteral(true));
    OWLAxiom deprecatedAxiom = factory.getOWLAnnotationAssertionAxiom(property.getIRI(), annotation);
    addAxiomToOntology(deprecatedAxiom);
  }

  @Override
  public String getName() {
    return "owl:DeprecatedProperty";
  }

  @Override
  public String getToken() {
    return "deprecatedprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
