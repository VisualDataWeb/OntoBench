package de.linkvt.bachelor.features.axioms.objectproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class RdfsObjectDomainFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass(":Domain");
    OWLObjectProperty objectProperty = featurePool.getExclusiveProperty(":NoRangeObjectProperty");
    OWLAxiom axiom = factory.getOWLObjectPropertyDomainAxiom(objectProperty, domain);

    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "rdfs:domain (Object Property)";
  }

  @Override
  public String getToken() {
    return "domainobject";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_AXIOMS;
  }
}
