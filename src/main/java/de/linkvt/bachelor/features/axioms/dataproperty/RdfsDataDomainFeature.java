package de.linkvt.bachelor.features.axioms.dataproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.springframework.stereotype.Component;

@Component
public class RdfsDataDomainFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass(":Domain");
    OWLDataProperty objectProperty = factory.getOWLDataProperty(IRI.create(":NoRangeDataProperty"));

    addAxiomToOntology(factory.getOWLDataPropertyDomainAxiom(objectProperty, domain));
  }

  @Override
  public String getName() {
    return "rdfs:domain (Data Property)";
  }

  @Override
  public String getToken() {
    return "domaindata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_AXIOMS;
  }
}
