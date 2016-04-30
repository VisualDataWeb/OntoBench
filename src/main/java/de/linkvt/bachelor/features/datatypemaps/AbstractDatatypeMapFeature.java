package de.linkvt.bachelor.features.datatypemaps;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.apache.commons.lang3.text.WordUtils;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

public abstract class AbstractDatatypeMapFeature extends Feature {

  private final OWL2Datatype datatype;
  private final String name;
  private final String token;

  public AbstractDatatypeMapFeature(OWL2Datatype datatype) {
    this.datatype = datatype;
    this.name = datatype.getPrefixedName();
    this.token = datatype.getPrefixedName().replaceAll(":", "").toLowerCase();
  }

  @Override
  public void addToOntology() {
    OWLClass domain = featurePool.getExclusiveClass(":DatatypeMapsDomain");
    OWLDatatype range = factory.getOWLDatatype(datatype);

    String namespace = datatype.getPrefixedName().split(":")[0];
    String name = datatype.getShortForm();
    String propertyIri = ":" + namespace + WordUtils.capitalize(name) + "Property";
    OWLDataProperty property = factory.getOWLDataProperty(propertyIri, pm);

    addProperty(domain, property, range);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getToken() {
    return token;
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATATYPE_MAPS;
  }
}
