package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdUnsignedLongFeature extends AbstractDatatypeMapFeature {

  public XsdUnsignedLongFeature() {
    super(OWL2Datatype.XSD_UNSIGNED_LONG);
  }

}
