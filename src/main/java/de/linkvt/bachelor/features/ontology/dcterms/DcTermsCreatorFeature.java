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
public class DcTermsCreatorFeature extends Feature {

  @Autowired
  OntologyConstants ontologyConstants;

  @Override
  public void addToOntology() {
    OWLAnnotationProperty annotationProperty = factory.getOWLAnnotationProperty(IRI.create(Namespaces.DCTERMS + "creator"));
    OWLAnnotation dcCreator = factory.getOWLAnnotation(annotationProperty, factory.getOWLLiteral(ontologyConstants.getCreator()));

    addChangeToOntology(new AddOntologyAnnotation(ontology, dcCreator));
  }

  @Override
  public String getName() {
    return "dcterms:creator";
  }

  @Override
  public String getToken() {
    return "dctermscreator";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ONTOLOGY;
  }
}
