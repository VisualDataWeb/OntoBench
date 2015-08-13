package de.linkvt.bachelor.features.keys;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlHasKeyFeature extends Feature {

  @Override
  public void addToOntology() {
    OWLClass person = featurePool.getExclusiveClass("Person");
    OWLDataProperty taxId = factory.getOWLDataProperty(IRI.create("taxId"));
    addProperty(person, taxId, OWL2Datatype.XSD_STRING.getDatatype(factory));

    OWLObjectProperty hasHomeland = featurePool.getExclusiveProperty("hasHomeland");
    OWLClass country = featurePool.getExclusiveClass("Country");
    addProperty(person, hasHomeland, country);

    addAxiomToOntology(factory.getOWLHasKeyAxiom(person, taxId, hasHomeland));
  }

  @Override
  public String getName() {
    return "owl:HasKey";
  }

  @Override
  public String getToken() {
    return "haskey";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.KEYS;
  }
}
