package de.linkvt.ontobench.features.classexpressions.restrictions.data.cardinality;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataMinCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLDataProperty(":dataMinCardinality", pm);
    OWLDatatype datatype = OWL2Datatype.XSD_BOOLEAN.getDatatype(factory);
    addToGenericDomainAndNewRange(property, datatype);

    OWLClass range = featurePool.getExclusiveClass(":DataMinCardinalityRange");
    OWLDataMinCardinality cardinality = factory.getOWLDataMinCardinality(3, property);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, cardinality));
  }

  @Override
  public String getName() {
    return "owl:minCardinality";
  }

  @Override
  public String getToken() {
    return "mincardinalitydata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_RESTRICTIONS;
  }
}
