package de.linkvt.bachelor.features.classexpressions.restrictions.object.value;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectHasValueFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty hasSugar = featurePool.getExclusiveProperty(":hasSugar");

    OWLClass burgundy = featurePool.getExclusiveClass(":Burgundy");
    OWLIndividual dry = factory.getOWLNamedIndividual(IRI.create(":Dry"));

    OWLObjectHasValue restriction = factory.getOWLObjectHasValue(hasSugar, dry);
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(burgundy, restriction));
  }

  @Override
  public String getName() {
    return "owl:hasValue (Object Property)";
  }

  @Override
  public String getToken() {
    return "hasvalueobject";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
