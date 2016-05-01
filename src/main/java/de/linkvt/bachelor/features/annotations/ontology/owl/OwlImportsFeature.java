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
public class OwlImportsFeature extends Feature {

  private static final String OWL_IMPORTS = "owl:imports";

  @Override
  public void addToOntology() {
    OWLAnnotationProperty annotationProperty = factory.getOWLAnnotationProperty(OWL_IMPORTS, pm);
    IRI value = OntologyConstants.ONTOVIBE_MINIMAL_IRI;
    OWLAnnotation annotation = factory.getOWLAnnotation(annotationProperty, value);

    addChangeToOntology(new AddOntologyAnnotation(ontology, annotation));
  }

  @Override
  public String getName() {
    return OWL_IMPORTS;
  }

  @Override
  public String getToken() {
    return "owlimports";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
