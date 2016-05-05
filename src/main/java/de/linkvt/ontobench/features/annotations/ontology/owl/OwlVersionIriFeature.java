package de.linkvt.ontobench.features.annotations.ontology.owl;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OwlVersionIriFeature extends Feature {

  private static final String OWL_VERSION_IRI = "owl:versionIri";

  @Override
  public void addToOntology() {
    Optional<IRI> iri = ontology.getOntologyID().getDefaultDocumentIRI();
    assert iri.isPresent();

    OWLAnnotationProperty annotationProperty = factory.getOWLAnnotationProperty(OWL_VERSION_IRI, pm);
    OWLAnnotation annotation = factory.getOWLAnnotation(annotationProperty, iri.get());

    addChangeToOntology(new AddOntologyAnnotation(ontology, annotation));
  }

  @Override
  public String getName() {
    return OWL_VERSION_IRI;
  }

  @Override
  public String getToken() {
    return "owlversioniri";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
