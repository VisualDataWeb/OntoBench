package de.linkvt.ontobench.features.annotations.ontology.dc;

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
public class DcTitleFeature extends Feature {

  @Autowired
  private OntologyConstants ontologyConstants;

  @Override
  public void addToOntology() {
    OWLAnnotationProperty property = factory.getOWLAnnotationProperty(IRI.create(Namespaces.DC + "title"));
    OWLAnnotation title = factory.getOWLAnnotation(property, factory.getOWLLiteral(ontologyConstants.getTitle()));

    addChangeToOntology(new AddOntologyAnnotation(ontology, title));
  }

  @Override
  public String getName() {
    return "dc:title";
  }

  @Override
  public String getToken() {
    return "dctitle";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DC;
  }
}
