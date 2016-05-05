package de.linkvt.ontobench.features.annotations.ontology.rdfs;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;
import de.linkvt.ontobench.features.annotations.ontology.OntologyConstants;

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
    return "rdfs:comment";
  }

  @Override
  public String getClarification() {
    return "on Ontology";
  }

  @Override
  public String getToken() {
    return "rdfscommentontology";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
