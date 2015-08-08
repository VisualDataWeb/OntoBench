package de.linkvt.bachelor.features.annotations.rdfs;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

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
    OWLObjectProperty property = featurePool.getExclusiveProperty("propertyWithInfos");
    OWLClass range = featurePool.getExclusiveClass("ClassWithInfos");

    OWLLiteral label = factory.getOWLLiteral("Comment of a property (undefined language)");
    OWLLiteral deLabel = factory.getOWLLiteral("Kommentar einer Property", "de");
    OWLLiteral enLabel = factory.getOWLLiteral("Comment of a property", "en");
    OWLLiteral jpLabel = factory.getOWLLiteral("プロパティのコメント", "jp");

    OWLAnnotationProperty annotationProperty = factory.getRDFSComment();
    OWLAnnotation annotation = factory.getOWLAnnotation(annotationProperty, label);
    OWLAnnotation deAnnotation = factory.getOWLAnnotation(annotationProperty, deLabel);
    OWLAnnotation enAnnotation = factory.getOWLAnnotation(annotationProperty, enLabel);
    OWLAnnotation jpAnnotation = factory.getOWLAnnotation(annotationProperty, jpLabel);

    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), annotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), deAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), enAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), jpAnnotation));

    addToGenericDomainAndNewRange(property, range);
  }

  @Override
  public String getName() {
    return "rdfs:comment";
  }

  @Override
  public String getToken() {
    return "rdfscomment";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATION;
  }
}
