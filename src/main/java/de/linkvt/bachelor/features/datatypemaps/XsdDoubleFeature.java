package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdDoubleFeature extends AbstractDatatypeMapFeature {

  public XsdDoubleFeature() {
    super(OWL2Datatype.XSD_DOUBLE);
  }

}
