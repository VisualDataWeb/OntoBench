package de.linkvt.ontobench.features.annotations;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.springframework.stereotype.Component;

@Component
public class OwlAnnotationPropertyFeature extends Feature {

  @Override
  public void addToOntology() {
    String ontologyIri = ontology.getOntologyID().getOntologyIRI().get().toString();
    OWLAnnotationProperty annotationProperty = factory.getOWLAnnotationProperty(IRI.create(ontologyIri + "customAnnotationProperty"));
    addAxiomToOntology(factory.getOWLDeclarationAxiom(annotationProperty));

    OWLLiteral annotationValue = factory.getOWLLiteral("Custom Annotation Value");
    OWLAnnotation annotation = factory.getOWLAnnotation(annotationProperty, annotationValue);

    OWLClass owlClass = featurePool.getReusableClass();
    addAxiomToOntology(factory.getOWLDeclarationAxiom(owlClass));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(owlClass.getIRI(), annotation));
  }

  @Override
  public String getName() {
    return "owl:AnnotationProperty";
  }

  @Override
  public String getToken() {
    return "annotationproperty";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
