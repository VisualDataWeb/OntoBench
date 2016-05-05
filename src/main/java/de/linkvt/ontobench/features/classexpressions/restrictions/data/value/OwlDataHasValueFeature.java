package de.linkvt.ontobench.features.classexpressions.restrictions.data.value;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataHasValueFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLDataProperty(":dataHasValueProperty", pm);

    OWLDataHasValue restriction = factory.getOWLDataHasValue(property, factory.getOWLLiteral(6));
    addToGenericDomainAndNewRange(property, OWL2Datatype.XSD_NON_NEGATIVE_INTEGER.getDatatype(factory));

    OWLClass hasValue = featurePool.getExclusiveClass(":DataHasValue");
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(hasValue, restriction));
  }

  @Override
  public String getName() {
    return "owl:hasValue";
  }

  @Override
  public String getToken() {
    return "hasvaluedata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_RESTRICTIONS;
  }
}
