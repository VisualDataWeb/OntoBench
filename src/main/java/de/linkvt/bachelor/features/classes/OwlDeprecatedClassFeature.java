package de.linkvt.bachelor.features.classes;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

/**
 * A deprecated owl class.
 */
@Component
public class OwlDeprecatedClassFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass owlClass = featurePool.getExclusiveClass("DeprecatedClass");
    OWLAxiom axiom = factory.getOWLDeclarationAxiom(owlClass);
    addAxiomToOntology(axiom);

    OWLAnnotation annotation = factory.getOWLAnnotation(factory.getOWLDeprecated(), factory.getOWLLiteral(true));
    OWLAxiom annotationAxiom = factory.getOWLAnnotationAssertionAxiom(owlClass.getIRI(), annotation);
    addAxiomToOntology(annotationAxiom);
  }

  @Override
  public String getName() {
    return "owl:DeprecatedClass";
  }

  @Override
  public String getToken() {
    return "deprecatedclass";
  }
}
