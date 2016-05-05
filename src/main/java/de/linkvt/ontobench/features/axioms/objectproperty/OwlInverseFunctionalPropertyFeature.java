package de.linkvt.ontobench.features.axioms.objectproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlInverseFunctionalPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":inverseFunctionalObjectProperty");
    OWLClass range = featurePool.getExclusiveClass(":InverseFunctionalObjectPropertyRange");
    addToGenericDomainAndNewRange(property, range);

    OWLAxiom axiom = factory.getOWLInverseFunctionalObjectPropertyAxiom(property);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:InverseFunctionalProperty";
  }

  @Override
  public String getToken() {
    return "inversefunctionalprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
  }
}
