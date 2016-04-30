package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdLongFeature extends AbstractDatatypeMapFeature {

  public XsdLongFeature() {
    super(OWL2Datatype.XSD_LONG);
  }

}
