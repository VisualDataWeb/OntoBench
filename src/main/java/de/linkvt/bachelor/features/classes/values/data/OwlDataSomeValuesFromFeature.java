package de.linkvt.bachelor.features.classes.values.data;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
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
    OWLDataProperty property = factory.getOWLDataProperty(IRI.create("someValuesFromData"));
    OWLDatatype datatype = OWL2Datatype.XSD_DATE_TIME.getDatatype(factory);
    addToGenericDomainAndNewRange(property, datatype);

    OWLClass range = featurePool.getExclusiveClass("SomeValuesFromDataRange");
    OWLDataSomeValuesFrom restriction = factory.getOWLDataSomeValuesFrom(property, datatype);
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, restriction));
  }

  @Override
  public String getName() {
    return "owl:someValuesFrom (Data Property)";
  }

  @Override
  public String getToken() {
    return "somevaluesclassdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
