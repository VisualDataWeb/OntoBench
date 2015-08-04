package de.linkvt.bachelor.features.ontology.dcterms;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;
import de.linkvt.bachelor.features.ontology.OntologyConstants;

import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.vocab.Namespaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DcTermsContributorFeature extends Feature {

  @Autowired
  OntologyConstants ontologyConstants;

  @Override
  public void addToOntology() {
    OWLAnnotationProperty annotationProperty = factory.getOWLAnnotationProperty(IRI.create(Namespaces.DCTERMS + "contributor"));
    OWLAnnotation dcContributor = factory.getOWLAnnotation(annotationProperty, factory.getOWLLiteral(ontologyConstants.getContributor()));

    addChangeToOntology(new AddOntologyAnnotation(ontology, dcContributor));
  }

  @Override
  public String getName() {
    return "dcterms:contributor";
  }

  @Override
  public String getToken() {
    return "dctermscontributor";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ONTOLOGY;
  }
}
