package de.linkvt.ontobench.features.annotations.ontology.dcterms;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;
import de.linkvt.ontobench.features.annotations.ontology.OntologyConstants;

import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.vocab.Namespaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DcTermsDateFeature extends Feature {

  @Autowired
  private OntologyConstants ontologyConstants;

  @Override
  public void addToOntology() {
    OWLAnnotationProperty property = factory.getOWLAnnotationProperty(IRI.create(Namespaces.DCTERMS + "date"));
    OWLAnnotation date = factory.getOWLAnnotation(property, factory.getOWLLiteral(ontologyConstants.getGenerationDate()));

    addChangeToOntology(new AddOntologyAnnotation(ontology, date));
  }

  @Override
  public String getName() {
    return "dcterms:date";
  }

  @Override
  public String getToken() {
    return "dctermsdate";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DC;
  }
}
