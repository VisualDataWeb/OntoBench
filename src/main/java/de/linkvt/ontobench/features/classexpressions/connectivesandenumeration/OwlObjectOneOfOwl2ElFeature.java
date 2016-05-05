package de.linkvt.ontobench.features.classexpressions.connectivesandenumeration;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectOneOfOwl2ElFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual individual = factory.getOWLNamedIndividual(":ObjectOneOf_EL_Individual", pm);
    OWLObjectOneOf oneOf = factory.getOWLObjectOneOf(individual);

    OWLClass oneOfClass = featurePool.getExclusiveClass(":ObjectOneOf_EL");

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(oneOfClass, oneOf));
  }

  @Override
  public String getName() {
    return "owl:oneOf";
  }

  @Override
  public String getCompliance() {
    return "OWL 2 EL";
  }

  @Override
  public String getToken() {
    return "oneofsingleclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS_EXPRESSIONS;
  }
}
