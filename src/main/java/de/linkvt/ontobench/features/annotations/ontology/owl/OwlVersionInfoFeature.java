package de.linkvt.ontobench.features.annotations.ontology.owl;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;
import de.linkvt.ontobench.features.annotations.ontology.OntologyConstants;

import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OwlVersionInfoFeature extends Feature {

  @Autowired
  OntologyConstants ontologyConstants;

  @Override
  public void addToOntology() {
    OWLLiteral version = factory.getOWLLiteral(ontologyConstants.getVersion());
    OWLAnnotation owlVersionInfo = factory.getOWLAnnotation(factory.getOWLVersionInfo(), version);

    addChangeToOntology(new AddOntologyAnnotation(ontology, owlVersionInfo));
  }

  @Override
  public String getName() {
    return "owl:versionInfo";
  }

  @Override
  public String getToken() {
    return "owlversioninfo";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
