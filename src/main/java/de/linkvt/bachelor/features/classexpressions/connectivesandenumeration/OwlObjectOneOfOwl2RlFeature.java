package de.linkvt.bachelor.features.classexpressions.connectivesandenumeration;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectOneOfOwl2RlFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual lincoln = factory.getOWLNamedIndividual(":AbrahamLincoln", pm);
    OWLNamedIndividual nixon = factory.getOWLNamedIndividual(":RichardNixon", pm);
    OWLObjectOneOf oneOf = factory.getOWLObjectOneOf(nixon, lincoln);

    OWLClass oneOfClass = featurePool.getExclusiveClass(":PresidentsOfTheUsa");

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(oneOf, oneOfClass));
  }

  @Override
  public String getName() {
    return "owl:oneOf (Class, OWL 2 RL)";
  }

  @Override
  public String getToken() {
    return "oneofrlclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CONNECTIVES_AND_ENUMERATION;
  }
}
