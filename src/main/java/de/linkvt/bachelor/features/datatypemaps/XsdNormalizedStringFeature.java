package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdNormalizedStringFeature extends AbstractDatatypeMapFeature {

  public XsdNormalizedStringFeature() {
    super(OWL2Datatype.XSD_NORMALIZED_STRING);
  }

}
