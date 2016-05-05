package de.linkvt.ontobench.features.individuals;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLClass;
import org.springframework.stereotype.Component;

@Component
public class AnonymousIndividualFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass clazz = featurePool.getReusableClass();
    OWLAnonymousIndividual individual = factory.getOWLAnonymousIndividual();

    addAxiomToOntology(factory.getOWLClassAssertionAxiom(clazz, individual));
  }

  @Override
  public String getName() {
    return "Anonymous Individual";
  }

  @Override
  public String getToken() {
    return "anonymousindividual";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.INDIVIDUALS;
  }
}
