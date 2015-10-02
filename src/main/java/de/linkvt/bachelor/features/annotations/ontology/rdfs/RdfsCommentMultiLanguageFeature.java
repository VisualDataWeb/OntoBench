package de.linkvt.bachelor.features.annotations.ontology.rdfs;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class RdfsCommentMultiLanguageFeature extends Feature {

  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":propertyWithInfos");
    OWLClass range = featurePool.getExclusiveClass(":ClassWithInfos");
    OWLAnnotationProperty comment = factory.getRDFSComment();

    OWLAnnotation enAnnotation = factory.getOWLAnnotation(comment, factory.getOWLLiteral("Comment of a property", Locale.ENGLISH.getLanguage()));
    OWLAnnotation deAnnotation = factory.getOWLAnnotation(comment, factory.getOWLLiteral("Kommentar einer Property", Locale.GERMAN.getLanguage()));
    OWLAnnotation jpAnnotation = factory.getOWLAnnotation(comment, factory.getOWLLiteral("プロパティのコメント", Locale.JAPANESE.getLanguage()));

    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), deAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), enAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), jpAnnotation));


    OWLAnnotation enClassAnnotation = factory.getOWLAnnotation(comment, factory.getOWLLiteral("Comment of a class", Locale.ENGLISH.getLanguage()));
    OWLAnnotation deClassAnnotation = factory.getOWLAnnotation(comment, factory.getOWLLiteral("Kommentar einer Klasse", Locale.GERMAN.getLanguage()));
    OWLAnnotation jpClassAnnotation = factory.getOWLAnnotation(comment, factory.getOWLLiteral("どうもありがとうミスターロボット", Locale.JAPANESE.getLanguage()));

    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(range.getIRI(), enClassAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(range.getIRI(), deClassAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(range.getIRI(), jpClassAnnotation));

    addToGenericDomainAndNewRange(property, range);
  }

  @Override
  public String getName() {
    return "rdfs:comment (Class & Property, multilingual)";
  }

  @Override
  public String getToken() {
    return "rdfscommentmultilanguage";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
