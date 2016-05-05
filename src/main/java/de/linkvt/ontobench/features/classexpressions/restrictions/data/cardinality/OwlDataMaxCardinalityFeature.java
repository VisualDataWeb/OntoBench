package de.linkvt.ontobench.features.classexpressions.restrictions.data.cardinality;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataMaxCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLDataProperty(":dataMaxCardinality", pm);
    OWLDatatype datatype = OWL2Datatype.XSD_FLOAT.getDatatype(factory);
    addToGenericDomainAndNewRange(property, datatype);

    OWLClass range = featurePool.getExclusiveClass(":DataMaxCardinalityRange");
    OWLDataMaxCardinality cardinality = factory.getOWLDataMaxCardinality(19, property);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, cardinality));
  }

  @Override
  public String getName() {
    return "owl:maxCardinality";
  }

  @Override
  public String getToken() {
    return "maxcardinalitydata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_RESTRICTIONS;
  }
}
