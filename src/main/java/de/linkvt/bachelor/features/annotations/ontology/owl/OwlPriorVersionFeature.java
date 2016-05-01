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
public class OwlPriorVersionFeature extends Feature {

  private static final String OWL_PRIOR_VERSION = "owl:priorVersion";

  @Override
  public void addToOntology() {
    OWLAnnotationProperty annotationProperty = factory.getOWLAnnotationProperty(OWL_PRIOR_VERSION, pm);
    IRI value = OntologyConstants.ONTOVIBE_CORE_IRI;
    OWLAnnotation annotation = factory.getOWLAnnotation(annotationProperty, value);

    addChangeToOntology(new AddOntologyAnnotation(ontology, annotation));
  }

  @Override
  public String getName() {
    return OWL_PRIOR_VERSION;
  }

  @Override
  public String getToken() {
    return "owlpriorversion";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
