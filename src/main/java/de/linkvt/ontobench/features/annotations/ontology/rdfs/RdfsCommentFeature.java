package de.linkvt.ontobench.features.annotations.ontology.rdfs;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class RdfsCommentFeature extends Feature {

  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":propertyWithInfos");
    OWLClass range = featurePool.getExclusiveClass(":ClassWithInfos");

    OWLLiteral label = factory.getOWLLiteral("Comment of a property (undefined language)");
    OWLAnnotationProperty comment = factory.getRDFSComment();

    OWLAnnotation pA = factory.getOWLAnnotation(comment, label);
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), pA));

    OWLAnnotation cA = factory.getOWLAnnotation(comment, factory.getOWLLiteral("Comment of a class (undefined language)"));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(range.getIRI(), cA));

    addToGenericDomainAndNewRange(property, range);
  }

  @Override
  public String getName() {
    return "rdfs:comment";
  }

  @Override
  public String getClarification() {
    return "on Class & Property";
  }

  @Override
  public String getToken() {
    return "rdfscomment";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
