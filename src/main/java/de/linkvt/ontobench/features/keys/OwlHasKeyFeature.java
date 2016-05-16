package de.linkvt.ontobench.features.keys;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlHasKeyFeature extends Feature {

  @Override
  public void addToOntology() {
    OWLClass hasKeyClass = featurePool.getExclusiveClass(":HasKeyClass");

    OWLDataProperty hasKeyProperty1 = factory.getOWLDataProperty(":hasKeyProperty_1", pm);
    OWLDatatype hasKeyRange1 = OWL2Datatype.XSD_STRING.getDatatype(factory);
    addProperty(hasKeyClass, hasKeyProperty1, hasKeyRange1);

    OWLObjectProperty hasKeyProperty_2 = featurePool.getExclusiveProperty(":hasKeyProperty_2");
    OWLClass hasKeyRange2 = featurePool.getExclusiveClass(":HasKeyPropertyRange_2");
    addProperty(hasKeyClass, hasKeyProperty_2, hasKeyRange2);

    addAxiomToOntology(factory.getOWLHasKeyAxiom(hasKeyClass, hasKeyProperty1, hasKeyProperty_2));
  }

  @Override
  public String getName() {
    return "owl:hasKey";
  }

  @Override
  public String getToken() {
    return "haskey";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ASSERTIONS;
  }
}
