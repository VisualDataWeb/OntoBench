package de.linkvt.bachelor.features.classes.values;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlHasValueClassFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty hasSugar = featurePool.getExclusiveProperty("hasSugar");

    OWLClass burgundy = featurePool.getExclusiveClass("Burgundy");
    OWLIndividual dry = factory.getOWLNamedIndividual(IRI.create("Dry"));

    OWLObjectHasValue restriction = factory.getOWLObjectHasValue(hasSugar, dry);
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(burgundy, restriction));
  }

  @Override
  public String getName() {
    return "owl:hasValue";
  }

  @Override
  public String getToken() {
    return "hasvalue";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
