package de.linkvt.ontobench.features.axioms.dataproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class RdfsDataRangeFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype datatype = OWL2Datatype.RDFS_LITERAL.getDatatype(factory);
    OWLDataProperty objectProperty = factory.getOWLDataProperty(":noDomainDataProperty", pm);

    addAxiomToOntology(factory.getOWLDataPropertyRangeAxiom(objectProperty, datatype));
  }

  @Override
  public String getName() {
    return "rdfs:range";
  }

  @Override
  public String getToken() {
    return "rangedata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_PROPERTIES;
  }
}
