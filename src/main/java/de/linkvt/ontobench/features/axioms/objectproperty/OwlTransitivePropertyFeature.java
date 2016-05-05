package de.linkvt.ontobench.features.axioms.objectproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlTransitivePropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":transitiveObjectProperty");
    OWLClass range = featurePool.getExclusiveClass(":TransitiveObjectPropertyRange");
    addToGenericDomainAndNewRange(property, range);

    OWLAxiom axiom = factory.getOWLTransitiveObjectPropertyAxiom(property);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:TransitiveProperty";
  }

  @Override
  public String getToken() {
    return "transitiveprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
  }
}
