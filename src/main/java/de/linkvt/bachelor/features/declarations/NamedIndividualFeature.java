package de.linkvt.bachelor.features.declarations;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.springframework.stereotype.Component;

@Component
public class NamedIndividualFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass clazz = featurePool.getReusableClass();
    OWLNamedIndividual individual = factory.getOWLNamedIndividual(IRI.create("AnIndividual"));

    addAxiomToOntology(factory.getOWLClassAssertionAxiom(clazz, individual));
  }

  @Override
  public String getName() {
    return "Named Individual";
  }

  @Override
  public String getToken() {
    return "namedindividual";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DECLARATIONS;
  }
}
