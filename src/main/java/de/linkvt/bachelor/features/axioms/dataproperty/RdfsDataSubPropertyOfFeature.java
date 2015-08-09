package de.linkvt.bachelor.features.axioms.dataproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class RdfsDataSubPropertyOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLClass start = featurePool.getReusableClass();
    OWLDatatype subRange = OWL2Datatype.XSD_STRING.getDatatype(factory);
    OWLDatatype superRange = OWL2Datatype.XSD_STRING.getDatatype(factory);

    OWLDataProperty subProperty = factory.getOWLDataProperty(IRI.create("SubDataProperty"));
    OWLDataProperty superProperty = factory.getOWLDataProperty(IRI.create("SuperDataProperty"));
    addProperty(start, subProperty, subRange);
    addProperty(start, superProperty, superRange);

    addAxiomToOntology(factory.getOWLSubDataPropertyOfAxiom(subProperty, superProperty));
  }

  @Override
  public String getName() {
    return "rdfs:subPropertyOf (Data Property)";
  }

  @Override
  public String getToken() {
    return "subpropdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTY_AXIOMS;
  }
}
