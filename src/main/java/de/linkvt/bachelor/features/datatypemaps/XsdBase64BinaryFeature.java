package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdBase64BinaryFeature extends AbstractDatatypeMapFeature {

  public XsdBase64BinaryFeature() {
    super(OWL2Datatype.XSD_BASE_64_BINARY);
  }

}
