package de.linkvt.bachelor.features.classexpressions.restrictions.data.value;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataAllValuesFromFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLDataProperty(":dataAllValuesFromProperty", pm);
    OWLDatatype value = OWL2Datatype.XSD_INTEGER.getDatatype(factory);
    addToGenericDomainAndNewRange(property, value);

    OWLDataAllValuesFrom restriction = factory.getOWLDataAllValuesFrom(property, value);

    OWLClass allValuesFrom = featurePool.getExclusiveClass(":DataAllValuesFrom");
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(allValuesFrom, restriction));
  }

  @Override
  public String getName() {
    return "owl:allValuesFrom";
  }

  @Override
  public String getToken() {
    return "allvaluesdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_RESTRICTIONS;
  }
}
