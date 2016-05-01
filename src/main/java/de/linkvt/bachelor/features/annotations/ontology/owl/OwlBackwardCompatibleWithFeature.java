package de.linkvt.bachelor.features.annotations.ontology.owl;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;
import de.linkvt.bachelor.features.annotations.ontology.OntologyConstants;

import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlBackwardCompatibleWithFeature extends Feature {

  private static final String OWL_BACKWARD_COMPATIBLE_WITH = "owl:backwardCompatibleWith";

  @Override
  public void addToOntology() {
    OWLAnnotationProperty annotationProperty = factory.getOWLAnnotationProperty(OWL_BACKWARD_COMPATIBLE_WITH, pm);
    IRI value = OntologyConstants.ONTOVIBE_MINIMAL_IRI;
    OWLAnnotation annotation = factory.getOWLAnnotation(annotationProperty, value);

    addChangeToOntology(new AddOntologyAnnotation(ontology, annotation));
  }

  @Override
  public String getName() {
    return OWL_BACKWARD_COMPATIBLE_WITH;
  }

  @Override
  public String getToken() {
    return "owlbackwardcompatiblewith";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
