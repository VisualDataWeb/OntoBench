package de.linkvt.bachelor.features.ontology.dc;

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
public class DcContributorFeature extends Feature {

  @Autowired
  OntologyConstants ontologyConstants;

  @Override
  public void addToOntology() {
    OWLAnnotationProperty annotationProperty = factory.getOWLAnnotationProperty(IRI.create(Namespaces.DC + "contributor"));
    OWLAnnotation dcContributor = factory.getOWLAnnotation(annotationProperty, factory.getOWLLiteral(ontologyConstants.getContributor()));

    addChangeToOntology(new AddOntologyAnnotation(ontology, dcContributor));
  }

  @Override
  public String getName() {
    return "dc:contributor";
  }

  @Override
  public String getToken() {
    return "dccontributor";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ONTOLOGY;
  }
}
