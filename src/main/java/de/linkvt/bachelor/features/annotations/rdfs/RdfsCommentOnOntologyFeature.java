package de.linkvt.bachelor.features.annotations.rdfs;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;
import de.linkvt.bachelor.features.annotations.OntologyConstants;

import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RdfsCommentOnOntologyFeature extends Feature {

  @Autowired
  OntologyConstants ontologyConstants;

  @Override
  public void addToOntology() {
    OWLLiteral descriptionLiteral = factory.getOWLLiteral(ontologyConstants.getDescription());
    OWLAnnotation comment = factory.getOWLAnnotation(factory.getRDFSComment(), descriptionLiteral);

    addChangeToOntology(new AddOntologyAnnotation(ontology, comment));
  }

  @Override
  public String getName() {
    return "rdfs:comment on Ontology";
  }

  @Override
  public String getToken() {
    return "rdfscommentontology";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATION;
  }
}
