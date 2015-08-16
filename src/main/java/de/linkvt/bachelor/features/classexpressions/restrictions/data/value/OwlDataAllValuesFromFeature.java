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
    OWLDataProperty property = factory.getOWLDataProperty(":zipCode", pm);
    OWLDatatype datatype = OWL2Datatype.XSD_INTEGER.getDatatype(factory);
    addToGenericDomainAndNewRange(property, datatype);
    OWLDataAllValuesFrom restriction = factory.getOWLDataAllValuesFrom(property, datatype);

    OWLClass address = featurePool.getExclusiveClass(":Address");
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(address, restriction));
  }

  @Override
  public String getName() {
    return "owl:allValuesFrom (Data Property)";
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
