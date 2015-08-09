package de.linkvt.bachelor.features.annotations.ontology.rdfs;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class RdfsLabelMultiLanguageFeature extends Feature {

  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty("propertyWithInfos");
    OWLClass range = featurePool.getExclusiveClass("ClassWithInfos");
    OWLAnnotationProperty label = factory.getRDFSLabel();

    OWLAnnotation deAnnotation = factory.getOWLAnnotation(label, factory.getOWLLiteral("Bezeichnung einer Property", "de"));
    OWLAnnotation enAnnotation = factory.getOWLAnnotation(label, factory.getOWLLiteral("Label of a property", "en"));
    OWLAnnotation jpAnnotation = factory.getOWLAnnotation(label, factory.getOWLLiteral("プロパティの指定", "jp"));

    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), deAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), enAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), jpAnnotation));


    OWLAnnotation enClassAnnotation = factory.getOWLAnnotation(label, factory.getOWLLiteral("Label of a class", "en"));
    OWLAnnotation deClassAnnotation = factory.getOWLAnnotation(label, factory.getOWLLiteral("Bezeichnung einer Klasse", "de"));
    OWLAnnotation jpClassAnnotation = factory.getOWLAnnotation(label, factory.getOWLLiteral("どうもありがとうミスターロボット", "jp"));

    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(range.getIRI(), enClassAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(range.getIRI(), deClassAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(range.getIRI(), jpClassAnnotation));


    addToGenericDomainAndNewRange(property, range);
  }

  @Override
  public String getName() {
    return "rdfs:label (Class & Property, multilingual)";
  }

  @Override
  public String getToken() {
    return "rdfslabelmultilanguage";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
