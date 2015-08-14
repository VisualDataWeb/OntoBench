package de.linkvt.bachelor.features.annotations.ontology.rdfs;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class RdfsLabelFeature extends Feature {

  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":propertyWithInfos");
    OWLClass range = featurePool.getExclusiveClass(":ClassWithInfos");
    OWLAnnotationProperty label = factory.getRDFSLabel();

    OWLAnnotation pA = factory.getOWLAnnotation(label, factory.getOWLLiteral("Label of a property (undefined language)"));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), pA));

    OWLAnnotation cA = factory.getOWLAnnotation(label, factory.getOWLLiteral("Label of a class (undefined language)"));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(range.getIRI(), cA));

    addToGenericDomainAndNewRange(property, range);
  }

  @Override
  public String getName() {
    return "rdfs:label (Class & Property)";
  }

  @Override
  public String getToken() {
    return "rdfslabel";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
