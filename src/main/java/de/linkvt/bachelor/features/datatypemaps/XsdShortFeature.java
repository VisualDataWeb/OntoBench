package de.linkvt.bachelor.features.datatypemaps;

import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class XsdShortFeature extends AbstractDatatypeMapFeature {

  public XsdShortFeature() {
    super(OWL2Datatype.XSD_SHORT);
  }

}
