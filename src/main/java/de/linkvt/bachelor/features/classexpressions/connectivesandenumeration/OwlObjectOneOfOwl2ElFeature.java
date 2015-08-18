package de.linkvt.bachelor.features.classexpressions.connectivesandenumeration;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectOneOfOwl2ElFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual black = factory.getOWLNamedIndividual(":BarackObama", pm);
    OWLObjectOneOf oneOf = factory.getOWLObjectOneOf(black);

    OWLClass oneOfClass = featurePool.getExclusiveClass(":PresidentOfTheUsaIn2015");

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(oneOfClass, oneOf));
  }

  @Override
  public String getName() {
    return "owl:oneOf (Class, OWL 2 EL)";
  }

  @Override
  public String getToken() {
    return "oneofsingleclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CONNECTIVES_AND_ENUMERATION;
  }
}
