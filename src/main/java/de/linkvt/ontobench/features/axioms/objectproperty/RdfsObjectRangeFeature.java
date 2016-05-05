package de.linkvt.ontobench.features.axioms.objectproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class RdfsObjectRangeFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass range = featurePool.getExclusiveClass(":Range");
    OWLObjectProperty objectProperty = featurePool.getExclusiveProperty(":noDomainObjectProperty");
    OWLAxiom axiom = factory.getOWLObjectPropertyRangeAxiom(objectProperty, range);

    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "rdfs:range";
  }

  @Override
  public String getToken() {
    return "rangeobject";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
  }
}
