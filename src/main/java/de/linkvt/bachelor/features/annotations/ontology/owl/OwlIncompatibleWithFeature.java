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
public class OwlIncompatibleWithFeature extends Feature {

  private static final String OWL_INCOMPATIBLE_WITH = "owl:incompatibleWith";

  @Override
  public void addToOntology() {
    OWLAnnotationProperty annotationProperty = factory.getOWLAnnotationProperty(OWL_INCOMPATIBLE_WITH, pm);
    IRI value = OntologyConstants.ONTOVIBE_CORE_IRI;
    OWLAnnotation annotation = factory.getOWLAnnotation(annotationProperty, value);

    addChangeToOntology(new AddOntologyAnnotation(ontology, annotation));
  }

  @Override
  public String getName() {
    return OWL_INCOMPATIBLE_WITH;
  }

  @Override
  public String getToken() {
    return "owlincompatiblewith";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
