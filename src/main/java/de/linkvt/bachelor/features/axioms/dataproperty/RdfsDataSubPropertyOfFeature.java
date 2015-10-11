package de.linkvt.bachelor.features.axioms.dataproperty;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

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

    OWLDataProperty subProperty = factory.getOWLDataProperty(":subDataProperty", pm);
    OWLDataProperty superProperty = factory.getOWLDataProperty(":superDataProperty", pm);
    addProperty(start, subProperty, subRange);
    addProperty(start, superProperty, superRange);

    addAxiomToOntology(factory.getOWLSubDataPropertyOfAxiom(subProperty, superProperty));
  }

  @Override
  public String getName() {
    return "rdfs:subPropertyOf";
  }

  @Override
  public String getToken() {
    return "subpropdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTIES;
  }
}
