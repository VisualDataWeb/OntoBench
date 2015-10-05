package de.linkvt.bachelor.features.special.individuals;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public abstract class MultipleIndividualsFeature extends Feature {

  private String baseIri;
  private int individualCount;

  public MultipleIndividualsFeature(String baseIri, int individualCount) {
    this.baseIri = baseIri;
    this.individualCount = individualCount;
  }

  @Override
  public void addToOntology() {
    OWLClass clazz = featurePool.getExclusiveClass(baseIri);
    List<OWLNamedIndividual> individuals = new ArrayList<>(individualCount);

    for (int i = 1; i <= individualCount; i++) {
      individuals.add(factory.getOWLNamedIndividual(baseIri + "_" + i, pm));
    }

    individuals.forEach(individual -> addAxiomToOntology(factory.getOWLClassAssertionAxiom(clazz, individual)));
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.SPECIAL_TEST_CASES;
  }

  @Override
  public String getName() {
    return individualCount + " instances of a class";
  }

  @Override
  public String getToken() {
    return individualCount + "instances";
  }

}
