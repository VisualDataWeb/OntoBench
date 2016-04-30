package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdDecimalFeature extends AbstractDatatypeMapFeature {

  public XsdDecimalFeature() {
    super(OWL2Datatype.XSD_DECIMAL);
  }

}
