package de.linkvt.bachelor.features.classexpressions.restrictions.data.value;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataSomeValuesFromFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLDataProperty(":dataSomeValuesFromProperty", pm);
    OWLDatatype datatype = OWL2Datatype.XSD_DATE_TIME.getDatatype(factory);

    OWLClass someValuesFrom = featurePool.getExclusiveClass(":DataSomeValuesFrom");
    OWLDataSomeValuesFrom restriction = factory.getOWLDataSomeValuesFrom(property, datatype);
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(someValuesFrom, restriction));
  }

  @Override
  public String getName() {
    return "owl:someValuesFrom";
  }

  @Override
  public String getToken() {
    return "somevaluesdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_RESTRICTIONS;
  }
}
