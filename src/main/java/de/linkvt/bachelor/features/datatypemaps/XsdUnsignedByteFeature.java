package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdUnsignedByteFeature extends AbstractDatatypeMapFeature {

  public XsdUnsignedByteFeature() {
    super(OWL2Datatype.XSD_UNSIGNED_BYTE);
  }

}
