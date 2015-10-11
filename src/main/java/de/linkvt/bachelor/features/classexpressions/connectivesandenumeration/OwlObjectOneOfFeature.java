package de.linkvt.bachelor.features.classexpressions.connectivesandenumeration;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectOneOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLNamedIndividual i1 = factory.getOWLNamedIndividual(":ObjectOneOf_Individual1", pm);
    OWLNamedIndividual i2 = factory.getOWLNamedIndividual(":ObjectOneOf_Individual2", pm);
    OWLObjectOneOf oneOf = factory.getOWLObjectOneOf(i1, i2);

    OWLClass oneOfClass = featurePool.getExclusiveClass(":ObjectOneOf");

    addAxiomToOntology(factory.getOWLEquivalentClassesAxiom(oneOfClass, oneOf));
  }

  @Override
  public String getName() {
    return "owl:oneOf";
  }

  @Override
  public String getToken() {
    return "oneofclass";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS_EXPRESSIONS;
  }
}
