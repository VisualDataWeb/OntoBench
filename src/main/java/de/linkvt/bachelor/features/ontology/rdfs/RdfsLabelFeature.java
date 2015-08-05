package de.linkvt.bachelor.features.ontology.rdfs;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;
import de.linkvt.bachelor.features.ontology.OntologyConstants;

import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RdfsLabelFeature extends Feature {

  @Autowired
  OntologyConstants ontologyConstants;

  @Override
  public void addToOntology() {
    OWLLiteral titleLiteral = factory.getOWLLiteral(ontologyConstants.getTitle());
    OWLAnnotation title = factory.getOWLAnnotation(factory.getRDFSLabel(), titleLiteral);

    addChangeToOntology(new AddOntologyAnnotation(ontology, title));
  }

  @Override
  public String getName() {
    return "rdfs:label";
  }

  @Override
  public String getToken() {
    return "rdfslabel";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ONTOLOGY;
  }
}
